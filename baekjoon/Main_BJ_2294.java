package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_2294 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		int[] dp = new int[k+1];
		int INF = Integer.MAX_VALUE;
		Arrays.fill(dp, INF);
		dp[0] = 0;
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<n; i++) {
			for(int j=arr[i]; j<=k; j++) {
				if(dp[j-arr[i]] == INF) continue;
				dp[j] = Math.min(dp[j], dp[j-arr[i]]+1);
			}
		}
		System.out.println(dp[k] == INF ? -1 : dp[k]);
	}

}
