package dynamic_programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Problem 9.5 - Get all permutations of a string
 */
public class StringPermutations {

	public static void main(String[] args) {
		List<String> perms = getPermutations("abcde");
		Set<String> set = new HashSet<String>();
		for(String perm : perms) {
			set.add(perm);
			System.out.println(perm);
		}
		System.out.println(set.size());
	}
	
	public static List<String> getPermutations(String s) {
		List<String> permutations = new ArrayList<>();
		
		getPermutations(s, "", permutations);
		
		return permutations;
	}
	
	private static void getPermutations(String s, String preffix, List<String> permutations){
		if(s.length() == 0) {
			permutations.add(preffix);
		}
		else {
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				getPermutations(s.substring(0, i) + s.substring(i+1), (preffix + c), permutations);
			}
		}
	}
}
