package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_2109 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if(a[0]==b[0]) return a[1]-b[1]; // 페이가 같다면 
			return b[0] -a[0]; // 페이가 쏀 강의 순으로 나열
		});
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			pq.add(new int[] {p, d});
		}
		
		int answer = 0;
		boolean[] visited = new boolean[10001];
		while(!pq.isEmpty()) {
			int[] current = pq.poll();
			for(int i=current[1]; i>0; i--) {
				if(visited[i]) continue;
				visited[i] = true;
				answer += current[0];
				break;
			}
		}
		
		System.out.println(answer);
	}

}
