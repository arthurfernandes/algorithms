package stacks_queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

/*
 * https://www.hackerearth.com/practice/data-structures/stacks/basics-of-stacks/practice-problems/algorithm/monk-and-order-of-phoenix/
 */
public class MonkAndOrderOfPhoenix {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		
		VoldemortArmy vArmy = VoldemortArmy.makeVoldemortArmy(N);
		
		//ReadData
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Integer stackSize = Integer.parseInt(st.nextToken());
			for(int j = 0; j < stackSize; j++) {
				int height = Integer.parseInt(st.nextToken());
				vArmy.addToRow(i, height);
			}
		}
		
		int Q = Integer.parseInt(br.readLine());
		//Operations
		for(int q = 0; q < Q; q++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int opType = Integer.parseInt(st.nextToken());
			int k, h;
			boolean ans;
			switch(opType) {
				case 0:
					k = Integer.parseInt(st.nextToken());
					vArmy.removeFromRow(k-1);
					break;
				case 1:
					k = Integer.parseInt(st.nextToken());
					h = Integer.parseInt(st.nextToken());
					vArmy.addToRow(k-1, h);
					break;
				case 2:
					ans = vArmy.harryCanUseSpell();
					if(ans)
						System.out.println("YES");
					else
						System.out.println("NO");
					break;
				default:
					break;
			}
		}
		
		
	}
	
}

final class VoldemortArmy {
	
	private StackBinarySearch[] rows;
	private List<Integer> minFirstRow;
	private int cachedResult;
	
	
	private VoldemortArmy(int N) {
		rows = new StackBinarySearch[N];
		minFirstRow = new ArrayList<>();
		cachedResult = 0;
		for(int i = 0; i < N; i++)
			rows[i] = new StackBinarySearch();
	}
	
	public static VoldemortArmy makeVoldemortArmy(int N) {
		if(N < 1 || N > 10) {
			return null;
		}
		else {
			return new VoldemortArmy(N);
		}
	}
	
	public void addToRow(int row, int height) {
		if (cachedResult == -1) {
			cachedResult = 0;
		}
		
		this.rows[row].push(height);
		if (row == 0) {
			if (minFirstRow.isEmpty()) {
				minFirstRow.add(height);
			}
			else {
				int lastMin = minFirstRow.get(minFirstRow.size()-1);
				minFirstRow.add(Math.min(lastMin, height));
			}
		}
	}
	
	public int removeFromRow(int row) {
		int elem = this.rows[row].pop();
		
		if (row == 0) {
			minFirstRow.remove(minFirstRow.size() - 1);
		}
		
		if (cachedResult == 1) {
			cachedResult = 0;
		}
		
		return elem;
	}
	
	public boolean harryCanUseSpell() {
		if (cachedResult != 0) {
			return cachedResult == 1;
		}
		else {
			boolean ans = true;
			if (rows[0].isEmpty()) {
				ans = false;
			}
			else {
				int lastMin = minFirstRow.get(minFirstRow.size() - 1);
				for (int i = 1; i < rows.length; i++) {
					Optional<Integer> min = rows[i].higher(lastMin);
					if(!min.isPresent()) {
						ans = false;
						break;
					}
					else {
						lastMin = min.get();
					}
				}
			}
			
			cachedResult = ans ? 1 : -1;
			return ans;
		}
	}
}

class StackBinarySearch {
	private ArrayList<Integer> st;
	
	public StackBinarySearch() {
		st = new ArrayList<>();
	}
	
	public boolean isEmpty() {
		return st.isEmpty();
	}
	
	public void push(int data) {
		st.add(data);
	}
	
	public int pop() {
		return st.remove(st.size() - 1);
	}
	
	public Optional<Integer> higher(int k){
		if (st.isEmpty())
			return Optional.empty();
		
		int low = 0;
		int hi = st.size() - 1;
		
		Optional<Integer> ans = Optional.empty();
		
		while (low <= hi) {
			int mid = low + (hi-low)/2;
			if (k < st.get(mid)) {
				ans = Optional.of(st.get(mid));
				hi = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		
		return ans;
	}
}