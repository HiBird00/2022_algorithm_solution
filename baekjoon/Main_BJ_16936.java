package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_16936 {

	public static int N;
	public static long[] arr;
	public static boolean[] visited;
	public static int[] selected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new long[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		selected = new int[N];
		for(int i=0; i<N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			selected[0] = i;
			if(solve(i, 1)) break;
		}
	}
	
	public static boolean solve(int cIdx, int cnt) {
		if(cnt == N) {
			for(int i=0; i<N; i++) {
				System.out.print(arr[selected[i]] + " ");
			}
			return true;
		}

		long n = arr[cIdx]; // 현재 인덱스
		for(int i=0; i<N; i++) {
			if(visited[i]) continue; // 이미 방문했던 요소라면 넘김
			if(n % 3 == 0 && arr[i] == n/3) {
				visited[i] = true;
				selected[cnt] = i;
				if(solve(i, cnt+1)) return true;
				visited[i] = false;
			}
			if(arr[i] == n*2) {
				visited[i] = true;
				selected[cnt] = i;
				if(solve(i, cnt+1)) return true;
				visited[i] = false;
			}
		}
		return false;
		
	}
	
}
