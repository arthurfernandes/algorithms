package stacks_queues;

public class TestCustomStackQueue {
	
	public static void main(String[] args) {
		//Test Stack
		System.out.println("Test Stack\n");
		Stack<Integer> st = new Stack<>();
		st.push(1);
		System.out.println(st.pop());
		st.push(2);
		st.push(3);
		st.push(4);
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.isEmpty());
		
		//Test Queue
		System.out.println("Test Queue\n");
		Queue<Integer> queue = new Queue<>();
		queue.enqueue(1);
		queue.enqueue(2);
		System.out.println(queue.dequeue());
		queue.enqueue(3);
		queue.enqueue(5);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.isEmpty());
		
	}
	
}
