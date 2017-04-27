package challenge.codility.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
	
	public Integer[] solution3(int[] A, int[] B) {

		Set<Integer> hashB = new HashSet();
		for (int i = 0; i < B.length; i++) {
			hashB.add(B[i]);
		}
		
		List<Integer> priorityItems = new ArrayList();
		List<Integer> otherItems = new ArrayList();
		
		for (int i = 0; i < A.length; i++) {
			if (hashB.contains(A[i])) priorityItems.add(A[i]);
			else otherItems.add(A[i]);
		}
		
		Collections.sort(priorityItems);
		Collections.sort(otherItems);
		
		priorityItems.addAll(otherItems);
		
		Integer[] res = new Integer[priorityItems.size()];
		res = priorityItems.toArray(res);

		return res; 
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
		
//		int sizeA = 100000;
//		int sizeB = 50000;
//		
//		Random r = new Random();
//		int[] A = new int[sizeA];
//		for (int i = 0; i < A.length; i++) {
//			A[i] = r.nextInt(sizeA);
//		}
//		
//		int[] B = new int[sizeB];
//		for (int i = 0; i < B.length; i++) {
//			B[i] = r.nextInt(sizeB);
//		}

		long begin = System.currentTimeMillis();
//		int[] solution = solution(A, B);
		Assert.assertArrayEquals(solution(A, B), new int[] { 3, 6, 7, 1, 4, 5,8 });
		long end = System.currentTimeMillis();
		System.out.println("first: " + (end - begin));
		
		begin = System.currentTimeMillis();
//		int[] solution2 = solution2(A, B);
		Assert.assertArrayEquals(solution2(A, B), new int[] { 3, 6, 7, 1, 4, 5,8 });
		end = System.currentTimeMillis();
		System.out.println("second: " + (end - begin));
		
		begin = System.currentTimeMillis();
//		Integer[] solution3 = solution3(A, B);
		Assert.assertArrayEquals(solution3(A, B), new Integer[] { 3, 6, 7, 1, 4, 5,8 });
		end = System.currentTimeMillis();
		System.out.println("third: " + (end - begin));
		
//		Assert.assertArrayEquals(solution, solution2);
//		Assert.assertArrayEquals(solution2, solution3);
		
	}

}
