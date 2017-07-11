package linked_lists;

import java.util.Stack;

public class LinkedListPalindrome {
	public static class LinkedList {
		int value;
		LinkedList next;
		LinkedList(int value){
			this.value = value;
			this.next = null;
		}
		
		public static LinkedList createFromArray(int[] arr) {
			if(arr.length == 0)
				return null;
			
			LinkedList head = new LinkedList(arr[0]);
			LinkedList cur = head;
			for(int i = 1; i < arr.length; i++) {
				cur.next = new LinkedList(arr[i]);
				cur = cur.next;
			}
			
			return head;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {'c', 'a', 'c', 'b', 'a', 'c'};
		LinkedList head = LinkedList.createFromArray(arr);
		
		boolean test = isPalindrome(head);
		System.out.println(test);
	}
	
	public static boolean isPalindrome(LinkedList head) {
		if(head == null || head.next == null)
			return true;
		
		LinkedList slow, fast;
		
		slow = head;
		fast = head;
		
		Stack<Integer> stack = new Stack<>();
		stack.add(slow.value);
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(fast != null && fast.next != null) {
				stack.push(slow.value);
			}
			
			if(fast != null && fast.next == null) {
				slow = slow.next;
			}
		}
		
		while(slow != null) {
			int elem = stack.pop();
			if(elem != slow.value)
				return false;
			slow = slow.next;
		}
		
		return true;
	}
}
