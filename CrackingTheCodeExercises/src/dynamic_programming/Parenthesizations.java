package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem 9.6 - Cracking the Code, return all the parenthesizations with n open/close parentheses
 * Realize that the size of the set returned is Cn (Catalan Number n)
 */
public class Parenthesizations {
	public static void main(String[] args) {
		for (int i = 1; i < 13; i++) {
			List<String> parenthesizations = getParenthesizations(i);
			System.out.println(parenthesizations.size());
		}
	}
	
	public static List<String> getParenthesizations(int n) {
		List<String> parenthesizations = new ArrayList<>();
		if (n < 0) {
			return null;
		}
		if (n == 0) {
			parenthesizations.add("");
			return parenthesizations;
		}
		else {
			char[] str = new char[2*n];
			int leftRemainder = n;
			int rightRemainder = n;
			int curPos = 0;
			addParen(str, parenthesizations, leftRemainder, rightRemainder, curPos);
			return parenthesizations;
		}
	}
	
	private static void addParen(char[] str, List<String> list, int leftRem, int rightRem, int curPos) {
		//Invalid configurations
		if (leftRem < 0 || rightRem < 0 || rightRem < leftRem)
			return;
		
		//End of parenthesization
		if (leftRem == 0 && rightRem == 0) {
			list.add(String.copyValueOf(str));
			return;
		}
		
		//Try to add Left Parenthesis
		str[curPos] = '(';
		addParen(str, list, leftRem - 1, rightRem, curPos + 1);
		
		//Try to add Right Parenthesis
		str[curPos] = ')';
		addParen(str, list, leftRem, rightRem - 1, curPos + 1);
	}
}
