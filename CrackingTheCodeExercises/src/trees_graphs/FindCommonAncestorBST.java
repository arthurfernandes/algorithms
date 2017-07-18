package trees_graphs;

/*
 * Cracking the code problem 4.7 easier version, finding in a BST
 */
public class FindCommonAncestorBST {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(7);
		
		TreeNode random = new TreeNode(10);
		
		System.out.println(findCommonAncestorBST(root, root.left.left, root.right).data);
	}
	
	public static class TreeNode {
		public TreeNode left, right;
		public int data;
		public TreeNode(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	public static TreeNode findCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) {
			return null;
		}
		
		if (p == q) {
			return p;
		}
		
		if (p.data > root.data  && q.data > root.data) {
			return findCommonAncestorBST(root.right, p, q);
		}
		else if(p.data < root.data && q.data < root.data) {
			return findCommonAncestorBST(root.left, p, q);
		}
		else {
			if(findBST(root, p) && findBST(root, q)) {
				return root;
			}
			else {
				return null;
			}
		}
	}
	
	public static boolean findBST(TreeNode root, TreeNode p) {
		if (root == null) {
			return false;
		}
		else {
			if(p.data < root.data) {
				return findBST(root.left, p);
			}
			else if(p.data > root.data){
				return findBST(root.right, p);
			}
			else {
				return (root == p);
			}
		}
	}
}
