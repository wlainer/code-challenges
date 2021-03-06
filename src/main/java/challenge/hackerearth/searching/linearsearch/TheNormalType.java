package challenge.hackerearth.searching.linearsearch;


import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import challenge.TestBase;

public class TheNormalType extends TestBase {

	public void solution() {

		Scanner s = getScanner();
		int N = s.nextInt();
		int[] A = new int[N];

		for (int i = 0; i < N; i++)
			A[i] = s.nextInt();

		Map<Integer, int[]> distinctElements = numberDistinctElements(A, 0, A.length);
		for (int i = 0; i < A.length; i++) {
			distinctElements.get(A[i])[i + 1]++;
		}

		for (int i = 0; i < N; i++) {
			Set<Integer> keySet = distinctElements.keySet();
			for (Integer integer : keySet)
				distinctElements.get(integer)[i + 1] += distinctElements.get(integer)[i];
		}


		int count = 0;
		for (int i = 0; i < A.length + 1; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (j - i >= distinctElements.size()) {
				long innerCount = 0;
					Set<Integer> keySet = distinctElements.keySet();
					for (Integer integer : keySet)
						if (distinctElements.get(integer)[j+1] - distinctElements.get(integer)[i] > 0)
							innerCount++;

					if (innerCount == distinctElements.size())
						count++;
				}
			}

		}

		System.out.println(count);
	}

	private Map<Integer, int[]> numberDistinctElements(int[] A, int start, int end) {
		Set<Integer> distinct = new HashSet();
		for (int i = start; i < end; i++)
			distinct.add(A[i]);

		int size = distinct.size();

		Map<Integer, int[]> toReturn = new HashMap();
		for (Integer integer : distinct) {
			toReturn.put(integer, new int[A.length + 1]);
		}

		return toReturn;
	}
	
	
//	public void solution() {
//
//		Scanner s = getScanner();
//		int N = s.nextInt();
//		int[] A = new int[N];
//
//		for (int i = 0; i < N; i++)
//			A[i] = s.nextInt();
//
//		Map<Long, Long> distinctElements = numberDistinctElements(A, 0, A.length);
//		
//		long m = distinctElements.size();
//		
//		long res = 0, count = 0,a = 0, b = 0;
//		
//		for (a = 0; a < N; a++) {
//			if (a == 0){
//				b = -1;
//			} else {
//				long num = A[(int) (a-1)];
//				distinctElements.put(num, distinctElements.get(num) - 1);
//				if (distinctElements.get(num) <= 0) {
//					count--;
//				}
//			}
//			while (count < m && b + 1 < N) {
//				b++;
//				long num = A[(int) b];
//				if (distinctElements.get(num) <= 0) {
//					count++;
//				}
//				distinctElements.put(num, distinctElements.get(num) + 1);
//			}
//			if (count < m) {
//				break;
//			}
//			res += (N-b);
//		}
//		
//		System.out.println(res);
//	}
//
//	private Map<Long, Long> numberDistinctElements(int[] A, int start, int end) {
//		Set<Integer> distinct = new HashSet();
//		for (int i = start; i < end; i++)
//			distinct.add(A[i]);
//
//		int size = distinct.size();
//
//		Map<Long, Long> toReturn = new HashMap();
//		for (Integer integer : distinct) {
//			toReturn.put(Long.valueOf(integer), 0L);
//		}
//
//		return toReturn;
//	}
	

	@Test
	public void test() throws IOException {
		solution();

		String[] lines = getLines();
		Assert.assertEquals(8, Long.parseLong(lines[0]));
	}
}
