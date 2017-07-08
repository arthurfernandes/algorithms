package arrays_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Rotate Matrix 90 degrees
 * Cracking the Code 1.6
 *
 */
public class RotateMatrix90Degrees {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Read N
		int N = Integer.parseInt(br.readLine());
		//Read Matrix
		int[][] matrix = new int[N][N];
		for(int i = 0; i < N; i++) {
			String[] rowElements = br.readLine().split("\\s");
			for(int j = 0; j < rowElements.length; j++) {
				matrix[i][j] = Integer.parseInt(rowElements[j]);
			}
		}
		
		rotateMatrix(matrix);
		
		printMatrix(matrix);
	}
	
	public static void rotateMatrix(int[][] matrix) {
		int N = matrix.length;
		if(N < 2)
			return;
		
		int offset = 0;
		while(N > 1) {
			for(int i = 0; i < N - 1; i++) {
				//Store upper
				int temp = matrix[offset][offset+i];
				//left -> top
				matrix[offset][offset+i] = matrix[offset+N-i-1][offset];
				// bottom -> left
				matrix[offset+N-i-1][offset] = matrix[offset+N-1][offset+N-1-i];
				//right -> bottom
				matrix[offset+N-1][offset+N-1-i] = matrix[offset+i][offset + N - 1];
				//top -> right
				matrix[offset+i][offset+N-1] = temp;
			}
			N -= 2;
			offset += 1;
		}
	}
	
	public static void printMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length;j ++) {
				System.out.print(matrix[i][j]);
				if(j < matrix[i].length -1)
					System.out.print(" ");
				else
					System.out.println("");
			}
		}
	}
	
}
