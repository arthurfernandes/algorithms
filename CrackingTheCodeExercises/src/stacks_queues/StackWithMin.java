package stacks_queues;

/*
 * Cracking the Code Exercise 3.2, Stack with push,pop, min in O(1)
 */
public class StackWithMin extends java.util.Stack<Integer>{

	private static final long serialVersionUID = 1L;

	private java.util.Stack<Integer> minStack;
	
	StackWithMin(){
		super();
		minStack = new java.util.Stack<>();
	}
	
	@Override
	public Integer push(Integer data) {
		if(minStack.isEmpty() || data <= minStack.peek()) {
			minStack.push(data);
		}
		return super.push(data);
	}
	
	@Override
	public Integer pop() {
		if(this.peek() == minStack.peek()) {
			minStack.pop();
		}
		return super.pop();
	}
	
	public Integer min() {
		return minStack.peek();
	}
	
	
	public static void main(String[] args) {
		StackWithMin st = new StackWithMin();
		st.push(7);
		st.push(5);
		st.push(5);
		st.push(4);
		st.push(6);
		st.push(3);
		st.push(3);
		st.pop();
		st.pop();
		System.out.println(st.min());
		
	}
}
