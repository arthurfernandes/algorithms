/*
 * Crackign the Code 4.7 Find Common Ancestor of Binary Tree
 */

#if false

#ifndef NULL
#define NULL ((void *) 0)
#endif

#include <iostream>
using namespace std;

struct TreeNode {
	TreeNode *left, *right;
	int data;
	TreeNode(int data) : left(NULL), right(NULL), data(data) {}
};

TreeNode* findCommonAncestorHelper(TreeNode *root, TreeNode *p, TreeNode *q, bool &isCommonAncestor) {
	if (root == NULL || p == NULL || q == NULL) {
		return NULL;
	}

	TreeNode *left = findCommonAncestorHelper(root->left, p, q, isCommonAncestor);
	if(isCommonAncestor)
		return left;

	TreeNode *right = findCommonAncestorHelper(root->right, p, q, isCommonAncestor);
	if(isCommonAncestor)
		return right;

	if( (root == p && root == q) ||
			(left != NULL && right != NULL) ||
				((left != NULL || right != NULL) && (root == p || root == q))){
		isCommonAncestor = true;
		return root;
	}
	else {
		if (left != NULL)
			return left;
		else if (right != NULL)
			return right;
		else if (root == p || root == q)
			return root;
		else
			return NULL;
	}
}

TreeNode* findCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q) {
	bool isCommonAncestor = false;
	TreeNode* node = findCommonAncestorHelper(root, p, q, isCommonAncestor);
	if (isCommonAncestor) {
		return node;
	}
	else {
		return NULL;
	}
}

int main() {
	TreeNode *root = new TreeNode(6);
	root->left = new TreeNode(4);
	root->right = new TreeNode(8);
	root->right->left = new TreeNode(7);
	root->right->right = new TreeNode(10);
	root->left->left = new TreeNode(2);
	TreeNode *ca = findCommonAncestor(root, root->right->right, root->right->left);

	if(ca != NULL){
		cout << ca->data << endl;
	}
	else{
		cout << "No common ancestor found" << endl;
	}
}


#endif

