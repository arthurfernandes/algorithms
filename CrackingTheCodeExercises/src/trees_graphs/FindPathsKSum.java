package trees_graphs;

import java.util.ArrayList;
import java.util.List;

/*
 * Cracking the Code 4.9, find k sum paths in Binary Tree
 */
public class FindPathsKSum {
	public static class TreeNode {
		public TreeNode left, right;
		public int data;
		public TreeNode(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	public static List<List<TreeNode>> findKSumPaths(TreeNode root, int k) {
		List<List<TreeNode>> pathsFound = new ArrayList<>();
		if (root == null) {
			return pathsFound;
		}
		else {
			int d = getDepth(root);
			TreeNode[] path = new TreeNode[d];
			
			findKSumPathsHelper(root, k, path, 0, pathsFound);
			return pathsFound;
		}
	}
	
	public static void findKSumPathsHelper(TreeNode root, int k, TreeNode[] path, int level, List<List<TreeNode>> pathsFound) {
		if (root == null) {
			return;
		}
		else {
			path[level] = root;
			
			int t = 0;
			for (int i = level; i >= 0; i--) {
				t += path[i].data;
				
				if (t == k) {
					List<TreeNode> pathFound = createPath(path, i, level);
					pathsFound.add(pathFound);
				}
			}
			
			findKSumPathsHelper(root.left, k, path, level + 1, pathsFound);
			findKSumPathsHelper(root.right,k, path, level + 1, pathsFound);
			
			path[level] = null;
		}
	}
	
	public static List<TreeNode> createPath(TreeNode[] path,int  start, int end) {
		List<TreeNode> pathFound = new ArrayList<>();
		for(int i = start; i <= end; i++) {
			pathFound.add(path[i]);
		}
		return pathFound;
	}
	
	public static int getDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		else {
			return 1 + Math.max(getDepth(root.left), getDepth(root.right));
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(-3);
		root.left.left = new TreeNode(-2);
		root.left.left.right = new TreeNode(6);
		
		List<List<TreeNode>> paths = findKSumPaths(root, 4);
		
		for(int i = 0; i < paths.size(); i++) {
			System.out.println("PATH: " + i);
			for(TreeNode node : paths.get(i)) {
				System.out.print(node.data + " ");
			}
			System.out.println();
		}
	}
}
