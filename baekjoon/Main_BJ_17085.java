package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_17085 {

	public static char[][] map;
	public static int answer = Integer.MIN_VALUE;
	public static int[] dr = { 0, 0, 1, -1 };
	public static int[] dc = { 1, -1, 0, 0 };
	public static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}
		solve(0, 1);
		System.out.println(answer);
	}

	public static void solve(int cnt, int total) {
		if (cnt == 2) {
			answer = Math.max(answer, total);
			return;
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] != '.') {
					Stack<int[]> pos = new Stack<>(); // 십자가를 놓은 위치 기억
					int count = 0;
					map[r][c] = '.'; // 십자가 채움
					pos.add(new int[] {r, c});
					solve(cnt+1, total); // 넓이 1인 경우
					
					loop : while(true) {
						for (int k = 0; k < 4; k++) {
							// 넓이가 1 이상이 되는 경우 확인
							int nr = r + dr[k]*(count+1); int nc = c + dc[k]*(count+1);
							if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == '.') {
								break loop; // 십자기 놓을 수 없음
							}
							map[nr][nc] = '.';
							pos.add(new int[] {nr, nc});
						}
						// 십자가를 놓을 수 있음
						count++;
						solve(cnt+1, total * (count*4 + 1));
					}
					// 더이상 십자가를 놓을 수 없다면 원상복귀
					while(!pos.isEmpty()) {
						int[] current = pos.pop();
						map[current[0]][current[1]] = '#';
					}
				}
			}
		}
	}

}
