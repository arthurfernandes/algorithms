package arrays_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1.1 Cracking The Code
 */
public class UniqueCharactersString {
	public static int CHAR_SPACE = 256;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		if(isUniqueString(s.toString(), CHAR_SPACE)) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
	
	public static boolean isUniqueString(String s, int charSpace) {
		int length = s.length();
		if(length == 0){
			return true;
		}
		else if(length > charSpace) {
			return false;
		}
		else {
			int[] charSet = createBitArray(charSpace);
			for(int i = 0; i < length; i++) {
				int c = s.charAt(i);
				if (c >= charSpace)
					throw new RuntimeException("Character out of charspace encoding");
				if(getBit(charSet, c)){
					return false;
				}
				else {
					setBit(charSet, c);
				}
			}
			return true;
		}
	}
	
	public static int[] createBitArray(int charSpace) {
		int integerSize = 32;
		int[] bitArray = new int[((charSpace+integerSize-1)/integerSize)];
		return bitArray;
	}
	
	public static boolean getBit(int[] bitArray, int c) {
		int pos = (c >> 5) - 1;
		return (bitArray[pos] & (1 << (c % 32))) == 0 ? false : true ;
	}
	
	public static void setBit(int[] bitArray, int c) {
		int pos = (c >> 5) - 1;
		bitArray[pos] |= 1 << (c % 32);
	}
}

