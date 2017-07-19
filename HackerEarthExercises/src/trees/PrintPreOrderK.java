package trees;

/*
 * Hacker Earth Simple Problem, BST Insert and PreOrder
 * https://www.hackerearth.com/practice/data-structures/trees/binary-search-tree/tutorial/
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

class PrintPreOrderK {
    public static class TreeNode {
        public int data;
        public TreeNode left, right;
        public TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    
    public static TreeNode insertBST(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }
        else {
            if (data <= root.data) {
                root.left = insertBST(root.left, data);
            }
            else {
                root.right = insertBST(root.right, data);
            }
            
            return root;
        }
    }
    
    public static TreeNode findBST(TreeNode root, int k){
        if (root == null) {
            return null;
        }
        else {
            if (k == root.data) {
                return root;
            }
            else if (k < root.data) {
                return findBST(root.left, k);
            }
            else {
                return findBST(root.right, k);
            }
        }
    }
    
    public static void printPreOrder(TreeNode root) {
        if (root == null)
            return;
            
        System.out.println(root.data);
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
    
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int rootData = Integer.parseInt(st.nextToken());
        TreeNode root = new TreeNode(rootData);
        
        for (int i = 1; i < N; i++) {
            int data = Integer.parseInt(st.nextToken());
            insertBST(root, data);
        }
        
        int K = Integer.parseInt(br.readLine());
        TreeNode kNode = findBST(root, K);
        printPreOrder(kNode);
    }
}

