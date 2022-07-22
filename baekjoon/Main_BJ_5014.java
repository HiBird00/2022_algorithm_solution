package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BJ_5014 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int F = sc.nextInt();
		int S = sc.nextInt();
		int G = sc.nextInt();
		int U = sc.nextInt();
		int D = sc.nextInt();
		
		String answer = "use the stairs";
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {S, 0}); // 층 , 횟수
		boolean[] visited = new boolean[F+1];
		visited[S] = true;
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			if(current[0] == G) {
				answer = current[1]+"";
				break;
			}
			
			if(current[0] + U <= F && !visited[current[0] + U]) {
				visited[current[0] + U] = true;
				queue.add(new int[] {current[0] + U, current[1]+1});
			}
			if(current[0] - D > 0 && !visited[current[0] - D]) {
				visited[current[0] - D] = true;
				queue.add(new int[] {current[0] - D, current[1]+1});
			}
		}
		System.out.println(answer);
		
	}

}
