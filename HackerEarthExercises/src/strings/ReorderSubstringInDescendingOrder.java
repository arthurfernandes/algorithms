package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReorderSubstringInDescendingOrder {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		char[] s = new char[10000];
		for(int test = 0; test < T; test++) {
			String line = br.readLine();
			int index = 0;
			while(true) {
				char c = line.charAt(index);
				if(c == ' ')
					break;
				s[index] = c; 
				index++;
			}
			
			String[] nmLines = line.substring(index+1).split("\\s");
			int N = Integer.parseInt(nmLines[0]);
			int M = Integer.parseInt(nmLines[1]);
			
			reorderSubstring(s, N, M);
			printCharArray(s, index);
		}
	}
	
	public static void printCharArray(char[] s, int length) {
		for(int i = 0; i < length; i++) {
			System.out.print(s[i]);
		}
		System.out.println();
	}
	
	public static void reorderSubstring(char[] str, int N, int M) {
		if(M <= N)
			return;
		
		int[] charSpace = new int[26];
		int begin = 'a';
		for(int i = N; i <= M; i++) {
			int pos = str[i] - begin;
			charSpace[pos]++;
		}
		
		int curPos = N;
		for(int i = charSpace.length-1; i >= 0; i--) {
			int count = charSpace[i];
			char c = (char) (i + begin);
			for(int j = 0; j < count; j++) {
				str[curPos++] = c;
			}
		}
	}
}
