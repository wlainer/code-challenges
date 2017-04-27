package challenge.others;


public class CollectCoins {
	
	final static int R = 5;
	final static int C = 5;

	static char[][] arr = {
			{'E', 'C', 'C', 'C', 'C'},
			{'C', '#', 'C', '#', 'E'},
			{'#', 'C', 'C', '#', 'C'},
			{'C', 'E', 'E', 'C', 'E'},
			{'C', 'E', '#', 'C', 'E'}
	};

	static boolean isValid(int i, int j) {
		return i >= 0 && i < R && j >= 0 && j < C;
	}

	static int maxCoinsRec(char[][] arr, int i, int j, int dir) {
		if (isValid(i, j) == false || arr[i][j] == '#')
			return 0;

		int result = arr[i][j] == 'C' ? 1 : 0;

		if (dir == 1)
			return result + Math.max(maxCoinsRec(arr, i + 1, j, 0)
					, maxCoinsRec(arr, i, j + 1, 1));

		return result + Math.max(maxCoinsRec(arr, i + 1, j, 1)
				, maxCoinsRec(arr, i, j - 1, 0));

	}
	
	public static void main(String[] args) {
		System.out.println("Maximum number of collected coins is " + maxCoinsRec(arr, 0, 0, 1));
	}

}
