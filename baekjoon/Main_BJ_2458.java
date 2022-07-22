package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_2458 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int INF = 9999;
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] matrix = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			matrix[a][b] = 1;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][j] = INF; // 인접하지 않은 곳은 무한대
				}
			}
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (matrix[i][k] + matrix[k][j] < matrix[i][j]) {
						matrix[i][j] = matrix[i][k] + matrix[k][j];
					}
				}
			}
		}
		
		int[][] result = new int[N+1][2];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(matrix[i][j] != INF) result[i][1]++; // 뒤
				if(matrix[j][i] != INF) result[i][0]++; // 앞
			}
		}
		
		int answer = 0;
		for(int i=1; i<=N; i++) {
			if(result[i][0] + result[i][1] == N-1) answer++;
		}
		System.out.println(answer);
	}

}
