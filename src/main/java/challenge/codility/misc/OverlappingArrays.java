package challenge.codility.misc;

import org.junit.Assert;
import org.junit.Test;

public class OverlappingArrays {

	public int[][] solution(int[][] A) {
		
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i][1] > A[i+1][0]) {
				A[i][1] = A[i+1][1];
				A = removeItem(A, i+1);
				i--;
			}
				
		}
		
		return A;
	}
	
	private int[][] removeItem(int[][] arr, int index) {
		int[][] A = new int[arr.length-1][];
		System.arraycopy(arr, 0, A, 0, index);
		System.arraycopy(arr, index+1, A, index, arr.length-index-1);
		return A;
	}
	
	@Test
	public void test() {
		int[][] A = new int[][]{{0,1}, {2,5}, {4,7}, {8,9}};
		Assert.assertArrayEquals(solution(A), new int[][] {{0,1}, {2,7}, {8,9}});
		
		A = new int[][]{{0,1}, {2,5}, {4,7}, {6, 9}, {10,11}};
		Assert.assertArrayEquals(solution(A), new int[][] {{0,1}, {2,9}, {10,11}});
	}
}
