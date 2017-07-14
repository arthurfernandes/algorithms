/*
 * Cracking the Code Linked Lists exercise 2.7 using the recursive approach
 */

#if false

#ifndef NULL
#define NULL ((void*) 0)
#endif


#include <iostream>
using namespace std;

struct LinkedList {
	int value;
	LinkedList *next;
};

bool isPalindromeHelper(LinkedList* cur, int length, LinkedList **node){
	if(length < 2){
		*node = cur;
		if(length == 1)
			(*node) = (*node)->next;
		return true;
	}

	bool ans = isPalindromeHelper(cur->next, length-2, node);

	if(!ans){
		return false;
	}
	else{
		bool res =  ((*node)->value == cur->value);
		*node = (*node)->next;
		return res;
	}
}

bool isPalindrome(LinkedList *head){
	if(head == NULL || head->next == NULL)
		return true;

	int length = 0;
	LinkedList* ptr = head;
	while(ptr != NULL){
		length += 1;
		ptr = ptr->next;
	}

	LinkedList *node;

	return isPalindromeHelper(head, length, &node);
}

void deleteList(LinkedList *head){
	while(head){
		LinkedList* next = head->next;
		delete head;
		head = next;
	}
}

int main() {
	int T;
	cin >> T;

	LinkedList *head, *cur;

	for(int test = 0; test < T; test++){
		cout << "Test " << test << ":" << endl;

		string palindromeString;
		cin >> palindromeString;


		for(int i = 0; i < palindromeString.size(); i++){
			LinkedList *node = new LinkedList();
			node->value = palindromeString[i];
			node->next = NULL;
			if(!head){
				head = node;
				cur = head;
			}
			else{
				cur->next = node;
				cur = node;
			}
		}

		bool ans = isPalindrome(head);

		if(ans){
			cout << "Is palindrome" << endl;
		}
		else{
			cout << "Isn't palindrome, sorry" << endl;
		}

		deleteList(head);
		head = cur = NULL;
	}

}

#endif

