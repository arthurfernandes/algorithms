package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/litte-jhool-and-world-tour-1/
 *
 */

public class LittleJohlAndWorldTour {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(bf.readLine());
		while(tests > 0) {
			String[] nmLineString = bf.readLine().split("\\s");
			int N = Integer.parseInt(nmLineString[0]);
			int M = Integer.parseInt(nmLineString[1]);
			
			List<Interval> intervals = new ArrayList<>();
			
			for(int m = 0; m < M; m++) {
				String[] rangeLineString = bf.readLine().split("\\s");
				int start = Integer.parseInt(rangeLineString[0]);
				int end = Integer.parseInt(rangeLineString[1]);
				
				intervals.add(new Interval(start, end));
			}
			
			if(littleJohlCanSolve(intervals, M, N)) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			tests--;
		}
	}
	
	public static boolean littleJohlCanSolve(List<Interval> intervals, int M, int N) {
		if(M > N)
			return false;
		
		intervals = warppingAroundTransformation(intervals, N);
		sortInterval(intervals);
		//Priority Queue ordered according to the end position =)
		PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.end - o2.end;
			}	
		});
		int sweepPosition = 0;
		int index = 0;
		int intervalsSize = intervals.size();
		//loop
		while(index < intervalsSize) {
			//Fill pq, update sweep position
			if(pq.isEmpty()) {
				sweepPosition = intervals.get(index).start;
				pq.add(intervals.get(index));
				index += 1;
			}
			
			//fill with other intervals starting at the same index
			while(index < intervalsSize && intervals.get(index).start == sweepPosition) {
				pq.add(intervals.get(index));
				index += 1;
			}
			
			//remove from priority queue
			Interval cur = pq.remove();
			if (cur.end < sweepPosition) {
				return false;
			}
			
			//increment sweep position
			sweepPosition += 1;
		}
		
		return true;
	}
	
	public static List<Interval> warppingAroundTransformation(List<Interval> intervals, int N) {
		List<Interval> transformedIntervals = new ArrayList<>();
		for(Interval interval : intervals) {
			if (interval.start <= interval.end) {
				transformedIntervals.add(new Interval(interval.start, interval.end));
				transformedIntervals.add(new Interval(interval.start + N, interval.end + N));
			}
			else {
				transformedIntervals.add(new Interval(interval.start, interval.end + N));
			}
		}
		return transformedIntervals;
	}
	
	public static void sortInterval(List<Interval> intervals) {
		//Sort according to the start position
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
	}
	
	static class Interval{
		int start;
		int end;
		
		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}


