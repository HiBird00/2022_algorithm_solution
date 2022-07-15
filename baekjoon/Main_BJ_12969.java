package baekjoon;

import java.util.Scanner;

public class Main_BJ_12969 {
	
	public static boolean[][][][] dp;
	public static char[] ans;
	public static int N, K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		dp = new boolean[31][31][31][(N*(N-1))/2+1];
		ans = new char[31];
		
		if(K == 0) {
			for(int i=0; i<N; i++) {
				System.out.print('A');
			}
			return;
		}
		if(solve(0, 0, 0, K)) {
			for(int i=0; i<N; i++) {
				System.out.print(ans[i]);
			}
		}else {
			System.out.println(-1);
		}
		
	}
	
	public static boolean solve(int a, int b, int c, int k) {
		if(a + b + c == N) return (k==0);
		if(k <= 0) return false;
		if(dp[a][b][c][k]) return false; // 이전에 이미 방문했었지만, 답이 나오지 않았었음
		
		ans[a+b+c] = 'A';
		dp[a][b][c][k] = true;
		if(solve(a+1, b, c, k)) return true;
		ans[a+b+c] = 'B';
		if(solve(a, b+1, c, k-a))return true;
		ans[a+b+c] = 'C';
		if(solve(a, b, c+1, k-a-b)) return true;
		
		return false; 
	}
}
