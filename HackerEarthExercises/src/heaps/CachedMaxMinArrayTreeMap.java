package heaps;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.TreeMap;

/*
 * Same implementation for the problem MaxMinArrayTreeMap caching the Max, Min values, because
 * in a TreeMap these operations run in O(logN) not O(1) as a PriorityQueue does
 * https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/practice-problems/algorithm/monk-and-some-queries/
 */

public class CachedMaxMinArrayTreeMap {
    private TreeMap<Integer, Integer> arr;
    private Integer cachedMax;
    private Integer cachedMin;
    
    public CachedMaxMinArrayTreeMap(){
        this.arr = new TreeMap<>();
        cachedMax = null;
        cachedMin = null;
    }
    
    public void updateCacheInsert(int val) {
        if (cachedMax != null && val > cachedMax)
            cachedMax = val;
        if (cachedMin != null && val < cachedMin)
            cachedMin = val;
    }
    
    public void insert(int val) {
        updateCacheInsert(val);
        
        Integer count = arr.get(val);
        if (count == null)
            count = 0;
        arr.put(val, count + 1);
    }
    
    public void updateCacheRemove(int val) {
        if (cachedMax != null && val == cachedMax)
            cachedMax = null;
        if (cachedMin != null && val == cachedMin)
            cachedMin = null;
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
                updateCacheRemove(val);
                arr.remove(val);
            }
            return true;
        }
    }
    
    public int getMax() {
        if (cachedMax != null)
            return cachedMax;
            
        if (this.arr.isEmpty())
            return -1;
        else{
            cachedMax = this.arr.lastKey();
            return cachedMax;
        }
    }
    
    public int getMin() {
        if (cachedMin != null)
            return cachedMin;
            
        if (this.arr.isEmpty())
            return -1;
        else{
            cachedMin = this.arr.firstKey();
            return cachedMin;
        }
    }
    
    public static void main(String args[] ) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       CachedMaxMinArrayTreeMap arr = new CachedMaxMinArrayTreeMap();
        
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
