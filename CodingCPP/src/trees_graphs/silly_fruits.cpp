/*
 * silly_fruits.cpp
 *
 *  Hacker Earth Problem, the key here is the building process of the binary tree
 *  in order to traverse it in pre order
 *  https://www.hackerearth.com/practice/data-structures/trees/binary-and-nary-trees/practice-problems/algorithm/the-silly-snail-3/
 */

#if false

#ifndef NULL
#define NULL ((void*) 0)
#endif


#include <iostream>
using namespace std;

struct TreeNode {
    int data;
    TreeNode *left, *right;
    TreeNode(int data) : data(data), left(NULL), right(NULL) {}
};

void print_pre_order(TreeNode* root) {
    if (root != NULL){
        cout << root->data << " ";
        print_pre_order(root->left);
        print_pre_order(root->right);
    }
}

int main()
{
    TreeNode* n[100001] = {};

    int T;
    cin >> T;
    for(int t = 0; t < T; t++) {
        int N;
        cin >> N;

        TreeNode* root = new TreeNode(1);
        if (n[1])
            delete n[1];
        n[1] = root;

        for (int i = 0; i < N; i++) {
            int X,Y,Z;
            cin >> X;
            cin >> Y;
            cin >> Z;

            TreeNode* parent = n[X];
            if (Y != 0) {
                TreeNode* left = new TreeNode(Y);
                if (n[Y]){
                    delete n[Y];
                }
                n[Y] = left;
                parent->left = left;
            }

            if (Z != 0) {
                TreeNode* right = new TreeNode(Z);
                if (n[Z]){
                    delete n[Z];
                }
                n[Z] = right;
                parent->right = n[Z];
            }
        }

        print_pre_order(root);
        cout << endl;
    }

}

#endif
