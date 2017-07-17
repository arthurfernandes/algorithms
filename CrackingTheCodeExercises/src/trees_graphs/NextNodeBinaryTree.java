package trees_graphs;

/*
 * Cracking the Code 4.6 - In Order successor of a node
 */
public class NextNodeBinaryTree {
	public static void main (String[] args) {
		TreeNode el2 = new TreeNode(2);
		TreeNode el3 = new TreeNode(3);
		TreeNode root = new TreeNode(4);
		TreeNode el6 = new TreeNode(6);
		TreeNode el7 = new TreeNode(7);
		TreeNode el8 = new TreeNode(8);
		
		root.setLeftChild(el3);
		el3.setLeftChild(el2);
		root.setRightChild(el7);
		el7.setLeftChild(el6);
		el7.setRightChild(el8);
		
		System.out.println(nextNode(el2).data);
		System.out.println(nextNode(el3).data);
		System.out.println(nextNode(root).data);
		System.out.println(nextNode(el6).data);
		System.out.println(nextNode(el7).data);
		System.out.println(nextNode(el8));
	}
	
	
	public static class TreeNode {
		public TreeNode left, right, parent;
		public int data;
		
		public TreeNode(int data) {
			this.data = data;
			this.left = this.right = this.parent = null;
		}
		
		public void setLeftChild(TreeNode left) {
			this.left = left;
			this.left.parent = this;
		}
		
		public void setRightChild(TreeNode right) {
			this.right = right;
			this.right.parent = this;
		}
	}
	
	public static TreeNode nextNode(TreeNode n) {
		if (n == null) {
			return null;
		}
		
		if(n.right != null) {
			return leftMostChild(n.right);
		}
		else {
			TreeNode q = n.parent;
			while (q != null && q.left != n) {
				n = q;
				q = q.parent;
			}
			return q;
		}
	}

	
	public static TreeNode leftMostChild(TreeNode n) {
		if (n == null) {
			return null;
		}
		else {
			while (n.left != null) {
				n = n.left;
			}
			
			return n;
		}
	}
}
