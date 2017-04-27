package challenge.others;


public class CollectCointDynamicProgram {

	static int R = 5;
	static int C = 5;

	static boolean isValid(int i, int j) {
		return (i >= 0 && i < R && j >= 0 && j < C);
	}

	static int maxCoinsUtil(char arr[][], int i, int j, int dir, int dp[][], int val) {
		if (isValid(i, j) == false || arr[i][j] == '#')
			return val;

		if (dp[i][j] > val)
			return dp[i][j];

		int result;

		if (arr[i][j] == 'C')
			result = 1;
		else
			result = 0;

		if (dir == 1)
			dp[i][j] = Math.max(maxCoinsUtil(arr, i, j + 1, 1, dp, val + result),
					maxCoinsUtil(arr, i + 1, j, 0, dp, val + result));
		else
			dp[i][j] = Math.max(maxCoinsUtil(arr, i, j - 1, 0, dp, val + result),
					maxCoinsUtil(arr, i + 1, j, 1, dp, val + result));

		return dp[i][j];
	}

	static int maxCoins(char arr[][]) {
		int dp[][] = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };

		int maxCoinsUtil = maxCoinsUtil(arr, 0, 0, 1, dp, 0);

		return maxCoinsUtil;
	}

	// Driver program to test above function
	public static void main(String arqs[]) {
		char[][] arr = { 
				{ 'E', 'C', 'C', 'C', 'C' }, 
				{ 'C', '#', 'C', '#', 'E' }, 
				{ '#', 'C', 'C', '#', 'C' }, 
				{ 'C', 'E', 'E', 'C', 'E' }, 
				{ 'C', 'E', '#', 'C', 'E' } 
			};

		System.out.println("Maximum number of collected coins is " + maxCoins(arr));
	}

}
