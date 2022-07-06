package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_10815 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		int[] answer = new int[M];
		for(int i=0; i<M; i++) {
			int n = Integer.parseInt(st.nextToken());
			answer[i] = solve(0, N-1, n, arr) ? 1 : 0;
		}
		
		for(int i=0; i<M; i++) {
			System.out.print(answer[i] + " ");
		}
	}
	
	public static boolean solve(int left, int right, int n, int[] arr) {
		if(left > right) return false;
		
		int mid = (left+right) / 2;
		if(arr[mid] == n) return true;
		if(arr[mid] > n) {
			if(solve(left, mid-1, n, arr)) return true;
		}else {
			if(solve(mid+1, right, n, arr)) return true;
		}
		return false;
	}

}
