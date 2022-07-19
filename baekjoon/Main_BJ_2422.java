package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_2422 {

	public static boolean[][] notMixed;
	public static int answer = 0;
	public static int N, M;
	public static int[] selected = new int[3];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		notMixed = new boolean[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			notMixed[a][b] = notMixed[b][a] = true;
		}
		
		solve(1, 0);
		System.out.println(answer);
	}

	
	public static void solve(int idx, int cnt) {
		if(cnt == 3) {
			System.out.println(Arrays.toString(selected));
			for(int i=0; i<3; i++) {
				for(int j=i+1; j<3; j++) {
					if(notMixed[selected[i]][selected[j]]) return;
				}
			}
			
			answer++;
			return;
		}
		
		for(int i=idx; i<=N; i++) {
			selected[cnt] = i;
			solve(i+1, cnt+1);
		}
	}
}
