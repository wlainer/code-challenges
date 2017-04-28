package challenge.hackerearth.searching.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import challenge.TestBase;

public class BishuAndSoldiers extends TestBase {

	public void solution() {
		Scanner s = getScanner();

		int N = s.nextInt();
		int[] A = new int[N];

		for (int i = 0; i < N; i++)
			A[i] = s.nextInt();

		Arrays.sort(A);

		int[] sumA = new int[N + 1];
		for (int i = 1; i < sumA.length; i++)
			sumA[i] = sumA[i - 1] + A[i - 1];

		int times = s.nextInt();
		for (int i = 0; i < times; i++) {
			int value = s.nextInt();
			if (value > A[A.length - 1]) {
				System.out.println(A[A.length - 1] + " " + sumA[sumA.length - 1]);
				continue;
			}

			int index = getLastOccurrence(A, value) + 1;
			int sum = sumA[index];
			System.out.println(index + " " + sum);
		}
	}
	
	public int getLastOccurrence(int[] arr, int data) {
		int low = 0;
		int high = arr.length - 1;

		int index = binarySearchLastOccurrence(arr, low, high, data);

		return index;
	}

	public int binarySearchLastOccurrence(int arr[], int low, int high, int data) {
		int mid;

		// A simple implementation of Binary Search
		if (high >= low) {
			mid = high + low / 2; // To avoid overflow
			if ((mid == high && arr[mid] == data) || (arr[mid] == data && arr[mid + 1] > data))
				return mid;

			// We need to give preference to right part of the array
			// since we are concerned with the last occurrence
			else if (arr[mid] <= data)
				return binarySearchLastOccurrence(arr, mid + 1, high, data);
			else
				// We need to search in the left half
				return binarySearchLastOccurrence(arr, low, mid - 1, data);
		}

		return -1;
	}

	@Test
	public void test() {
		solution();
		
		String[] lines = getLines();
		Assert.assertEquals("3 6", lines[0]);
		Assert.assertEquals("7 28", lines[1]);
		Assert.assertEquals("2 3", lines[2]);
	}
}
