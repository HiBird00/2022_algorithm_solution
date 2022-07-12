package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Main_BJ_10422 {

	public static final int MOD = 1000000007;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		long[] dp = new long[5001];
		dp[0] = 1;
		dp[2] = 1;
		for(int j=4; j<5001; j+=2) {
			for(int j2=0; j2<=j-2; j2+=2) {
				dp[j] =( dp[j] + (dp[j-2-j2] * dp[j2]) ) % MOD;
			}
		}
		
		int T = sc.nextInt();
		for(int i=0; i<T;i++) {
			System.out.println(dp[sc.nextInt()]);
		}
	}
}
