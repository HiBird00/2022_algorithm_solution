package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_3019 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int C = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int[] height = new int[C];
		int answer = 0;
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<C; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		switch(P) {
		case 1:
			// 일직선
			answer += C; // 모두 가능
			// 회전 ----
			for(int i=0; i<C-3; i++) {
				if(height[i] == height[i+1] && height[i] == height[i+2]&& height[i] == height[i+3]) answer++;
			}
			break;
		case 2:
			for(int i=0; i<C-1; i++) {
				if(height[i] == height[i+1]) answer++;
			}
			break;
			
		case 3: 
			for(int i=0; i<C; i++) {
				if(i+2 < C && height[i] == height[i+1] && height[i+1]+1 == height[i+2]) answer++;
				if(i+1 < C && height[i]-1 == height[i+1]) answer++;
			}
			break;
		case 4:
			for(int i=0; i<C; i++) {
				if(i+2 < C && height[i]-1 == height[i+1] && height[i+1] == height[i+2]) answer++;
				if(i+1 < C && height[i]+1 == height[i+1]) answer++;
			}
			break;
			
		case 5:
			for(int i=0; i<C; i++) {
				if(i+2 < C && height[i] == height[i+1] && height[i] == height[i+2]) answer++;
				if(i+1 < C && height[i]+1 == height[i+1]) answer++;
				if(i+2 < C && height[i]-1 == height[i+1] && height[i] == height[i+2]) answer++;
				if(i+1 < C && height[i]-1 == height[i+1]) answer++;
			}
			break;
		case 6:
			for(int i=0; i<C; i++) {
				if(i+2 < C && height[i] == height[i+1] && height[i] == height[i+2]) answer++;
				if(i+1 < C && height[i] == height[i+1]) answer++;
				if(i+2 < C && height[i]+1 == height[i+1] && height[i+1] == height[i+2]) answer++;
				if(i+1 < C && height[i]-2 == height[i+1]) answer++;
			}
			break;
		case 7:
			for(int i=0; i<C; i++) {
				if(i+2 < C && height[i] == height[i+1] && height[i] == height[i+2]) answer++;
				if(i+1 < C && height[i] == height[i+1]) answer++;
				if(i+2 < C && height[i] == height[i+1] && height[i+1]-1 == height[i+2]) answer++;
				if(i+1 < C && height[i]+2 == height[i+1]) answer++;
			}
			break;
		}
		System.out.println(answer);
	}

}
