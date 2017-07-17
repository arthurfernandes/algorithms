package trees_graphs;

/*
 * Cracking The Code question 4.1
 */
public class CheckBalancedBinaryTree {
	
	public static void main(String[] args) {
		Node root = new Node(0);
		Node left = root.left = new Node(1);
		Node right = root.right = new Node(2);
		
		left.left = new Node(3);
//		left.left.left = new Node(4);
		
		System.out.println(isBalanced(root));
	}
	
	public static class Node {
		Node left, right;
		int data;
		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	public static boolean isBalanced(Node root) {
		return isBalancedHelper(root) != -1;
	}
	
	/*
	 * Difference of left and right subtrees don't differ by more than 1
	 */
	private static int isBalancedHelper(Node node) {
		if (node == null) {
			return 0;
		}
		else {
			int leftHeight = isBalancedHelper(node.left);
			if (leftHeight == -1)
				return -1;
			
			int rightHeight = isBalancedHelper(node.right);
			if (rightHeight == -1)
				return -1;
			
			if (Math.abs(rightHeight - leftHeight) > 1)
				return -1;
			
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	
}
