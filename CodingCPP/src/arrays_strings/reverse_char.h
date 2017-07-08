/*
 * reverse_char.h
 *
 *  Created on: Jul 8, 2017
 *      Author: arthurfernandes
 */

#ifndef ARRAYS_STRINGS_REVERSE_CHAR_H_
#define ARRAYS_STRINGS_REVERSE_CHAR_H_

#include <iostream>

using namespace std;

int MAX_STRING_SIZE = 1000;
char end_of_string = '\0';

void print_c_string(char *s, int length){
	for(int i = 0; i < length; i++){
		cout << s[i];
	}
}

void swap_chars(char* begin_pointer, char* end_pointer){
	char b = *begin_pointer;
	*begin_pointer = *end_pointer;
	*end_pointer = b;
}

void reverse_char(char* s){
	char *begin_pointer = s;
	char *end_pointer = s;
	char tmp;
	if(s){
		while(*end_pointer){
			end_pointer++;
		}
		end_pointer--;

		while(begin_pointer < end_pointer){
			tmp = *end_pointer;
			*end_pointer = *begin_pointer;
			*begin_pointer = tmp;
			begin_pointer++;
			end_pointer--;
		}
	}
}

#endif /* ARRAYS_STRINGS_REVERSE_CHAR_H_ */
