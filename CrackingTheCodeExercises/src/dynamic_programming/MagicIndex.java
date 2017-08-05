package dynamic_programming;

/*
 * Problem 9.3 find index i, such that a[i] = i in sorted array
 */
public class MagicIndex {
	public static void main(String[] args) {
		int[] arr = {-20, -12, 0, 0, 0, 3, 5, 5, 11, 12, 15, 55, 56};
		
		System.out.println(findMagicIndex(arr));
	}
	
	public static int findMagicIndex(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		
		return magicFast(arr, 0, arr.length -1);
	}
	
	private static int magicFast(int[] arr, int lo, int hi) {
		if (lo > hi)
			return -1;
		
		int mid = lo + (hi - lo) / 2;
		
		if (arr[mid] == mid)
			return mid;
		
		int leftRes = magicFast(arr, lo, Math.min(arr[mid], mid - 1));
		if(leftRes > -1)
			return leftRes;
		
		int rightRes = magicFast(arr, Math.max(arr[mid], mid + 1), hi);
		return rightRes;
	}

}
