package heaps;

import java.util.ArrayList;

public class MaxPriorityQueue {
	public static void main(String[] args) {
		MaxPriorityQueue queue = new MaxPriorityQueue();
		queue.insert(1);
		queue.insert(1);
		queue.insert(2);
		queue.insert(-1);
		queue.insert(3);
		queue.insert(-2);
		
		while(!queue.isEmpty()) {
			System.out.println(queue.removeMax());
		}
		
		try {
			queue.removeMax();
		}
		catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private ArrayList<Integer> arr;
	
	public MaxPriorityQueue() {
		this.arr = new ArrayList<>();
	}
	
	public void insert(int val) {
		arr.add(val);
		int curIndex = arr.size() - 1;
		int parentIndex = parent(curIndex);
		while(parentIndex != -1 && arr.get(parentIndex) < arr.get(curIndex)) {
			swap(parentIndex, curIndex);
			curIndex = parentIndex;
			parentIndex = parent(parentIndex);
		}
	}
	
	public int removeMax() throws NoSuchElementException{
		if (arr.isEmpty())
			throw new NoSuchElementException("Priority Queue is empty");
		
		swap(0, arr.size() - 1);
		int max = arr.remove(arr.size() - 1);
		
		max_heapify(0);
		
		return max;
	}
	
	public int getMax() throws NoSuchElementException{
		if (arr.isEmpty())
			throw new NoSuchElementException("Priority Queue is empty");
		return arr.get(0);
	}
	
	public boolean isEmpty() {
		return arr.isEmpty();
	}
	
	public static class NoSuchElementException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public NoSuchElementException(String message) {
			super(message);
		}
	}
	
	private void swap(int i, int j) {
		int temp = this.arr.get(i);
		this.arr.set(i, this.arr.get(j));
		this.arr.set(j, temp);
	}
	
	private int parent(int i) {
		if (i == 0)
			return -1;
		else
			return (i-1)/2;
	}
	
	private int leftChild(int i) {
		return 2*i + 1;
	}
	
	private int rightChild(int i) {
		return 2*i + 2;
	}
	
	private void max_heapify(int index) {
		if (index < arr.size() - 1) {
			int biggestIndex = index;
			int leftIndex = leftChild(index);
			int rightIndex = rightChild(index);
			
			if (leftIndex < arr.size()) {
				if (arr.get(index) < arr.get(leftIndex)) {
					biggestIndex = leftIndex;
				}
			}
			
			if (rightIndex < arr.size()) {
				if (arr.get(biggestIndex) < arr.get(rightIndex)) {
					biggestIndex = rightIndex;
				}
			}
			
			if (biggestIndex != index) {
				swap (biggestIndex, index);
				max_heapify(biggestIndex);
			}
		}
	}
}
