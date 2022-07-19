package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_BJ_2210 {

	public static int[][] map = new int[5][5];
	public static int answer = 0;
	public static int[] dr = { 1, -1, 0, 0 };
	public static int[] dc = { 0, 0, 1, -1 };
	public static Map<String, Integer> hashmap = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				solve(i, j, "");
			}
		}
		
	System.out.println(hashmap.size());

	}

	public static void solve(int r, int c, String str) {
		if(str.length() == 6) {
			// 숫자 판단
			if(!hashmap.containsKey(str)) {
				hashmap.put(str, 1);
			}
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr >= 5 || nr < 0 || nc >= 5 || nc < 0) continue;
			solve(nr, nc, str+map[nr][nc]);
		}
	}
}
