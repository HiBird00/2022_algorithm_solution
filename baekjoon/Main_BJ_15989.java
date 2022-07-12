package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_15989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] dp = new int[10001][4];
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		for(int j=0; j<N; j++) {
			int n = Integer.parseInt(in.readLine());
			for(int i=4; i<=n; i++) {
				dp[i][1]= dp[i-1][1];
				dp[i][2] = dp[i-2][1]+dp[i-2][2];
				dp[i][3] = dp[i-3][1]+dp[i-3][2]+dp[i-3][3];
			}
			System.out.println(dp[n][1]+dp[n][2]+dp[n][3]);
		}
	}
}
