package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_9944 {

	public static int[] dr = { 0, 0, 1, -1 };
	public static int[] dc = { 1, -1, 0, 0 };
	public static int N, M, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String S = "";
		int count = 1;
		while ((S = in.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(S);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			char[][] map = new char[N][M];
			boolean[][] visited = new boolean[N][M];
			answer = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				char[] spt = in.readLine().toCharArray();
				for(int j=0; j<M; j++) {
					if(spt[j] == '*') {
						visited[i][j] = true;
					}
					map[i][j] = spt[j];
				}
			}
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == '.') {
						visited[i][j] = true;
						solve(i, j, 0, map, visited);
						visited[i][j] = false;
					}
				}
			}
			
			System.out.println("Case " + count++ +": " + (answer == Integer.MAX_VALUE ? -1 : answer));
		}
	}

	public static void solve(int r, int c, int cnt, char[][] map, boolean[][] visited) {
		if (checkFinish(visited)) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int count = 0; // 방문한 횟수
			int nr = r + dr[i];
			int nc = c + dc[i];
			while (true) {
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) {
					// 범위를 벗어났거나, 이동할 수 없다면 이전 값으로 되돌림
					nr -= dr[i];
					nc -= dc[i];
					break;
				}
				visited[nr][nc] = true;
				count++;
				nr += dr[i];
				nc += dc[i];
			}
			
			if(count > 0) {
				// 이동했다는 뜻
				solve(nr, nc, cnt+1, map, visited);
			}
			
			for(int j=0; j<count; j++) {
				visited[nr][nc] = false; // 되돌리기
				nr -= dr[i];
				nc -= dc[i];
			}
		}

	}

	public static boolean checkFinish(boolean[][] visited) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j])
					return false;
			}
		}
		return true;
	}

}