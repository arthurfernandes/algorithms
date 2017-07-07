package search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/kth-smallest-number-again-2/
 * 
 */
public class KthSmallestNumberAgain {
	public static void main(String args[] ) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for(int test = 0; test < T; test++){
            String[] nqLine = bf.readLine().split("\\s");
            int N = Integer.parseInt(nqLine[0]);
            int Q = Integer.parseInt(nqLine[1]);
            
            Interval[] arr = new Interval[N];
            
            for(int i = 0; i < N; i++){
                String[] rangeLine = bf.readLine().split("\\s");
                long start = Long.parseLong(rangeLine[0]);
                long end = Long.parseLong(rangeLine[1]);
                
                arr[i] = new Interval(start, end);
            }
            
            Arrays.sort(arr, new Comparator<Interval>(){
               @Override
               public int compare(Interval o1, Interval o2){
                    return o1.start == o2.start ? 0 :
                    	(o1.start < o2.start ? -1 : 1);
               } 
            });
            
            Interval[] aggregates = generateAggregates(arr);
            long[] searchArray = new long[aggregates.length];
            long totalCapacity = 0;
            for(int i = 0; i < aggregates.length; i++){
                long capacity = aggregates[i].end - aggregates[i].start + 1;
                totalCapacity += capacity;
                searchArray[i] = totalCapacity;
            }
            
            for(int q = 0; q < Q; q ++){
                long k = Long.parseLong(bf.readLine());
                
                if (k > totalCapacity){
                    System.out.println(-1);
                }
                else{
                    int index = specializedBinarySearch(searchArray, k);
                    
                    long value = aggregates[index].start;
                    if(index > 0){
                        value = value - searchArray[index - 1];
                    }
                    value = value + k - 1;
                    System.out.println(value);
                }
            }
        }
    }
    
    public static Interval[] generateAggregates(Interval[] arr){
        List<Interval> aggregates = new ArrayList<Interval>();
        int index = 0;
        while(index < arr.length){
            //new aggregate
            Interval curAggregate = arr[index];
            index += 1;
            while(index < arr.length && arr[index].start <= curAggregate.end){
                if(arr[index].end > curAggregate.end){
                    curAggregate.end = arr[index].end;
                }
                index += 1;
            }
            aggregates.add(curAggregate);
        }
        
        Interval[] res = aggregates.toArray(new Interval[aggregates.size()]);
        return res;
    }
    
    public static int specializedBinarySearch(long[] searchArray, long k){
        int low = 0;
        int hi = searchArray.length;
        
        while(low <= hi){
            int mid = low + (hi - low)/2;
            long elem = searchArray[mid];
            if(k < elem){
                hi = mid - 1;
            }
            else if(k > elem){
                low = mid + 1;
            }
            else{
                return mid;
            }
        }
        return low;
        
    }
    
    public static class Interval{
        long start;
        long end;
        Interval(long start, long end){
            this.start = start;
            this.end = end;
        }
    }
}
