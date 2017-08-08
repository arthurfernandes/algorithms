package sorting;

/*
 * Cracking the Code problem 11.1
 */
public class MergeBuffer {

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 7, 8, 0, 0, 0, 0};
		int[] B = { 4, 6, 9, 12};
		
		merge(A, B);
		
		for(int i : A) {
			System.out.print(i + " ");
		}
	}
	
	public static void merge(int[] A, int[] B) {
		int[] a,b;
		if (A.length > B.length) {
			a = A;
			b = B;
		}
		else {
			a = B;
			b = A;
		}
		
		int lastA = a.length - b.length - 1;
		int lastB = b.length - 1;
		int cur = a.length - 1;
		
		while( lastB >= 0) {
			if (lastA < 0 || (b[lastB] >= a[lastA])){
				a[cur] = b[lastB];
				lastB--;
			}
			else {
				a[cur] = a[lastA];
				lastA--;
			}
			
			cur--;
		}
	}
}
