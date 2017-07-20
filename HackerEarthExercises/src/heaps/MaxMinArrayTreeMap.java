package heaps;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.TreeMap;

/*
 * Implementation of the same problem of MaxMinHeap using a TreeMap
 * 
 */
public class MaxMinArrayTreeMap{
    private TreeMap<Integer, Integer> arr;
    
    public MaxMinArrayTreeMap(){
        this.arr = new TreeMap<>();
    }
    
    public void insert(int val) {
        Integer count = arr.get(val);
        if (count == null)
            count = 0;
        arr.put(val, count + 1);
    }
    
    public boolean remove(int val) {
        Integer count = arr.get(val);

        if (count == null) {
            return false;
        }
        else {
            if (count > 1) {
                arr.put(val, count - 1);
            }
            else {
                arr.remove(val);
            }
            return true;
        }
    }
    
    public int getMax() {
        if (this.arr.isEmpty())
            return -1;
        else
            return this.arr.lastKey();
    }
    
    public int getMin() {
        if (this.arr.isEmpty())
            return -1;
        else
            return this.arr.firstKey();
    }
    
    public static void main(String args[] ) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MaxMinArrayTreeMap arr = new MaxMinArrayTreeMap();
        
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
