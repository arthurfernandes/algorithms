package trees_graphs;

import java.util.Iterator;
import java.util.Stack;

/*
 * Check if a Binary Tree is a Binary Search Tree
 * Cracking the Code problem 4.5
 * Using an In Order Iterator instead of just doing In Order Traversal and storing in array
 */
public class CheckBinarySearchTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.left.left = new TreeNode(0);
		root.left.left.right = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(10);
		root.right.right = new TreeNode(14);
		root.right.right.left = new TreeNode(12);
		root.right.right.right = new TreeNode(15);
		
		System.out.println(isBinarySearchTree(root));
	}
	
	public static boolean isBinarySearchTree(TreeNode root) {
		if (root == null)
			return true;
		
		InOrderIterator iterator = new InOrderIterator(root);
		int s0 = iterator.next();
		
		while (iterator.hasNext()) {
			int s1 = iterator.next();
			
			if (s0 > s1) {
				return false;
			}
			s0 = s1;
		}
		
		return true;
	}
	
	public static class TreeNode {
		public TreeNode left, right;
		public int data;
		
		public TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public static class InOrderIterator implements Iterator<Integer>{
		private Stack<TreeNode> nodeStack;
		
		public InOrderIterator(TreeNode root) {
			nodeStack = new Stack<>();
			pushLeftNodes(root);
		}
		
		
		@Override
		public boolean hasNext() {
			return !nodeStack.isEmpty();
		}

		@Override
		public Integer next() {
			TreeNode cur = nodeStack.pop();
			pushLeftNodes(cur.right);
			return cur.data;
		}
		
		private void pushLeftNodes(TreeNode node) {
			TreeNode cur = node;
			while (cur != null) {
				this.nodeStack.push(cur);
				cur = cur.left;
			}
		}
		
	}
}
