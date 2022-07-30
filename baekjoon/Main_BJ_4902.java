package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_4902 {

	public static int N, arr[], answer;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		int T = 1;
		while (!(s = in.readLine()).equals("0")) {
			answer = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(s);
			N = Integer.parseInt(st.nextToken());
			arr = new int[N * N + 1];
			for (int i = 1; i <= N * N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1; i<=N; i++) {
				int idx = (i-1)*(i-1)+1; // 해당 행의 시작 인덱스
				for(int j=0; j<2*i-1; j++) {
					// 해당 행의 열 개수
					if(j % 2 == 1) {
						reverse(idx+j, i, j, 1, 0);
					}else {
						solve(idx + j, i, j, 1, 0);						
					}
				}
			}
			
			System.out.println(T + ". " + answer);
			T++;
		}
	}
	
	// 시작 인덱스, 몇번째 행인지, 행의 몇번쨰 인지, 몇 삼각형인지, 지금까지의 합
	public static void solve(int idx, int r, int cnt, int n, int total) {
		answer = Math.max(answer, total);
		if(idx > N*N) return;
		
		int sum = 0;
		for(int i=0; i<2*n-1; i++) {
			// n에 따라서 더해줘야 할 삼각형의 개수
			sum += arr[idx+i];
		}
		int next = r*r+1 + cnt; // 다음 행의 살펴볼 인덱스
		solve(next, r+1, cnt, n+1, total+sum);
	}
	
	// 시작 인덱스, 몇번째 행인지, 행의 몇번쨰 인지, 몇 삼각형인지, 지금깢ㅇ
	public static void reverse(int idx, int r, int cnt, int n, int total) {
		answer = Math.max(answer, total);
		int count = 2*n-1; // 더해야 할 삼각형 개수
		int startIdx = (r-1)*(r-1)+1;
		int endIdx = r*r;
		if(idx < startIdx || idx + count - 1 > endIdx) return; // 인덱스가 범위에 넘어가는 경우
		
		int sum = 0;
		for(int i=0; i<count; i++) {
			// n에 따라서 더해줘야 할 삼각형의 개수
			sum += arr[idx+i];
		}
		int next = (r-2)*(r-2)+1 + cnt - 2; // 다음 행의 살펴볼 인덱스
		reverse(next, r-1, cnt-2, n+1, total+sum);
	}

}
