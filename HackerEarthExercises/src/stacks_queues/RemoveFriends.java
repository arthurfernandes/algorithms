package stacks_queues;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayDeque;

/*
 * https://www.hackerearth.com/practice/data-structures/linked-list/singly-linked-list/practice-problems/algorithm/remove-friends-5/
 */
public class RemoveFriends {
	
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine(), " ");
            int[] friends = new int[N];
            
            for(int i = 0; i < N; i++){
                friends[i] = Integer.parseInt(st.nextToken());
            }
            
            printFriendsAfterKRemoval(friends, K);
        }
    }
    
    public static void printFriendsAfterKRemoval(int[] friends, int K) {
        ArrayDeque<Integer> friendsDeque = new ArrayDeque<>();
        
        int deletions = 0;
        int pointer = 1;
        
        friendsDeque.add(friends[0]);
        
        while(pointer < friends.length && deletions < K) {
            Integer head = friendsDeque.peekLast();
            
            if(head == null) {
                friendsDeque.add(friends[pointer]);
                pointer++;
            }
            else{
                if (head < friends[pointer]){
                    friendsDeque.pollLast();
                    deletions++;
                }
                else {
                    friendsDeque.add(friends[pointer]);
                    pointer++;
                }
            }
        }
        
        while(deletions < K) {
            friendsDeque.pop();
            deletions++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int friend : friendsDeque) {
            sb.append(friend);
            sb.append(" ");
        }
        
        for(int i = pointer; i < friends.length; i++){
            sb.append(friends[i]);
            sb.append(" ");
        }
        sb.append("\n");
        System.out.print(sb);
        System.out.flush();
        System.out.close();
    }
}
