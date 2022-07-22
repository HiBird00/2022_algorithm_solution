package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_16987 {
	
	public static int answer = Integer.MIN_VALUE;
	public static int[][] eggs;
	public static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		eggs = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			eggs[i][0] = Integer.parseInt(st.nextToken());
			eggs[i][1] = Integer.parseInt(st.nextToken());
		}
		
		solve(0, 0);
		System.out.println(answer);
		
	}
	
	public static void solve(int idx, int cnt) {
		if(idx == N) {
			answer = Math.max(answer, cnt);
			return;
		}
		
		if(eggs[idx][0] <= 0) {
			solve(idx+1, cnt);
			return;
		}
		
		boolean status = false;
		for(int i=0; i<N; i++) {
			if(idx == i || eggs[i][0] <= 0) continue;
			eggs[i][0] -= eggs[idx][1];
			eggs[idx][0] -= eggs[i][1];
			int count = 0;
			status = true;
			if(eggs[i][0] <= 0) count++; 
			if(eggs[idx][0] <= 0) count++; 
			solve(idx+1, cnt+count);
			eggs[i][0] += eggs[idx][1];
			eggs[idx][0] += eggs[i][1];
		}
		if(!status) solve(idx+1, cnt); // 칠 수 있는 달걀이 없는 경우
	}

}
