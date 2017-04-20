package codility.misc;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class Q1 {

	// public Integer[] solution(int[] A, int[] B) {
	// Arrays.sort(A);
	// Arrays.sort(B);
	//
	// Set<Integer> list = new LinkedHashSet();
	// for (int i = 0; i < B.length; i++)
	// list.add(B[i]);
	//
	// for (int i = 0; i < A.length; i++)
	// list.add(A[i]);
	//
	// Integer[] res = new Integer[A.length];
	// res = list.toArray(res);
	//
	// return res;
	// }

	public int[] solution(int[] A, int[] B) {

		Arrays.sort(A);
		Arrays.sort(B);

		int[] intersection = new int[0];
		int count = 0;
		for (int i = 0; i < B.length; i++)
			for (int j = 0; j < A.length; j++)
				if (B[i] == A[j]) {
					intersection = Arrays.copyOf(intersection, count + 1);
					intersection[count++] = B[i];
					A = removeIndex(A, j);

				}

		return concat(intersection, A);
	}

	public int[] solution2(int[] A, int[] B) {

		Arrays.sort(A);
		Arrays.sort(B);

		int[] intersection = new int[0];
		int count = 0;
		for (int i = 0; i < B.length; i++) {
			int j = Arrays.binarySearch(A, B[i]);
			if (j > 0) {
				intersection = Arrays.copyOf(intersection, count + 1);
				intersection[count++] = B[i];
				A = removeIndex(A, j);
				
			}
		}
		return concat(intersection, A);
	}

	private int[] removeIndex(int[] arr, int index) {
		int[] A = new int[arr.length - 1];
		System.arraycopy(arr, 0, A, 0, index);
		System.arraycopy(arr, index + 1, A, index, arr.length - index - 1);
		return A;
	}

	private int[] concat(int[] first, int[] second) {
		int[] ret = Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, ret, first.length, second.length);
		return ret;
	}

	@Test
	public void test() {
		int[] A = new int[] { 5, 7, 1, 4, 3, 8, 6 };
		int[] B = new int[] { 6, 7, 3, 9, 2 };

		long begin = System.currentTimeMillis();
		Assert.assertArrayEquals(solution(A, B), new int[] { 3, 6, 7, 1, 4, 5,8 });
		long end = System.currentTimeMillis();
		System.out.println("first: " + (end - begin));
		
		begin = System.currentTimeMillis();
		Assert.assertArrayEquals(solution2(A, B), new int[] { 3, 6, 7, 1, 4, 5,8 });
		end = System.currentTimeMillis();
		System.out.println("second: " + (end - begin));
	}

}
