package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_16986 {

	public static int N, K, matrix[][], gm[][], win[], cnt[];
	public static int selected[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		matrix = new int[N+1][N+1];
		gm = new int[2][20]; // 0 : 경희, 1 : 민호
		selected = new int[N]; // 지우의 가위바위보 순서
		
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=1; j<=N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<2; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<20; j++) {
				gm[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(permutation(0, 0)) System.out.println(1);
		else System.out.println(0);
		
	}
	
	public static boolean permutation(int cnt, int flag) {
		if(cnt == N) {
			// 게임 시작
			if(game()) return true;
			return false;
		}
		
		for(int i=0; i<N; i++) {
			if((flag & 1<<i) != 0) continue;
			selected[cnt] = i+1;
			if(permutation(cnt+1, flag | 1<<i)) return true;
		}
		return false;
	}

	public static boolean game() {
		win = new int[3]; // 0 : 지우, 1 : 경희, 2 : 민호
		cnt = new int[3]; // 0 : 지우, 1 : 경희, 2 : 민호
		
		int p1 = 0;
		int p2 = 1;
		
		while(true) {
			if(win[0] == K) return true;
			if(win[1] == K || win[2] == K) return false;
			
			if(cnt[0] == N || cnt[1] == 20 || cnt[2] == 20) return false;
			
			// 지우가 경기하는 경우
			if(p1 == 0) {
				// 지우가 이기는 경우
				if(matrix[selected[cnt[0]]][gm[p2-1][cnt[p2]]] == 2) {
					win[0]++;
					cnt[p1]++;
					cnt[p2]++;
					p2 = (p2 == 1) ? 2 : 1;
				}else {
					// 지우가 지는 경우
					win[p2]++;
					cnt[p1]++;
					cnt[p2]++;
					p1 = 1;
					p2 = 2;
				}
			}else {
				// 경희랑 민호가 경기하는 경우
				if(matrix[gm[p1-1][cnt[p1]]][gm[p2-1][cnt[p2]]] == 2) {
					// 경희가 이기는 경우
					win[1]++;
					cnt[p1]++; cnt[p2]++;
					p1 = 0;
					p2 = 1;
				}else {
					// 경희가 지는 경우
					win[2]++;
					cnt[p1]++; cnt[p2]++;
					p1 = 0;
					p2 = 2;
				}
			}
		}
	}

}
