package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Basic problem, read matrix and print it with rows and columns swapped
 * https://www.hackerearth.com/practice/data-structures/arrays/multi-dimensional/tutorial/ 
 *
 */
public class MultidimensionalArraySwapRowsColumns {
	public static void main(String args[] ) throws Exception {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nmLine = br.readLine();
        String[] nmStrings = nmLine.split("\\s");
        
        int N = Integer.parseInt(nmStrings[0]);
        int M = Integer.parseInt(nmStrings[1]);
        
        int[][] arr = new int[M][N];
            
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            String[] elements = line.split("\\s");
            for(int j = 0;j < M;j++){
                arr[j][i] = Integer.parseInt(elements[j]);
            }
         }
        
        printArray(arr);
    }
    
    public static void printArray(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length;j++){
                System.out.print(arr[i][j]);
                if(j != arr[0].length - 1)
                    System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
