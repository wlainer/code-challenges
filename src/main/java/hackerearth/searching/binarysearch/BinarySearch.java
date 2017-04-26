package hackerearth.searching.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();

		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = s.nextInt();

		Arrays.sort(A);

		int times = s.nextInt();
		for (int i = 0; i < times; i++) {
			int index = binarySearch(s.nextInt(), A, 0, A.length - 1);
			System.out.println(index == -1 ? -1 : index + 1);
		}

	}

	private static int binarySearch(int value, int[] A, int start, int end) {
		while (start <= end) {
			int mid = (int) Math.floor((start + end) / 2);

			if (A[mid] < value) {
				return binarySearch(value, A, mid + 1, end);
			} else if (A[mid] > value) {
				return binarySearch(value, A, start, mid - 1);
			} else {
				return mid;
			}
		}
		return -1;
	}
}
