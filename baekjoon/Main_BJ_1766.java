package baekjoon;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main_BJ_1766 {
	
	static class Node {
		int n;
		Node link;
		
		Node(int n, Node link){
			this.n = n;
			this.link = link;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		// 들어오는 간선 개수
		int[] in_degree = new int[N+1];
		Node[] matrix = new Node[N+1];
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			in_degree[b]++;
			matrix[a] = new Node(b, matrix[a]);
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // degree가  0인 것들 넣어두는데, 쉬운 문제부터
		boolean[] visited = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			if(in_degree[i] == 0) {
				pq.add(i);
				visited[i] = true;
			}
		}
		Queue<Integer> order = new LinkedList<Integer>();
		
		while(!pq.isEmpty()) {
			int current = pq.poll();
			order.add(current); // 순서에 넣기
			
			// 해당 문제가 선인 것들에서 감소
			for(Node node = matrix[current]; node != null; node = node.link) {
				in_degree[node.n]--; // degree 하나 감소
				if(in_degree[node.n] == 0)
					pq.add(node.n);
			}
		}
		
		while(!order.isEmpty()) {
			System.out.print(order.poll() + " ");
		}
		
	}

}
