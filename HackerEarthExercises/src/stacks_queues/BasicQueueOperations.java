package stacks_queues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.hackerearth.com/practice/data-structures/queues/basics-of-queues/tutorial/
 * Basic Queue operations
 */
public class BasicQueueOperations {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue queue = new Queue();
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String op = st.nextToken();
            if(op.equals("E")){
                int data = Integer.parseInt(st.nextToken());
                queue.enqueue(data);
                System.out.println(queue.size());
            }
            else{
                int data = queue.dequeue();
                System.out.println(data + " " + queue.size());
            }
        }
    }
    
    public static class Queue {
        private int[] queue;
        private int front, rear;
        
        public Queue(){
            this.queue = new int[100];
            front = rear = 0;
        }
        
        public boolean enqueue(int data) {
            if (rear < queue.length){
                this.queue[rear++] = data;
                return true;
            }
            return false;
        }
        
        public int dequeue() {
            if (rear == front) {
                return -1;
            }
            else{
                return this.queue[front++];
            }
        }
        
        public boolean isEmpty(){
            return rear == front;
        }
        
        public int size(){
            return rear - front;
        }
    }
}
