package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.hackerearth.com/practice/algorithms/string-algorithm/string-searching/practice-problems/algorithm/game-of-strings-2/
 */
public class GameOfStrings {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			String[] input = br.readLine().split("\\s");
			String s = input[0];
			int k = Integer.parseInt(input[1]);
			
			String maxString = findMaximumLengthString(s, k-1);
			if(maxString.length() == 0)
				System.out.println("Puchi is a cheat!");
			else
				System.out.println(maxString);
		}
	}
	
	public static String findMaximumLengthString(String s, int k) {
		//KMP
		int[] F = new int[s.length()];
		F[0] = 0;
		int maxk = 0;
		
		for(int i = 1; i < s.length(); i++) {
			int j = F[i-1];
			
			while(j > 0 && s.charAt(i) != s.charAt(j)) {
				j = F[j-1];
			}
			
			if(s.charAt(i) == s.charAt(j)) {
				F[i] = j + 1;
			}
			
			if(i <= k) {
				maxk = Math.max(maxk, F[i]);
			}
		}
		
		int pos = F[s.length() - 1];
		while(pos > maxk && pos > 0) {
			pos = F[pos - 1];
		}
		
		if(pos > 0) {
			return s.substring(0, pos);
		}
		else {
			return "";
		}
	}
}
