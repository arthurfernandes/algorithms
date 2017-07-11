package linked_lists;

/*
 * Cracking the Code LinkedLists 
 * 2.5
 */
public class LinkedListIntegerAddition {
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
		int[] arr1 = {1, 2};
		int[] arr2 = {2, 9, 4};
		LinkedList l1 = LinkedList.createFromArray(arr1);
		LinkedList l2 = LinkedList.createFromArray(arr2);
		
		LinkedList l3 = addReverseOrder(l1, l2);
		
		while(l3 != null) {
			System.out.print(l3.value);
			l3 = l3.next;
		}
	}
	
	
	
	public static LinkedList addReverseOrder(LinkedList l1, LinkedList l2) {
		if(l1 == null || l2 == null)
			return null;
		
		LinkedList head = null;
		LinkedList end = null;
		int carry = 0;
		
		while(l1 != null || l2 != null) {
			int sum = 0;
			if (l1 != null) {
				sum += l1.value;
				l1 = l1.next;
			}
			
			if (l2 != null) {
				sum += l2.value;
				l2 = l2.next;
			}
			
			sum += carry;
			carry = sum/10;
			
			LinkedList node = new LinkedList(sum%10);
			if(head == null) {
				head = node;
				end = node;
			}
			else {
				end.next = node;
				end = node;
			}
		}
		
		if(carry > 0) {
			end.next = new LinkedList(carry);
		}
		
		return head;
	}
}
