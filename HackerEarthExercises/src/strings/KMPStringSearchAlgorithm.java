package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Knuth Morris Pratt Algorithm
 * https://www.hackerearth.com/practice/algorithms/string-algorithm/string-searching/tutorial/
 * 
 */
public class KMPStringSearchAlgorithm {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String p = br.readLine();
		String t = br.readLine();
		
		int occurrences = KMPAlgorithm(p, t);
		System.out.println(occurrences);
	}
	
	public static int KMPAlgorithm(String p, String t) {
		//create abstraction of p # t
		int[] F = buildPrefixTable(p);
		int occur = 0;
		int i = 0;
		for(int j = 0; j < t.length(); j++) {
			while(i > 0 && p.charAt(i) != t.charAt(j)) {
				i = F[i-1];
			}
			
			if(p.charAt(i) == t.charAt(j)) {
				i += 1;
			}
			
			if(i == p.length()) {
				occur++;
				i = F[i-1];
			}
		}
		
		return occur;
	}
	
	private static int[] buildPrefixTable(String p) {
		int[] F = new int[p.length()];
		
		F[0] = 0;
		
		for(int i = 1; i < p.length(); i++) {
			int j = F[i-1];
			
			while(j > 0 && p.charAt(i) != p.charAt(j)) {
				j = F[j-1];
			}
			
			if(p.charAt(i) == p.charAt(j)) {
				F[i] = j + 1;
			}
		}
		
		return F;
	}
}
