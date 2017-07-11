package linked_lists;

/*
 * Cracking the Code Linked lists
 * 2.4
 */
public class PartitionLinkedListX {
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
		int[] arr = {1,2,3,4,5,6,7,8};
		int x = 5;
		LinkedList head = LinkedList.createFromArray(arr);
	
		head = partitionLinkedList(head, x);
		
		while(head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}
	
	public static LinkedList partitionLinkedList(LinkedList head, int x) {
		if(head == null || head.next == null) 
			return head;
		
		LinkedList cur = head.next;
		LinkedList end = head;
		head.next = null;
		
		while(cur != null) {
			LinkedList nextCur = cur.next;
			if(cur.value < x) {
				cur.next = head;
				head = cur;
			}
			else {
				end.next = cur;
				cur.next = null;
				end = cur;
			}
			cur = nextCur;
		}
		
		return head;
	}
}
