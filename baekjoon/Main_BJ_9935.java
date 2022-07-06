package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ_9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] str = in.readLine().toCharArray();
		String boomStr = in.readLine();
		char[] boom = boomStr.toCharArray();
		
		StringBuilder temp = new StringBuilder();
		for(char ch : str) {
			temp.append(ch);
			if(temp.length() >= boom.length && ch == boom[boom.length-1] && temp.substring(temp.length()-boom.length, temp.length()).toString().equals(boomStr)) {
				// 폭파 문자열이라면
				temp.delete(temp.length()-boom.length, temp.length());
			}
		}

		System.out.println(temp.length() == 0 ? "FRULA" : temp.toString());
	}

}
