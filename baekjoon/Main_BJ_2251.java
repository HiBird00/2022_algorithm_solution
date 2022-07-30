package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BJ_2251 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		boolean[][][] visited = new boolean[201][201][201];
		ArrayList<Integer> answer = new ArrayList<>();
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { 0, 0, C });

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			if (visited[current[0]][current[1]][current[2]])
				continue;
			visited[current[0]][current[1]][current[2]] = true;

			if (current[0] == 0) {
				answer.add(current[2]);
			}

			// a->b a->c b->a b->c c->a c->b
			// 비어있는 양
			int a = A - current[0];
			int b = B - current[1];
			int c = C - current[2];
			// a -> b, c
			if (current[0] > 0) {
				if (b > 0) {
					int aTob = Math.min(current[0], b);
					queue.add(new int[] { current[0] - aTob, current[1] + aTob, current[2] });
				}
				if (c > 0) {
					int aToc = Math.min(current[0], c);
					queue.add(new int[] { current[0] - aToc, current[1], current[2] + aToc });
				}
			}
			// b -> a, c
			if (current[1] > 0) {
				if (a > 0) {
					int bToa = Math.min(current[1], a);
					queue.add(new int[] { current[0] + bToa, current[1] - bToa, current[2] });
				}
				if (c > 0) {
					int bToc = Math.min(current[1], c);
					queue.add(new int[] { current[0], current[1]- bToc, current[2] + bToc });
				}
			}
			// c -> a, b
			if (current[2] > 0) {
				if (a > 0) {
					int cToa = Math.min(current[2], a);
					queue.add(new int[] { current[0] + cToa, current[1], current[2]-cToa });
				}
				if (b > 0) {
					int cTob = Math.min(current[2], b);
					queue.add(new int[] { current[0], current[1] + cTob, current[2] - cTob });
				}
			}
		}
		
		int[] result = new int[answer.size()];
		int idx = 0;
		for(int ret : answer) {
			result[idx++] = ret;
		}
		Arrays.sort(result);
		for(int ret : result) {
			System.out.print(ret + " ");
		}
	}

}
