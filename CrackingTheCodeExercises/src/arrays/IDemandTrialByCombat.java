package arrays;

/*
 * Hacker Earth Problem
 * https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/i-demand-trial-by-combat-13/
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IDemandTrialByCombat {
	public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tLine = br.readLine();
        int T = Integer.parseInt(tLine);
        for(int t = 0; t < T; t++){
            String[] mnStrings = br.readLine().split("\\s");
            int N = Integer.parseInt(mnStrings[0]);
            int M = Integer.parseInt(mnStrings[1]);
            int lannisters[] = new int[N];
            int k = 0;
            for(String lannister: br.readLine().split("\\s")){
                int lannisterInt = Integer.parseInt(lannister);
                lannisters[k] = lannisterInt;
                k++;
            }
            mutateLannisters(lannisters, M);
            //Print it out
            printLannisters(lannisters);
        }
    }
    
    public static void printLannisters(int[] lannisters){
        for(int i = 0; i < lannisters.length; i++){
            if(i < lannisters.length-1){
                System.out.print(lannisters[i]);
                System.out.print(" ");
            }
            else{
                System.out.println(lannisters[i]);
            }
        }
    }
    
    public static void mutateLannisters(int[] lannisters, int M){
        if(M == 0)
            return;
            
        for(int i = 0; i < M; i++){//#of hours
            boolean isModified = false;
            int lastElem = 0;
            for(int j = 0; j < lannisters.length; j++){//Mutate each lannister
                int elem = lannisters[j];
                if(j == 0){ lannisters[j] = lannisters[j+1];}
                else if(j == lannisters.length - 1){ lannisters[j] = lastElem;}
                else{
                    lannisters[j] = (lastElem + lannisters[j+1] == 2) ? 1 : 0;
                }
                
                if(elem != lannisters[j])
                    isModified |= true;
                lastElem = elem;
            }
            if(!isModified)
                return;
        }
    }
}
