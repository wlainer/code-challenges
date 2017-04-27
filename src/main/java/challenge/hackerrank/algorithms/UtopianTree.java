package challenge.hackerrank.algorithms;

import java.util.Scanner;

public class UtopianTree {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();

			int totalHeight = calculateHeight(n);
			System.out.println(totalHeight);

		}
	}

	private static int calculateHeight(int n) {
		int height = 1;

		for (int x = 0; x < n; x++) {
			if (x % 2 == 0)
				height *= 2;
			else
				height += 1;
		}

		return height;
	}

}
