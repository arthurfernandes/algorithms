/*
 * Max Heap implementation using dynamic resizing array (vector)
 * https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/tutorial/
 */

#if false

#include <iostream>
using namespace std;
#include <vector>

class MaxHeap {
private:
    vector<int> arr;

    int parent(int i) {return (i-1)/2;}
    int left(int i) { return 2*i +1;}
    int right(int i){ return 2*i + 2;}
    void swap(int i, int j);
public :
    bool is_empty();
    void insert(int val);
    int max();
};

void MaxHeap::swap (int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

bool MaxHeap::is_empty() {
    return arr.empty();
}

void MaxHeap::insert(int val) {
    arr.push_back(val);
    int index = arr.size() - 1;
    while(index != 0 && arr[parent(index)] < arr[index]){
        swap(index, parent(index));
        index = parent(index);
    }
}

int MaxHeap::max() {
    return arr[0];
}

int main()
{

    int N;
    cin >> N;
    MaxHeap m;

    for (int i = 0; i < N; i++) {
        int data;
        cin >> data;
        m.insert(data);
    }

    int Q;
    cin >> Q;

    for(int q = 0; q < Q; q++) {
        int op;
        cin >> op;
        if (op == 1) {
            int val;
            cin >> val;
            m.insert(val);
        }
        else {
            cout << m.max() << endl;
        }
    }
}

#endif
