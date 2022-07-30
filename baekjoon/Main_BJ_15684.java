package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_15684 {
	
	public static int answer = Integer.MAX_VALUE;
	public static int N, M, H;
	public static boolean matrix[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		matrix = new boolean[H + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			matrix[a][b] = true;
		}
		
		solve(1,1,0);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	
	public static void solve(int r, int c, int cnt) {
		if(cnt > 3) return;
		boolean status = true;
		for(int i=1; i<=N; i++) {
			if(!check(i)) {
				status = false;
				break;
			}
		}
		if(status) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		for(int i=r; i<=H; i++) {
			for(int j=c; j<N; j++) {
				if(matrix[i][j] || (j - 1 > 0 && matrix[i][j-1]) || (j+1 <= N && matrix[i][j+1])) continue; // 가로가 연속적이라면 잇지 못함
				matrix[i][j] = true;
				solve(i, j+1, cnt+1);
				matrix[i][j] = false;
			}
			c = 1;
		}
	}
	
	public static boolean check(int start) {
		int current = start;
		for(int i=1; i<=H; i++) {
			if(matrix[i][current]) {
				current = current+1;
			}else if(current-1>0 && matrix[i][current-1]) {
				current = current-1;
			}
		}
		if(start == current) return true;
		return false;
	}

}
