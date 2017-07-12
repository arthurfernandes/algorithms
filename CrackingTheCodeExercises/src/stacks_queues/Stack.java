package stacks_queues;

public class Stack<T>{
	private Node<T> top;
	
	public Stack() {
		top = null;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public T peek() {
		return top == null ? null : top.data;
	}
	
	public void push(T data) {
		final Node<T> node = new Node<>(data);
		if(this.isEmpty()) {
			top = node;
		}
		else {
			node.next = top;
			top = node;
		}
	}
	
	public T pop() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			T data = top.data;
			top = top.next;
			return data;
		}
	}
	
	static class Node<T> {
		T data;
		Node<T> next;
		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}
}
