package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16988 {

	public static int N, M, map[][], answer = Integer.MIN_VALUE;
	public static ArrayList<int[]> dols = new ArrayList<>();
	public static int[] dr = { 0, 0, 1, -1 };
	public static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if (n == 2) {
					dols.add(new int[] { i, j }); // 상대방 돌
				}
			}
		}
		solve(0, 0, 0);
		System.out.println(answer);

	}

	public static void solve(int r, int c, int cnt) {
		if (cnt == 2) {
			// 점수 확인

			score();
			return;
		}

		for (int i = r; i < N; i++) {
			for (int j = c; j < M; j++) {
				if (map[i][j] == 0) {
					// 놓을 수 있고, 아직 방문하지 않았다면 해당 자리에 내 돌 놓기
					map[i][j] = 1;
					solve(i, j + 1, cnt + 1);
					map[i][j] = 0;
				}
			}
			c = 0;
		}
	}

	public static void score() {
		boolean[][][] visited = new boolean[N][M][2]; // [방문, 가능여부]
		int result = 0;
		for (int i = 0; i < dols.size(); i++) {
			Queue<int[]> queue = new LinkedList<int[]>();
			int[] pos = dols.get(i);
			queue.add(pos);
			int cnt = 0;
			boolean status = false;
			loop: while (!queue.isEmpty()) {
				int[] current = queue.poll();
//				System.out.println(current[0] + " " + current[1]);
				if (visited[current[0]][current[1]][0])
					continue; // 이미 방문했다면 정답x
				visited[current[0]][current[1]][0] = true;

				for (int d = 0; d < 4; d++) {
					int nr = current[0] + dr[d];
					int nc = current[1] + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M)
						continue;
					if (map[nr][nc] == 0 || visited[nr][nc][1]) {
						// 0 이거나 이전에 방문했던 곳이 안된다면
						status = true;
						visited[current[0]][current[1]][1] = true;
						break loop; // 주변에 공간이 있다면 잡을 수 없음
					}
					if (visited[nr][nc][0])
						continue;
					if (map[nr][nc] == 2) {
						queue.add(new int[] { nr, nc }); // 주변의 상대방 돌
					}
				}
//				System.out.println(Arrays.toString(current));
				cnt++; // 4방향 다 돌았는데 break가 안됐다는 것은 둘러쌓여있다는 뜻
			}
			if (!status) {
//				if (cnt == 5) {
//					for (int k = 0; k < N; k++) {
//						System.out.println(Arrays.toString(map[k]));
//					}
//					System.out.println();
//
//				}
				result += cnt;
			}
			
		}
		answer = Math.max(answer, result);
	}

}
