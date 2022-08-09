package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_17090 {

	public static int N, M;
	public static int map[][];
	public static int dr[] = { 0, 0, 1, -1 }; // R, L, D, U
	public static int dc[] = { 1, -1, 0, 0 };
	public static boolean dp[][], visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new boolean[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			char[] temp = in.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				char ch = temp[j];
				if(ch == 'R') map[i][j] = 0;
				if(ch == 'L') map[i][j] = 1;
				if(ch == 'D') map[i][j] = 2;
				if(ch == 'U') map[i][j] = 3;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for(int j=0; j<M; j++) {
				if(dp[i][j]) continue;
				solve(i, j);
			}
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			for(int j=0; j<M; j++) {
				if(dp[i][j]) answer++;
			}
		}
		System.out.println(answer);
	}
	
	public static boolean solve(int r, int c) {
		if(r < 0 || r >= N || c < 0 || c >= M) return true;
		
		if(dp[r][c]) return true;
		if(visited[r][c]) return false;
		
		visited[r][c] = true;
		dp[r][c] = solve(r + dr[map[r][c]], c + dc[map[r][c]]);
		return dp[r][c];
	}

}
