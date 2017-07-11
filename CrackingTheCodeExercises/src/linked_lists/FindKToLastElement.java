package linked_lists;

/*
 * Cracking the Code Linked lists
 * 2.2
 */
public class FindKToLastElement {
	public static class LinkedList {
		int value;
		LinkedList next;
		LinkedList(int value){
			this.value = value;
			this.next = null;
		}
		
		public static LinkedList createLinkedList(int[] arr) {
			if(arr.length == 0)
				return null;
			
			LinkedList head = new LinkedList(arr[0]);
			LinkedList end = head;
			for(int i = 1; i < arr.length; i++) {
				end.next = new LinkedList(arr[i]);
				end = end.next;
			}
			
			return head;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		int k = 5;
		LinkedList head = LinkedList.createLinkedList(arr);
		
		LinkedList kthToLast = findKthToLast(head, k);
		
		if(kthToLast == null)
			System.out.println("K is null");
		else
			System.out.println(kthToLast.value);
	}
	
	public static LinkedList findKthToLast(LinkedList head, int k) {
		if (k < 0 || head == null)
			return null;
		
		LinkedList runner = head;
		
		for(int i = 0; i < k; i++) {
			runner = runner.next;
			if (runner == null)
				return null;
		}
		
		while(runner.next != null) {
			head = head.next;
			runner = runner.next;
		}
		
		return head;
	}
}
