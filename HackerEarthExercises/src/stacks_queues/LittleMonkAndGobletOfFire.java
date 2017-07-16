package stacks_queues;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

/*
 * https://www.hackerearth.com/practice/data-structures/queues/basics-of-queues/practice-problems/algorithm/little-monk-and-goblet-of-fire/
 */
class LittleMonkAndGobletOfFire {
    private Node first, last;
    private Node[] schoolFirst, schoolLast;
    
    public LittleMonkAndGobletOfFire(int schoolNumber){
        this.first = null;
        this.last = null;
        this.schoolLast = new Node[schoolNumber];
        this.schoolFirst = new Node[schoolNumber];
    }
    
    public void enqueue(int school, int rollNumber){
        Node node = new Node(school, rollNumber);
        if (this.schoolFirst[school] != null) {
            Node temp = this.schoolLast[school].next;
            this.schoolLast[school].next = node;
            node.prev = this.schoolLast[school];
            node.next = temp;
            
            this.schoolLast[school] = node;
            
            if (temp != null) {
                temp.prev = node;
            }
            else{
                this.last = this.schoolLast[school];
            }
        }
        else{
            node.prev = this.last;
            
            this.schoolFirst[school] = this.schoolLast[school] = node;
            
            if (this.last != null) {
                this.last.next = node;
                this.last = node;
            }
            else {
                this.last = this.first = node;
            }
        }
    }
    
    public Node dequeue() {
        if(this.first == null) {
            return null;
        }
        else{
            Node ans =  this.first;
            
            for(int i = 0; i < schoolFirst.length; i++) {
                if (schoolFirst[i] != null && schoolFirst[i] == this.first) {
                    if(schoolLast[i] == schoolFirst[i]) {
                        schoolFirst[i] = schoolLast[i] = null;
                    }
                    else {
                        schoolFirst[i] = schoolFirst[i].next;
                    }
                }
            }
            
            if (this.first == this.last) {
                this.first = this.last = null;
            }
            else{
                this.first = this.first.next;
                this.first.prev = null;
            }
            
            ans.next = ans.prev = null;
            
            return ans;
        }
    }
    
    public static class Node{
        public int school;
        public int rollNumber;
        public Node next;
        public Node prev;
        
        public Node(int school, int rollNumber){
            this.school = school;
            this.rollNumber = rollNumber;
            this.next = null;
            this.prev = null;
        }
    }
    
    public static void main(String args[] ) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       LittleMonkAndGobletOfFire queue = new LittleMonkAndGobletOfFire(4);
       
       int Q = Integer.parseInt(br.readLine());
       
       for(int q = 0; q < Q; q++){
           StringTokenizer st = new StringTokenizer(br.readLine()," ");
           String op = st.nextToken();
           if(op.equals("E")){
               int school = Integer.parseInt(st.nextToken());
               int rollNumber = Integer.parseInt(st.nextToken());
               queue.enqueue(school - 1, rollNumber);
           }
           else{
               Node ans = queue.dequeue();
               System.out.println((ans.school+1) + " " + ans.rollNumber);
           }
       }
    }
}
