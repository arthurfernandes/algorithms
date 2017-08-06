package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Problem 9.4, create a way to generate all the subsets of a set
 */
public class AllSubsetsOfSet {
	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4,5,6};
		ArrayList<Integer> set = new ArrayList<>();
		set.addAll(Arrays.asList(arr));
		
		ArrayList<ArrayList<Integer>> allSubsets = getAllSubsets(set);
		
		printSubsets(allSubsets);
	}
	
	public static ArrayList<ArrayList<Integer>> getAllSubsets(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
		int max = 1 << set.size();
		for (int i = 0; i < max; i++) {
			ArrayList<Integer> subset = convertIntToSubset(set, i);
			allSubsets.add(subset);
		}
		return allSubsets;
	}

	public static ArrayList<Integer> convertIntToSubset(ArrayList<Integer> set, int x) {
		ArrayList<Integer> subset = new ArrayList<>();
		int index = 0;
		
		for(int k = x; k > 0; k >>= 1) {
			if ((k & 1) == 1) {
				subset.add(set.get(index));
			}
			index++;
		}
		return subset;
	}
	
	public static void printSubsets(ArrayList<ArrayList<Integer>> allSubsets) {
		int index = 0;
		for(ArrayList<Integer> subset: allSubsets) {
			System.out.println("Subset: " + index);
			for(Integer elem : subset) {
				System.out.print(elem);
				System.out.print(" , ");
			}
			System.out.println();
			index++;
		}
	}
}
