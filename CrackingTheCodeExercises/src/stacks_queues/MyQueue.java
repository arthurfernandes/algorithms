package stacks_queues;

import java.util.Stack;

/*
 * Cracking the Code MyQueue, implement Queue from Two Stacks
 */
public class MyQueue<T> {
	private Stack<T> insertStack, popStack;
	
	public MyQueue() {
		this.insertStack = new Stack<>();
		this.popStack = new Stack<>();
	}
	
	public void enqueue(T data) {
		this.insertStack.push(data);
	}
	
	public T dequeue() {
		if(this.isEmpty()) {
			return null;
		}
		else if(!this.popStack.isEmpty()) {
			return this.popStack.pop();
		}
		else {
			while(!this.insertStack.isEmpty()) {
				this.popStack.push(this.insertStack.pop());
			}
			return this.popStack.pop();
		}
	}
	
	public boolean isEmpty() {
		return this.insertStack.isEmpty() && this.popStack.isEmpty();
	}
	
	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		System.out.println(queue.dequeue());
		queue.enqueue(4);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
	}
}
