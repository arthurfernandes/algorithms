package trees_graphs;

/*
 * Cracking the Code 4.8 - Find if a Tree T2 is a subtree of Tree T1
 */
public class IsSubtree {
	public static class TreeNode {
		public TreeNode left, right;
		public int data;
		public TreeNode(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(0);
		t1.left = new TreeNode(1);
		t1.left.left = new TreeNode(2);
		t1.left.right = new TreeNode(3);
		t1.left.left.left = new TreeNode(4);
		t1.right = new TreeNode(5);
		t1.right.right = new TreeNode(6);
		t1.right.right.left = new TreeNode(7);
		t1.right.right.right = new TreeNode(8);
		
		TreeNode t2 = new TreeNode(6);
		t2.left = new TreeNode(7);
		t2.right = new TreeNode(8);
		
		System.out.println(isSubtree(t1, t2));
	}
	
	public static boolean isSubtree(TreeNode t1, TreeNode t2) {
		if (t2 == null)
			return true;
		if (t1 == null)
			return false;
		
		if (t1.data == t2.data) {
			if(treeMatch(t1, t2))
				return true;
		}

		return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
	}
	
	public static boolean treeMatch(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return true;
		
		if (t1 == null || t2 == null)
			return false;
		
		if (t1.data != t2.data)
			return false;
		
		return treeMatch(t1.left, t2.left) && treeMatch(t1.right, t2.right);
	}
}
