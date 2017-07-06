package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/repeated-k-times/
 */
public class RepeatedKTimes {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		
		String[] elementStringArray = bf.readLine().split("\\s");
		for(int i = 0; i < N; i++) {
			int elem = Integer.parseInt(elementStringArray[i]);
			arr[i] = elem;
		}
		
		int K = Integer.parseInt(bf.readLine());
		
		int minimal = getMinimalRepeatedKTimes(arr, K);
		
		System.out.println(minimal);
	}
	
	public static int getMinimalRepeatedKTimes(int[] arr, int K) {
		//store in dict
		Map<Integer, Integer> dict = new HashMap<>();
		for(int elem : arr) {
			int count = dict.getOrDefault(elem, 0);
			dict.put(elem, count + 1);
		}

		//get minimal
		int value = dict.entrySet().stream()
				.filter(entry -> entry.getValue() == K)
				.mapToInt(entry -> entry.getKey())
				.min().getAsInt();
		
		return value;
	}
}
