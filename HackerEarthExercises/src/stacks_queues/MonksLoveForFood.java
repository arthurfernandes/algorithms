package stacks_queues;

/*
 * https://www.hackerearth.com/practice/data-structures/stacks/basics-of-stacks/tutorial/
 */
import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class MonksLoveForFood {
    public static String NO_FOOD_MESSAGE = "No Food";
    
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int Q = Integer.parseInt(br.readLine());
        Restaurant restaurant = new Restaurant();
        
        for(int q = 0; q < Q; q++){
            String[] query = br.readLine().split("\\s");
            if(query.length == 1){
                int cost = restaurant.customerQuery();
                if(cost == -1){
                    System.out.println(NO_FOOD_MESSAGE);
                }
                else{
                    System.out.println(cost);
                }
            }
            else{
                int cost = Integer.parseInt(query[1]);
                restaurant.chefQuery(cost);
            }
        }
    }
    
    public static class Restaurant {
        private Stack<Integer> pile;
        
        public Restaurant(){
            this.pile = new Stack<>();
        }
        
        public int customerQuery(){
            if(this.pile.isEmpty()){
                return -1;
            }
            else{
                return this.pile.pop();
            }
        }
        
        public void chefQuery(int cost){
            this.pile.push(cost);
        }
    }
}
