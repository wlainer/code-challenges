package challenge.hackerrank.java.datastructures;

import java.util.Scanner;

public class Java2DArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(Java2DArray.class.getResourceAsStream("/java/dataestructures/java_2d_array/input03.txt"));
		int arr[][] = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				arr[i][j] = in.nextInt();
			}
		}

		System.out.println(showHourglass(arr));
	}

	private static int showHourglass(int[][] arr) {
		int sum = Integer.MIN_VALUE;
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				sum = Math.max(sum, arr[row][col] + 
									arr[row][col + 1] + 
									arr[row][col + 2] + 
						            arr[row + 1][col + 1] + 
						            arr[row + 2][col] + 
						            arr[row + 2][col + 1] + 
						            arr[row + 2][col + 2]);
			}
		}
		return sum;
	}
}
