package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_15683 {

	public static int answer = Integer.MAX_VALUE;
	public static List<CCTV> cctvs = new ArrayList<>();  
	public static int[][][][] rotate = {
			{{{}}},
			{{{0,1}},{{1,0}},{{0,-1}},{{-1,0}}}, // 1
			{{{0,1},{0,-1}},{{1,0},{-1,0}}}, // 2
			{{{0,1},{1,0}},{{1,0},{0,-1}},{{0,-1},{-1,0}},{{0,1},{-1,0}}}, // 3
			{{{-1,0},{0,-1},{0,1}},{{-1,0},{0,1},{1,0}},{{0,-1},{1,0},{0,1}},{{-1,0},{0,-1},{1,0}}}, // 4
			{{{0,1},{1,0},{0,-1},{-1,0}}}, // 5
	};
	
	public static class CCTV {
		int r, c, n;
		
		CCTV(int r, int c, int n) {
			this.r = r;
			this.c = c;
			this.n = n;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++ ) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++ ) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if(n > 0 && n < 6) cctvs.add(new CCTV(i, j, n));
			}
		}
		
		solve(0, map);
		System.out.println(answer);
	}
	
	public static void solve(int idx, int[][] map) {
		if(idx == cctvs.size()) {
			// 사각지대 검사
			answer = Math.min(answer, check(map));
			return;
		}
		
		int[][] newMap = new int[map.length][map[0].length];
		
		CCTV cctv = cctvs.get(idx);
		int[][][] dir = rotate[cctv.n];
		for(int i=0; i<dir.length; i++) {
			// 회전 수
			copyMap(map, newMap); // 맵 카피
			int[][] temp = dir[i];
			for(int j=0; j<temp.length; j++) {
				int[] pos = temp[j];
				int nr = cctv.r + pos[0];
				int nc = cctv.c + pos[1];
				while(nr >= 0 && nr < map.length && nc >=0 && nc < map[0].length && map[nr][nc] != 6) {
					if(map[nr][nc] == 0) newMap[nr][nc] = -1;
					nr += pos[0];
					nc += pos[1];
				}
			}
			solve(idx+1, newMap);
		}
		
	}
	
	public static int check(int[][] map) {
		int cnt = 0;
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				if(map[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}
	
	public static void copyMap(int[][] map, int[][] newMap) {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}
	
}
