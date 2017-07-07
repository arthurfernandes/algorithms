package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * https://www.hackerearth.com/practice/data-structures/arrays/multi-dimensional/practice-problems/algorithm/monk-and-inversions-arrays-strings/
 */
public class MonksAndInversions {
    public static void main(String args[] ) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String testsLine = bf.readLine();
        int tests = Integer.parseInt(testsLine);
        
        int arr[][] = new int[20][20];

        while(tests > 0){
            String nLine = bf.readLine();
            int N = Integer.parseInt(nLine);
            
            for(int i = 0; i < N; i++){
                String[] elements = bf.readLine().split("\\s");
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(elements[j]);
                }
            }
            
            int inversions = getNumberOfInversions(arr, N);
            System.out.println(inversions);
            
            tests--;
        }
    }
    
    public static int getNumberOfInversions(int[][] arr, int N){
        if(N < 2)
            return 0;
            
        int inversions = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j< N; j++){
                int biggerElement = arr[i][j];
                for(int p = 0; p <= i; p++){
                    for(int q = 0; q<= j; q++){
                        int smallerElement = arr[p][q];
                        if(smallerElement > biggerElement){
                            inversions += 1;
                        }
                    }
                }
            }
        }
		return inversions;
    }
}

