package challenge.hackerrank.java.datastructures;

import java.util.Scanner;

public class Java1DArrayPart1 {

	public static void main(String[] args) {

		Scanner cin = new Scanner(Java1DArrayPart1.class.getResourceAsStream("/java/dataestructures/java_1d_array_part1/input00.txt"));
		int N = cin.nextInt();
		int[] a = new int[N + 1];
		for (int i = 1; i <= N; i++)
			a[i] = cin.nextInt() + a[i - 1];
		int r = 0;
		for (int i = 0; i < N; i++)
			for (int j = i + 1; j <= N; j++)
				if (a[j] - a[i] < 0)
					r++;
		System.out.println(r);
	}

}
