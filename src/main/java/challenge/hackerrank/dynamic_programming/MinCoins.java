package challenge.hackerrank.dynamic_programming;

//A Naive recursive JAVA program to find minimum of coins
//to make a given change V
public class MinCoins {
	// m is size of coins array (number of different coins)
	static int minCoins(int coins[], int m, int V) {
		// base case
		if (V == 0)
			return 0;

		// Initialize result
		int res = Integer.MAX_VALUE;

		// Try every coin that has smaller value than V
		for (int i = 0; i < m; i++) {
			if (coins[i] <= V) {
				int sub_res = minCoins(coins, m, V - coins[i]);

				// Check for INT_MAX to avoid overflow and see if
				// result can minimized
				if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
					res = sub_res + 1;
			}
		}
		return res;
	}

	public static void main(String args[]) {
		int coins[] = { 1, 3, 5 };
		int m = coins.length;
		int V = 3;
		System.out.println("Minimum coins required is " + minCoins(coins, m, V));
	}
}