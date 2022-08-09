package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16932 {
	
	public static int N, M, map[][], dp[][];
	public static int dr[] = {0, 0, 1, -1}; // 우, 좌, 하, 상
	public static int dc[] = {1, -1, 0, 0};
	public static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		
		Queue<int[]> one = new LinkedList<>();
		Queue<int[]> zero = new LinkedList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n == 1) one.add(new int[] {i, j});
				if(n == 0) zero.add(new int[] {i, j});
				map[i][j] = n;
			}
		}
		
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		int idx = 2;
		visited = new boolean[N][M];
		while(!one.isEmpty()) {
			int[] temp = one.poll(); // 1의 위치
			
			if(map[temp[0]][temp[1]] != 1) continue;
			
			visited[temp[0]][temp[1]] = true;
			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] {temp[0], temp[1]});
			
			int cnt = 1;
			while(!queue.isEmpty()) {
				int[] current = queue.poll();
				map[current[0]][current[1]] = idx;
				
				for(int i=0; i<4; i++) {
					int nr = current[0] + dr[i];
					int nc = current[1] + dc[i];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] != 1 || visited[nr][nc]) continue;
					visited[nr][nc] = true;
					queue.add(new int[] {nr, nc});
					cnt++;
				}
			}
			hashmap.put(idx, cnt);
			idx++;
		}
		
		int answer = 0;
		while(!zero.isEmpty()) {
			int[] current = zero.poll();
			HashMap<Integer, Boolean> checked = new HashMap<>();
			int result = 1;
			for(int i=0; i<4; i++) {
				int nr = current[0] + dr[i];
				int nc = current[1] + dc[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0) continue;
				if(checked.containsKey(map[nr][nc])) continue;
				checked.put(map[nr][nc], true);
				result += hashmap.get(map[nr][nc]);
			}
			answer = Math.max(answer, result);
		}
		System.out.println(answer);
	}

}
