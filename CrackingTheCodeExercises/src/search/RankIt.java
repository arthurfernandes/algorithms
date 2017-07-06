package search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Simple Binary Search Problem
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/tutorial/
 */
public class RankIt {
public static void main(String args[] ) throws Exception {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        
        int[] arr = new int[N];
        String[] arrayLines = bf.readLine().split("\\s");
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(arrayLines[i]);
        }
        
        Arrays.sort(arr);
        
        int Q = Integer.parseInt(bf.readLine());

        for(int q = 0; q < Q; q++){
            int query = Integer.parseInt(bf.readLine());
            int rank = binarySearch(arr, query);    
            System.out.println(rank+1);
        }
                
    }
    
    public static int binarySearch(int[] arr, int q){
        if(arr.length < 1)
            return -1;
            
        int low = 0;
        int hi = arr.length - 1;
        
        while(low <= hi){
            int mid = low + (hi - low) / 2;
            int val = arr[mid];
            if(q < val){
                hi = mid - 1;
            }
            else if(q > val){
                low = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
