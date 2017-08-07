package dynamic_programming;

/*
 * Problem 9.8 Cracking the Code
 */
public class CoinCombinations {
	
	public static void main(String[] args) {
		System.out.println(coinReps(25));
	}
	
	public static int coinReps(int n) {
		if( n < 0) {
			return 0;
		}
		else {
			int[] cache = new int[n+1];
			cache[0] = 1;
			int[] coins = {1, 5, 10 , 25};
			return coinRepsHelper(n, coins, cache);
		}
	}
	
	public static int coinRepsHelper(int n, int[] coins, int[] cache) {
		if (n < 0)
			return 0;
		
		if(cache[n] != 0)
			return cache[n];
		
		int val = 0;
		for(int coin : coins)
			val += coinRepsHelper(n - coin, coins, cache);
		
		cache[n] = val;
		return val;
	}

}
