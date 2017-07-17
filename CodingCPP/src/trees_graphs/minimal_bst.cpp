/*
 * minimal_bst.cpp
 *
 *  Minimal BST from sorted array
 *  Cracking the Code 4.3
 */


#ifndef NULL
#define NULL ((void*) 0)
#endif

#include <iostream>

using namespace std;

struct TreeNode {
	TreeNode *left, *right;
	int data;

	TreeNode(int data): data(data), left(NULL), right(NULL) {};
};

TreeNode* createMinimalBST(int arr[], int low, int hi) {
	if (low > hi) {
		return NULL;
	}
	else {
		int mid = low + (hi - low)/2;
		TreeNode* node = new TreeNode(arr[mid]);
		node->left = createMinimalBST(arr, low, mid-1);
		node->right = createMinimalBST(arr, mid+1, hi);

		return node;
	}
}

TreeNode* createMinimalBST(int arr[], int n) {
	return createMinimalBST(arr, 0, n-1);
}

void printInOrder(TreeNode* node) {
	if (node == NULL){
		return;
	}
	else {
		printInOrder(node->left);
		cout << node->data << " ";
		printInOrder(node->right);
	}
}

int main(){
	int arr[] = {1, 2, 3, 4, 5};
	TreeNode* root = createMinimalBST(arr, 5);
	printInOrder(root);
}




