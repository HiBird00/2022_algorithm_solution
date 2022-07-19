package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_16637 {
	
	public static char[] arr;
	public static boolean[] visited;
	public static int answer = Integer.MIN_VALUE;
	public static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = in.readLine().toCharArray();
		
		solve(0, 0);
		System.out.println(answer);
	}
	
	public static void solve(int idx, int prev) {
		if(idx >= N) {
			answer = Math.max(answer, prev);
			return;
		}
		
		char op = (idx == 0) ? '+' : arr[idx-1];
		
		// 괄호 안묶음
		int temp = calc(prev, arr[idx]-'0', op);
		solve(idx+2, temp);
		
		// 괄호 묶음
		if(idx < N-2) {
			// 괄호쪽 계산
			temp = calc(arr[idx]-'0', arr[idx+2]-'0', arr[idx+1]);
			// 괄호와 이전 값 계산
			temp = calc(prev, temp, op);
		}
		solve(idx+4, temp);
		
	}
	
	public static int calc(int a, int b, char op) {
		switch(op) {
		case '+' : 
			return a+b;
		case '-' : 
			return a-b;
		case '*' :
			return a*b;
		}
		return 0;
	}
}
