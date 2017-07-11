#if false
#include "reverse_char.h"

int main() {
	string ss = "12345678";
	char s[ss.size() + 1];
	int size = ss.size();

	for(int i = 0; i < size+1; i++){
		s[i] = ss[i];
	}

	reverse_char(s);
	print_c_string(s, size);
}

#endif



