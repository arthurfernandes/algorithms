/*
 * Hacker Earth Problem Binary Tree
 * https://www.hackerearth.com/practice/data-structures/trees/binary-and-nary-trees/practice-problems/algorithm/tree-counting-3/description/
 * Brute force solution in O(N^3) because N < 500
 */
#if false

#include <iostream>
using namespace std;

int main()
{
    int N, K;
    cin >> N;
    cin >> K;

    int tree_data[N];
    for(int i = 0; i < N; i++){
        cin >> tree_data[i];
    }

    int parent[N];
    parent[0] = -1;
    for(int i = 1; i < N; i++) {
        int data;
        cin >> data;
        parent[i] = data - 1;
    }

    bool anc[N][N];
    for (int i = 0; i < N; i++)
        for(int j = 0; j < N; j++)
            anc[i][j] = false;

    int count = 0;

    for (int i = 1; i < N; i++) {
        int cur = parent[i];
        while(cur != -1) {
            anc[cur][i] = true;
            cur = parent[cur];
        }
    }

    for(int i = 0; i < N; i++) {
        for (int j = 1; j < N; j++) {
            for (int k = 1; k < N; k++) {

                if (i !=j && j != k && anc[i][j] && anc[i][k]){
                    long sum = ((long)tree_data[i]) + ((long)tree_data[j]) + ((long)tree_data[k]);
                    if (sum >= K)
                        count++;
                }
            }
        }
    }
    //Remove duplicates, because we count i, j, k and i, k, j

    cout << count/2 << endl;
}

#endif


