package linked_lists;

public class CircularLinkedListBeginningLoop {
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
		LinkedList head = new LinkedList(0);
		head.next = new LinkedList(1);
		head.next.next = new LinkedList(2);
		head.next.next.next = new LinkedList(3);
		head.next.next.next.next = head.next.next;
		
		LinkedList loop = findBeginningOfLoop(head);
		if (loop == null)
			System.out.println("NULL");
		else
			System.out.println(loop.value);
	}
	
	public static LinkedList findBeginningOfLoop(LinkedList head) {
		if(head == null || head.next == null)
			return null;
		
		if(head == head.next)
			return head;
		
		LinkedList slow, fast;
		slow = fast = head;
		
		slow = slow.next;
		fast = fast.next.next;
		
		//Find Collision Point at slow = fast
		while(slow != fast) {
			if (slow == null)
				return null;
			
			if (fast == null || fast.next == null)
				return null;
			
			slow = slow.next;
			fast = fast.next.next;
		}
		
		//Now change rate of fast and slow to the same
		slow = head;
		
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}
}
