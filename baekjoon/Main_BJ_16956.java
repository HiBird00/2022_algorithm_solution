package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16956 {
	public static int dr[] = { 0, 0, 1, -1 };
	public static int dc[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		Queue<int[]> sheep = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			String s = in.readLine();
			for (int j = 0; j < M; j++) {
				char ch = s.charAt(j);
				map[i][j] = ch;
				if (ch == 'S') {
					sheep.add(new int[] { i, j }); // 양 위치 넣기
				}
			}
		}

		while (!sheep.isEmpty()) {
			int[] current = sheep.poll();
			for (int i = 0; i < 4; i++) {
				int nr = current[0] + dr[i];
				int nc = current[1] + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 'S')
					continue;
				if (map[nr][nc] == 'W') {
					System.out.println(0);
					return;
				}
				map[nr][nc] = 'D'; // 울타리 치기
			}

		}

		System.out.println(1);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
