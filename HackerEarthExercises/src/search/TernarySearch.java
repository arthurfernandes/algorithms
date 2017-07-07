package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

/**
 * https://www.hackerearth.com/practice/algorithms/searching/ternary-search/tutorial/
 * Ternary Search can be used to search for maximal/min values in unimodal functions
 */
public class TernarySearch {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Function<Long, Long> f = ((x) -> (2*x*x - 12*x + 7)); 
		
		for(int i = 0; i < N; i++) {
			String[] rangeStringArray = br.readLine().split("\\s");
			int start = Integer.parseInt(rangeStringArray[0]);
			int end = Integer.parseInt(rangeStringArray[1]);
			long result = ternarySearchMin(start, end, f);
			System.out.println(result);
		}
	}
	
	public static long ternarySearchMin(int start, int end, Function<Long, Long> f) {
		long l = start, r = end;
		
		while(l <= r){
		    long mid1 = l + (r - l)/3;
		    long mid2 = r - (r - l)/3;
		    long f1 = f.apply(mid1);
		    long f2 = f.apply(mid2);
		    
		    if (f1 <= f2){
		        r = mid2 - 1;
		    }
		    else{
		        l = mid1 + 1;
		    }
		}
		
		return f.apply(l);
	}
}
