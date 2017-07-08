package arrays_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1.3
 * Is a Permutation Cracking the Code
 */
public class IsAPermutation {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		if(isAPermutation(s,t)) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
	
	public static boolean isAPermutation(String s, String t) {
		if(s.length() != t.length()) 
			return false;
		
		if(s.length() == 0)
			return true;
		
		int[] letters = new int[256];
		for(char c: s.toCharArray()) {
			letters[c]++;
		}
		
		for(char c: t.toCharArray()) {
			letters[c]--;
			if(letters[c] < 0) {
				return false;
			}
		}
		return true;
	}
}
