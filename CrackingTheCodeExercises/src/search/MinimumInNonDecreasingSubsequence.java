package search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/non-decreasing-sequence-4/
 * OBS: Although in the problem it says Non Decreasing Subsequence, the test cases show that it should be Strictly Increasing Subsequeence
 * Difference:
 * Strictly Increasing Subsequence: (1, 2, 3, 7, 8) is ok, but not (1, 1, 2, 5)
 * Non Decreasing Subsequence: both are ok
 */
public class MinimumInNonDecreasingSubsequence {
	public static void main(String args[] ) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        
        for(int test = 0; test < T; test++) {
        		int N = Integer.parseInt(bf.readLine());
        		int[] arr = new int[N];
        		String[] elementsStringArray = bf.readLine().split("\\s");
        		for(int i = 0; i < N; i++) {
        			arr[i] = Integer.parseInt(elementsStringArray[i]);
        		}
        		
        		int L = Integer.parseInt(bf.readLine());
        		
        		int min = minimumInNonDecreasingSubsequence(arr, L);
        		System.out.println(min);
        }
    }
    
    public static int minimumInNonDecreasingSubsequence(int[] arr, int L){
        final List<Integer> longestSubsequenceList = new ArrayList<>();
        longestSubsequenceList.add(arr[0]);
        for(int i = 1; i < arr.length; i++){
            final int elem = arr[i];
            final int index = modifiedBinarySearch(longestSubsequenceList, elem);
            if(index > longestSubsequenceList.size()-1){
                longestSubsequenceList.add(elem);
            }
            else if(elem < longestSubsequenceList.get(index)){
                longestSubsequenceList.set(index, elem);
            }
        }
        
        int min = -1;
        
        for(int i = L-1; i < longestSubsequenceList.size(); i++){
            int elem = longestSubsequenceList.get(i);
            if(min < 0 || elem < min){
                min = elem; 
            }
        }
        
        return min;
    }
    
    public static int modifiedBinarySearch(List<Integer> list, int q){
        if(q > list.get(list.size()-1))
            return list.size();
        
        if(q < list.get(0))
            return 0;
        
        int low = 0;
        int hi = list.size() - 1;
        int near = 0;
        while(low <= hi){
            int mid = low + (hi - low)/2;
            int elem = list.get(mid);
            if(q < elem){
                hi = mid - 1;
            }
            else if(q > elem){
                near = mid;
                low = mid + 1;
            }
            else{
                return mid;
            }
        }
        return near+1;
    }
}
