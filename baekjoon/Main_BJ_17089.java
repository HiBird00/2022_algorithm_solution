package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_17089 {

	public static int N, M, answer = Integer.MAX_VALUE;
	public static boolean[][] matrix;
	public static int[] selected;
	public static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new boolean[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			matrix[a][b] = matrix[b][a] = true;
		}
		for(int i=1; i<=N; i++) {
			isSelected = new boolean[N+1];
			selected = new int[3];
			isSelected[i] = true;
			selected[0] = i;
			solve(i, 1);
		}
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	
	public static void solve(int idx, int cnt) {
		if(cnt == 3) {
			// 친구 수 확인
			int count = 0;
			for(int i=0; i<cnt; i++) {
				int a = selected[i]; // 선택된 사람
				for(int j=1; j<=N; j++) {
					if(matrix[a][j] && selected[0] != j && selected[1] != j && selected[2] != j) {
						// a랑 친구지만 선택되지 않은 사람인 경우에만
						count++;
					}
				
				}
			}
			answer = Math.min(answer, count);
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(matrix[idx][i] && !isSelected[i]) {
				// 친구이면서 아직 선택되지 않은 사람이라면 일단 채택
				// 다른 사람들과도 친구인지 확인
				if(isFriend(i, cnt-1)) {
					isSelected[i] = true;
					selected[cnt] = i;
					solve(i, cnt+1);
					isSelected[i] = false;
				}
			}
		}
	}
	
	public static boolean isFriend(int idx, int cnt) {
		for(int i=0; i<cnt; i++) {
			if(!matrix[idx][selected[i]]) return false;
		}
		return true;
	}

}
