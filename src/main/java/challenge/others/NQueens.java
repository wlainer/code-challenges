package challenge.others;


import java.util.Scanner;

public class NQueens {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] queens = new int[n];

		for (int i = 0; i < n; i++) {
			queens[i] = scanner.nextInt();
		}

		int result = maxThreats(queens);

		System.out.println(result);

		scanner.close();
	}

	public static int maxThreats(int[] queens) {
		if (queens == null || queens.length <= 1) {
			return 0;
		}

		int n = queens.length;
		int max = 0;

		for (int row = 0; row < n; row++) {
			int curMaxThreats = 0;
			int col = queens[row] - 1;

			curMaxThreats = getNumThreats(row, col, queens);

			max = Math.max(max, curMaxThreats);
			if (max == 4) {
				return max;
			}
		}

		return max;
	}

	private static int getNumThreats(int row, int col, int[] queens) {
		int numThreats = 0;
		int n = queens.length;

		// up-left
		int i = row - 1;
		while (i >= 0 && (row - i != col - queens[i] + 1)) {
			i--;
		}

		if (i >= 0) {
			numThreats += 1;
		}

		// down-right
		i = row + 1;
		while (i < n && (i - row != queens[i] - 1 - col)) {
			i++;
		}

		if (i < n) {
			numThreats += 1;
		}

		// up-right
		i = row - 1;
		while (i >= 0 && (row - i != queens[i] - 1 - col)) {
			i--;
		}

		if (i >= 0) {
			numThreats += 1;
		}

		// Down-left
		i = row + 1;
		while (i < n && (i - row) != col - queens[i] + 1) {
			i++;
		}

		if (i < n) {
			numThreats += 1;
		}

		return numThreats;
	}
}