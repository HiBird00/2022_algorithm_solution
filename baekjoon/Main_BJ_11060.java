package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_11060 {

	public static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		Arrays.fill(dp, INF);
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = 0;
		for(int i=0; i<N; i++) {
			if(dp[i] == INF) continue;
			for(int j=1; j<=arr[i] && i+j < N; j++) {
				dp[i+j] = Math.min(dp[i+j], dp[i]+1);
			}
		}
		
		if(dp[N-1] == INF) System.out.println(-1);
		else System.out.println(dp[N-1]);
	}

}
