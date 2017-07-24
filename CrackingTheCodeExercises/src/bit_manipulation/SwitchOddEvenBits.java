package bit_manipulation;

/*
 * Cracking the Code Exercise 5.6
 */
public class SwitchOddEvenBits {
	public static void main(String[] args) {
		int a = Integer.MIN_VALUE;
		System.out.println(a);
		System.out.println(Integer.toBinaryString(a));
		a = switchOddEven(a);
		System.out.println(Integer.toBinaryString(a));
		System.out.println(a);
	}
	
	public static int switchOddEven(int num) {
		//32 bit numbers
		int maskOdd = 0xAAAAAAAA;
		int maskEven = 0x55555555;
		
		return (((num & maskOdd) >> 1) & ~(1 << 31)) | ((num & maskEven) << 1);
	}
}
