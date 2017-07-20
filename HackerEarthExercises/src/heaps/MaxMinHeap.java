package heaps;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Collections;
import java.util.PriorityQueue;

/*
 * Hacker Earth Priority Queue Exercise
 * https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/practice-problems/algorithm/monk-and-some-queries/
 */
class MaxMinHeap {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    
    public MaxMinHeap(){
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.minHeap = new PriorityQueue<>();
    }
    
    public void insert(int val) {
        this.maxHeap.add(val);
        this.minHeap.add(val);
    }
    
    public boolean remove(int val) {
        if(this.maxHeap.remove(val)){
            this.minHeap.remove(val);
            return true;
        }
        else{
            return false;
        }
    }
    
    public int getMax() {
        if (maxHeap.isEmpty())
            return -1;
        else
            return maxHeap.peek();
    }
    
    public int getMin() {
        if (minHeap.isEmpty())
            return -1;
        else 
            return minHeap.peek();
    }
    
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MaxMinHeap arr = new MaxMinHeap();
        int Q = Integer.parseInt(br.readLine());
        for (int q = 0; q < Q; q++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int op = Integer.parseInt(st.nextToken());
            if(op == 1) {
                int val = Integer.parseInt(st.nextToken());
                arr.insert(val);
            }
            else if (op == 2){
                int val = Integer.parseInt(st.nextToken());
                if (!arr.remove(val)){
                    System.out.println("-1");
                }
            }
            else if (op == 3) {
                int max = arr.getMax();
                System.out.println(max);
            }
            else {
                int min = arr.getMin();
                System.out.println(min);
            }
        }
    }
}
