package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Bj_12869 {

	public static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[3];
		int[][][] dp = new int[61][61][61];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(solve(dp, arr[0], arr[1], arr[2]));
	}
	
	public static int solve(int[][][] dp, int x, int y, int z) {
		if(x < 0) return solve(dp, 0, y, z);
		if(y < 0) return solve(dp, x, 0, z);
		if(z < 0) return solve(dp, x, y, 0);
		
		if(x == 0 && y == 0 && z == 0) return 0;
		
		if(dp[x][y][z] != 0) return dp[x][y][z];
		
		dp[x][y][z] = INF;
		dp[x][y][z] = Math.min(dp[x][y][z], solve(dp, x-9, y-3, z-1) + 1);
		dp[x][y][z] = Math.min(dp[x][y][z], solve(dp, x-9, y-1, z-3) + 1);
		dp[x][y][z] = Math.min(dp[x][y][z], solve(dp, x-3, y-9, z-1) + 1);
		dp[x][y][z] = Math.min(dp[x][y][z], solve(dp, x-3, y-1, z-9) + 1);
		dp[x][y][z] = Math.min(dp[x][y][z], solve(dp, x-1, y-9, z-3) + 1);
		dp[x][y][z] = Math.min(dp[x][y][z], solve(dp, x-1, y-3, z-9) + 1);
		
		return dp[x][y][z];
		
	}

}
