package baekjoon;

import java.util.Scanner;

public class Main_BJ_17088 {

	public static int N, arr[], answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		solve(0, arr[0], 0, 0);
		solve(0, arr[0]-1, 0, 1);
		solve(0, arr[0]+1, 0, 1);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	public static void solve(int idx, int current, int diff, int cnt) {
		if (idx == N - 1) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		
		int origin = arr[idx+1] - current; // 다음꺼랑 차이
		if(idx == 0 || origin == diff) {
			// 차이가 같다면
			solve(idx+1, arr[idx+1], origin, cnt);
		}
		
		if(idx == 0 ||origin - 1 == diff) {
			// 차이가 하나 작다면 -1
			solve(idx+1, arr[idx+1]-1, origin - 1, cnt+1);
		}
		
		if(idx == 0 ||origin + 1 == diff) {
			solve(idx+1, arr[idx+1]+1, origin + 1, cnt+1);
		}
	}

}
