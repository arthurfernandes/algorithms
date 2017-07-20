package heaps;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

/*
 * Hacker Earth Problem, partially accepted solution
 * https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/practice-problems/algorithm/monk-in-the-grass-fields/
 */
class MonkInTheGrassFields {
    public static class ResponseData {
        public int columnOffset = 0;
        public int rowOffset = 0;
        public int discomfort = 0;
        public PriorityQueue<Integer> minHeap = null;
    }
    
    public static PriorityQueue<Integer> buildMinHeap(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int a : arr) {
            pq.add(a);
        }
        
        return pq;
    }
    
    public static ResponseData getMin(PriorityQueue<Integer> minHeapColumn, PriorityQueue<Integer> minHeapRow, 
            int rowOffset, int columnOffset){
                
        ResponseData r = new ResponseData();
        
        r.rowOffset = rowOffset;
        r.columnOffset = columnOffset;
        
        int minRow = minHeapRow.peek();
        int minColumn = minHeapColumn.peek();
        
        if(minRow + rowOffset < minColumn + columnOffset) {
            //Row for the win
            r.minHeap = minHeapRow;
            r.discomfort = minRow + rowOffset;
            r.columnOffset++;
        }
        else {
            //Column for the win
            r.minHeap = minHeapColumn;
            r.discomfort = minColumn + columnOffset;
            r.rowOffset++;
        }
        
        return r;
    }
    
    public static void updateHeapMin(PriorityQueue<Integer> minHeap, int N) {
        int min = minHeap.remove();
        minHeap.add(min + N);
    }
    
    public static int minDiscomfort(int[][] arr, int K) {
        int N = arr.length;
        int[] sumColumn = new int[N];
        int[] sumRow = new int[N];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sumColumn[j] += arr[i][j];
                sumRow[i] += arr[i][j];
            }
        }
        
        PriorityQueue<Integer> minHeapColumn = buildMinHeap(sumColumn);
        PriorityQueue<Integer> minHeapRow = buildMinHeap(sumRow);
        
        int rowOffset = 0, columnOffset = 0;
        int discomfort = 0;
        
        for(int i = 0; i < K; i++) {
            ResponseData r = getMin(minHeapColumn, minHeapRow, rowOffset, columnOffset);
            discomfort += r.discomfort;
            rowOffset = r.rowOffset;
            columnOffset = r.columnOffset;
            
            if (i != K-1) {
                updateHeapMin(r.minHeap, N);    
            }
        }
        
        return discomfort;
    }
    
    public static void main(String args[] ) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < T; t++) {
            StringTokenizer kn = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(kn.nextToken());
            int K = Integer.parseInt(kn.nextToken());
            
            int arr[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int min = minDiscomfort(arr, K);
            System.out.println(min);
        }
    }
}
