package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_11048 {

	public static int[][] map, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(solve(N-1, M-1));
	}
	
	public static int solve(int r, int c) {
		if(r == 0 && c == 0) {
			return map[r][c];
		}
		
		if(dp[r][c] != -1) return dp[r][c];
		dp[r][c] = 0;
		if(r -1 >= 0) dp[r][c] = Math.max(dp[r][c], map[r][c] + solve(r-1, c));
		if(r -1 >= 0 && c-1 >= 0) dp[r][c] = Math.max(dp[r][c], map[r][c] + solve(r-1, c-1));
		if(c -1 >= 0) dp[r][c] = Math.max(dp[r][c], map[r][c] + solve(r, c-1));
		return dp[r][c];
	}
	
	
	

}
