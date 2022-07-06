package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_9019 {

	public static class Node {
		int n;
		String cmd;

		Node(int n, String cmd) {
			this.n = n;
			this.cmd = cmd;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			Queue<Node> queue = new LinkedList<>();
			boolean[] visited = new boolean[10000];
			queue.add(new Node(A, ""));

			while (!queue.isEmpty()) {
				Node current = queue.poll();
				if (current.n == B) {
					sb.append(current.cmd);
					break;
				}

				if (visited[current.n])
					continue;
				visited[current.n] = true;

				// D
				int D = 2 * current.n;
				if (D > 9999)
					D %= 10000;
				queue.add(new Node(D, current.cmd + "D"));

				// S
				queue.add(new Node(current.n == 0 ? 9999 : current.n - 1, current.cmd + "S"));

				// L
				int d1 = current.n % 10;
				int d2 = (current.n / 10) % 10;
				int d3 = (current.n / 100) % 10;
				int d4 = current.n / 1000;
				queue.add(new Node(d3 * 1000 + d2 * 100 + d1 * 10 + d4, current.cmd + "L"));
				// R
				queue.add(new Node(d1 * 1000 + d4 * 100 + d3 * 10 + d2, current.cmd + "R"));
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

}
