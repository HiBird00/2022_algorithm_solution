package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_16943 {

	public static String A, B;
	public static int[] selected;
	public static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.next();
		B =sc.next();
		
		selected = new int[A.length()];
		
		solve(0, 0);
		System.out.println(answer == Integer.MIN_VALUE ? -1 : answer);
	}
	
	public static void solve(int cnt, int flag) {
		if(cnt == selected.length) {
			// 판단
			String num = "";
			for(int i=0; i<cnt; i++) {
				num += A.charAt(selected[i]);
			}
			
			if(Integer.parseInt(num) < Integer.parseInt(B)) {
				answer = Math.max(answer, Integer.parseInt(num));
			}
			return;
		}
		
		for(int i=0; i<selected.length; i++) {
			if(cnt == 0 && A.charAt(i) == '0') continue;
			if((flag & 1<<i) != 0) continue;
			selected[cnt] = i;
			solve(cnt+1, flag | 1<<i);
		}
	}

}
