package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortWordsByAnagram {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("");
		list.add("abcdef");
		list.add("adkfjpq");
		list.add("abcfed");
		list.add("abp");
		list.add("pba");
		list.add("adkfpqj");
		list.add("abp");
		
		sortStringsByAnagram(list);
		
		for(String s: list) {
			System.out.println(s);
		}
	}
	
	public static void sortStringsByAnagram(List<String> list) {
		if (list.size() < 1)
			return;
		
		Map<String, List<String>> anagramMap = buildAnagramMap(list);
		
		convertToList(anagramMap, list);
		
	}
	
	private static Map<String, List<String>> buildAnagramMap(List<String> list) {
		Map<String, List<String>> anagramMap = new HashMap<>();
		
		for(String s: list) {
			String sortedStr = sort(s);
			List<String> anagramList = anagramMap.getOrDefault(sortedStr, null);
			
			if(anagramList == null) {
				anagramList = new ArrayList<>();
				anagramMap.put(sortedStr, anagramList);
			}
			
			anagramList.add(s);
		}
		
		return anagramMap;
 	}
	
	private static void convertToList(Map<String, List<String>> anagramMap, List<String> list) {
		list.clear();
		for(List<String> anList : anagramMap.values()) {
			for(String s : anList) {
				list.add(s);
			}
		}
	}
	
	private static String sort(String s) {
		char[] cArr = s.toCharArray();
		Arrays.sort(cArr);
		return String.copyValueOf(cArr);
	}
}
