package stacks_queues;

public class Queue<T> {
	private Node<T> first, last;
	
	Queue(){
		this.first = this.last = null;
	}
	
	public boolean isEmpty() {
		return this.first == null;
	}
	
	public void enqueue(T data) {
		final Node<T> node = new Node<>(data);
		if(this.isEmpty()) {
			first = last = node;
		}
		else {
			last.next = node;
			last = node;
		}
	}
	
	public T dequeue() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			T data = this.first.data;
			this.first = this.first.next;
			return data;
		}
	}
	
	static class Node<T> {
		T data;
		Node<T> next;
		
		Node(T data){
			this.data = data;
			this.next = null;
		}
	}
}
