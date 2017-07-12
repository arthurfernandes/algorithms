package stacks_queues;

import java.util.Stack;

/*
 * Cracking the Code 3.4 Hanoi Tower with stacks
 */
public class HanoiToweWithStacks {
	public static void main(String[] args) {
		Stack<Integer> origin = new Stack<>();
		Stack<Integer> buffer = new Stack<>();
		Stack<Integer> destination = new Stack<>();
		
		int hanoiSize = 10;
		for(int i = hanoiSize-1; i >= 0; i--) {
			origin.push(i);
		}
		
		hanoi( origin, buffer,destination, hanoiSize);
		
		while(!destination.isEmpty()) {
			System.out.println(destination.pop());
		}
		
	}
	
	public static void hanoi(Stack<Integer> origin, Stack<Integer> buffer, Stack<Integer> destination, int N) {
		if(N == 1) {
			transferTop(origin,destination);
		}
		else {
			hanoi(origin, destination, buffer, N-1);
			
			transferTop(origin, destination);
			
			hanoi(buffer, origin, destination, N -1);
		}
	}
	
	private static void transferTop(Stack<Integer> A, Stack<Integer> B) {
		B.push(A.pop());
	}
}
