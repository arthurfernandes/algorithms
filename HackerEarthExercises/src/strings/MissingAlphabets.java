package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
 * https://www.hackerearth.com/practice/algorithms/string-algorithm/basics-of-string-manipulation/practice-problems/algorithm/missing-alphabets-1/
 */
public class MissingAlphabets {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		String[] words = new String[100];
		
		for(int t = 0; t < T; t++) {
			String permutation = br.readLine();
			int M = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < M; i++) {
				words[i] = br.readLine();
			}
			
			sortLexicographically(words, M, permutation);
			
			for(int i = 0; i < M; i++) {
				System.out.println(words[i]);
			}
		}
	}
	
	public static void sortLexicographically(String[] words, int length, String permutation) {
		int[] charMap = new int[26];
		char[] permutationArr = permutation.toCharArray();
		for(int i = 0; i < 26; i++) {
			charMap[permutationArr[i] - 'a'] = i;
		}
		
		Arrays.sort(words, 0, length, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int minLength = Math.min(o1.length(), o2.length());
				for(int i = 0; i < minLength; i++) {
					int pos1 = charMap[o1.charAt(i) - 'a'];
					int pos2 = charMap[o2.charAt(i) - 'a'];
					
					if(pos1 > pos2) {
						return 1;
					}
					else if(pos2 > pos1) {
						return -1;
					}
				}
				
				return o1.length() - o2.length();
			}
		});
	}
}
