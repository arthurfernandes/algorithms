//https://www.hackerearth.com/practice/data-structures/stacks/basics-of-stacks/practice-problems/algorithm/little-monk-and-balanced-parentheses/

#include <iostream>
#include <stack>
#include <algorithm>

using namespace std;

struct problem_params {
    int ans;
    int temp_ans;
    int sum;
    int N;
    
    problem_params(): ans(0), temp_ans(0), sum(0), N(0) {}
} params;

int next_elem(int N){
    static int i = 0;
    if(i < N){
        int elem;
        cin >> elem;
        i++;
        return elem;
    }
    else{
        return 0;
    }
}

bool is_valid_pop(stack<int> &st, int elem) {
    return (st.top() + elem) == 0;
}

void empty_stack(stack<int> &st){
    while(st.size() > 0){
        st.pop();
    }
}

void find_next_start(){
    int elem;
    while(params.sum != 0 && (elem = next_elem(params.N))){
        params.sum += elem;
    }
}

int longest_subarray(int N){
    if(N < 2)
        return 0;
    params.N = N;
    
    stack<int> st;
    int elem;
    while(elem = next_elem(N)){
        if (elem > 0){
            st.push(elem);
            params.sum += elem;
            params.temp_ans += 1;
        }
        else{
            if(is_valid_pop(st, elem)){
                st.pop();
                params.sum += elem;
                params.temp_ans += 1;
                
                if(st.empty()){
                    params.ans = max(params.ans, params.temp_ans);
                    params.sum = 0;
                }
            }
            else{
                params.sum += elem;
                empty_stack(st);
                find_next_start();
                params.temp_ans = 0;
            }
        }
    }
    
    return params.ans;
}

int main()
{
    int N;
    cin >> N;
    int ans = longest_subarray(N);
    cout << ans << endl;
}

