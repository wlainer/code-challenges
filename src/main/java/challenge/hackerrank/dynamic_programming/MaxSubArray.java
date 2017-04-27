package challenge.hackerrank.dynamic_programming;

import java.util.Scanner;
import java.util.StringTokenizer;

public class MaxSubArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(MaxSubArray.class.getResourceAsStream("/dynamic_programming/input03.txt"));
		int times = Integer.parseInt(in.nextLine());

		for (int x = 0; x < times; x++) {
			int quantity = Integer.parseInt(in.nextLine());

			StringTokenizer tokenizer = new StringTokenizer(in.nextLine());
			int[] arr = new int[quantity];
			int count = 0;
			while (tokenizer.hasMoreElements()) {
				String token = (String) tokenizer.nextElement();
				arr[count] = Integer.parseInt(token);
				count++;
			}

			findMaxSumSubArray(arr);

			int result = maxSubArray(arr);
			System.out.print(result + " ");

			result = maxContinuousArray(arr);
			System.out.println(result);
		}
	}

	private static void findMaxSumSubArray(int[] arr) {
		long maxConSum = Long.MIN_VALUE, maxNonConSum = Long.MIN_VALUE, prevSum = 0;
		for (int x : arr) {
			int currentSum = x;
			if (prevSum > 0) {
				currentSum += prevSum;
			}
			if (currentSum > maxConSum) {
				maxConSum = currentSum;
			}
			prevSum = currentSum;
			if (maxNonConSum < 0 && x > maxNonConSum) {
				maxNonConSum = x;
			} else if (maxNonConSum > 0 && x > 0) {
				maxNonConSum += x;
			}
		}
		System.out.println(maxConSum + " " + maxNonConSum);
	}

	private static int maxSubArray(int[] A) {
		int max = A[0];
		int[] sum = new int[A.length];
		sum[0] = A[0];

		for (int i = 1; i < A.length; i++) {
			sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
			max = Math.max(max, sum[i]);
		}

		return max;
	}

	private static int maxContinuousArray(int[] A) {
		int sum = 0;
		int maximum = Integer.MIN_VALUE;

		boolean negArray = true;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				sum += A[i];
				negArray = false;
			}
			if (A[i] > maximum && A[i] < 0)
				maximum = Math.max(maximum, A[i]);
		}

		return negArray ? maximum : sum;
	}
}
