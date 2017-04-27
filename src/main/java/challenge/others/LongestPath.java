package challenge.others;


public class LongestPath {

	static final int n = 3;

	static int findLongestOverAll(int mat[][]) {
		int result = 1;

		int[][] dp = { { -1, -1, -1 }, { -1, -1, -1 }, { -1, -1, -1 } };

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (dp[i][j] == -1)
					findLongestFromACell(i, j, mat, dp);

				result = Math.max(result, dp[i][j]);
			}
		}

		return result;
	}

	static int findLongestFromACell(int i, int j, int[][] mat, int[][] dp) {
		if (i < 0 || i >= n || j < 0 || j >= n)
			return 0;

		// If this subproblem is already solved
		if (dp[i][j] != -1)
			return dp[i][j];

		// Since all numbers are unique and in range from 1 to n*n,
		// there is atmost one possible direction from any cell
		if (j < n - 1 && ((mat[i][j] + 1) == mat[i][j + 1]))
			return dp[i][j] = 1 + findLongestFromACell(i, j + 1, mat, dp);

		if (j > 0 && (mat[i][j] + 1 == mat[i][j - 1]))
			return dp[i][j] = 1 + findLongestFromACell(i, j - 1, mat, dp);

		if (i > 0 && (mat[i][j] + 1 == mat[i - 1][j]))
			return dp[i][j] = 1 + findLongestFromACell(i - 1, j, mat, dp);

		if (i < n - 1 && (mat[i][j] + 1 == mat[i + 1][j]))
			return dp[i][j] = 1 + findLongestFromACell(i + 1, j, mat, dp);

		// If none of the adjacent fours is one greater
		return dp[i][j] = 1;
	}

	public static void main(String[] args) {
		int mat[][] = { 
				{ 1, 2, 9 }, 
				{ 5, 3, 8 }, 
				{ 4, 6, 7 },
		};

		System.out.println("Length of the longest path is " + findLongestOverAll(mat));
	}

}
