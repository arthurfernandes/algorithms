package stacks_queues;

import java.util.Stack;

/*
 * Cracking the Code 3.6, sort a stack in ascending order using just one additional stack
 */
public class SortAscendingOrder {
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(2);
		stack.push(0);
		
		sort(stack);
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	
	public static void sort(Stack<Integer> stack) {
		final Stack<Integer> buffer = new Stack<>();
		if(stack.isEmpty())
			return;
		
		transferToBuffer(stack, buffer);
		transferFromBuffer(stack, buffer);
	}
	
	private static void transferTop(Stack<Integer> origin, Stack<Integer> destination) {
		destination.push(origin.pop());
	}
	
	private static void transferToBuffer(Stack<Integer> stack, Stack<Integer> buffer) {
		while(!stack.isEmpty()) {
			int elem = stack.pop();
			
			int transferCount = 0;
			while(!buffer.isEmpty() && elem > buffer.peek()) {
				transferTop(buffer, stack);
			}
			
			buffer.push(elem);
			
			while(transferCount > 0) {
				transferTop(stack, buffer);
				transferCount--;
			}
		}
	}
	
	private static void transferFromBuffer(Stack<Integer> stack, Stack<Integer> buffer) {
		while(!buffer.isEmpty()) {
			transferTop(buffer, stack);
		}
	}
	
}
