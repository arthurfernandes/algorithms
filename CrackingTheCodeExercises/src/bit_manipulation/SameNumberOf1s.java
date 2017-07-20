package bit_manipulation;

/**
 * Cracking the Code 5.3, assuming 32 bit numbers
 */
public class SameNumberOf1s {
	
	public static void main(String[] args) {
		int i = Integer.parseInt("110000111010111011000", 2);
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toBinaryString(nextSmallest(i)));
	}
	
	public static int nextSmallest(int num) {
		if (num <= 0) {
			return -1;
		}
		
		int c0 = countBits(num, 0, 0);
		int c1 = countBits(num, c0, 1);
		if (c0 + c1 >= 31) {
			return -1;
		}
		
		num = clearLowerBits(num, c0 + c1);
		num = setBit(num, c1 + c0);
		num = setLowerBits(num, c1 - 1);
		
		return num;
	}

	public static int countBits(int num, int start, int bit) {
		int count = 0;
		int cur = start;
		while(cur < 32) {
			if (getBit(num, cur) == bit) {
				count++;
			}
			else {
				break;
			}
			cur += 1;
		}
		
		return count;
	}
	
	public static int getBit(int num, int b) {
		if (b < 0 || b > 31)
			return 0;
		
		return (num & (1 << b)) != 0 ? 1 : 0;
	}
	
	public static int setBit(int num, int b) {
		if (b < 0 || b > 31)
			return num;
		
		return num | (1 << b);
	}
	
	public static int clearLowerBits(int num, int n) {
		if (n < 0)
			return num;
		
		int mask = ~((1 << n) - 1);
		return num & mask;
	}
	
	public static int setLowerBits(int num, int n) {
		if (n < 0)
			return num;
		
		int mask = ((1 << n) - 1);
		return num | mask;
	}
	
	
}
