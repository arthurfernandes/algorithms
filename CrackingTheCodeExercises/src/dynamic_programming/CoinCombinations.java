package dynamic_programming;

/*
 * Problem 9.8 Cracking the Code
 */
public class CoinCombinations {
	
	public static void main(String[] args) {
		for(int i = 0; i <= 100; i++) {
			System.out.println("Position: " + i);
			System.out.println(coinReps(i));
		}
	}
	
	public static int coinReps(int n) {
		if (n < 0) {
			return -1;
		}
		else {
			int[] coins = {25, 10, 5, 1};
			return makeChange(n, coins, 0);
		}
	}

	public static int makeChange(int n, int[] coins, int curCoin) {
		if (n == 0) {
			return 1;
		}
		
		int coin = coins[curCoin];
		
		if (curCoin == coins.length -1) { //On last coin, check if you can resolve
			if (n % coin == 0) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else {
			int ways = 0;
			for(int i = 0; i*coin <= n; i++) {
				ways += makeChange(n - i*coin, coins, curCoin + 1);
			}
			
			return ways;
		}
	}
}
