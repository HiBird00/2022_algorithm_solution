package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_15486 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] dp= new int[N+1];
		int[][] arr = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=N-1; i>=0; i--) {
			if(arr[i][0] + i > N) {
				dp[i] = dp[i+1];
			}else {
				dp[i] = Math.max(dp[i+1], arr[i][1] + dp[i+arr[i][0]]);
			}
		}
		
		int answer = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}

}
