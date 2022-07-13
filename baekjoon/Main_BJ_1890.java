package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1890 {

	public static int[][] map;
	public static long[][] dp;
	public static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		dp = new long[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(dp[i], -1);
		}

		System.out.println(solve(0, 0));
	}

	public static long solve(int r, int c) {
		if (r == N - 1 && c == N - 1) {
			return 1;
		}

		if (r >= N || c >= N)
			return 0;

		if (dp[r][c] != -1)
			return dp[r][c];

		dp[r][c] = 0;
		dp[r][c] += solve(r + map[r][c], c);
		dp[r][c] += solve(r, c + map[r][c]);

		return dp[r][c];
	}

}
