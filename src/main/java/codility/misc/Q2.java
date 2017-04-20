package codility.misc;

import org.junit.Assert;
import org.junit.Test;

public class Q2 {

	public int[][] solution(int[][] A) {
		
		int firstMin = Integer.MAX_VALUE;
		int secondMax = Integer.MIN_VALUE;
		for (int i = 1; i < A.length -1; i++) {
			if (A[i][0] < firstMin) firstMin = A[i][0];  
			if (A[i][1] > secondMax) secondMax = A[i][1];  
		}
		
		int[][] res = new int[][] {
				A[0], 
				{firstMin, secondMax}, 
				A[A.length -1]}; 
		
		return res;
	}

	@Test
	public void test() {
		int[][] A = new int[][] {
			{0,1},
			{2,5},
			{4,7},
			{1,6},
			{8,9}
		};

		Assert.assertArrayEquals(solution(A), new int[][] {{0,1}, {1,7}, {8,9}});
	}

}
