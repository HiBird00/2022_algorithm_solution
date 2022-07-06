package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_16938 {
	
	public static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] ps = new int[N];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			ps[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=2; i<=N; i++ ) {
			int[] selected = new int[i];
			solve(N, L, R, X, 0, 0, i, selected, ps);			
		}
		System.out.println(answer);
	}
	
	public static void solve(int N, int L, int R, int X, int start, int cnt, int goal, int[] selected, int[] ps) {
		if(cnt == goal) {
			int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
			int sum = 0;
			for(int i=0; i<cnt; i++ ) {
				max = Math.max(max, ps[selected[i]]);
				min = Math.min(min, ps[selected[i]]);
				sum += ps[selected[i]];
				System.out.print(ps[selected[i]] + " ");
			}
			System.out.println();
			int diff = max-min;
			if(sum >= L && sum <= R && diff >= X) answer++;
			return;
		}
		
		for(int i=start; i<N; i++) {
			selected[cnt] = i;
			solve(N, L, R, X, i+1, cnt+1,goal, selected, ps);
		}
	}
}
