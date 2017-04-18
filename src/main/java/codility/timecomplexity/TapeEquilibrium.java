package codility.timecomplexity;

import org.junit.Assert;
import org.junit.Test;

public class TapeEquilibrium {

	public int solution(int[] A) {

		int min = Integer.MAX_VALUE;
		int sumA = 0;
		int sumB = 0;
		for (int i = 0; i < A.length; i++)
			sumB += A[i];

		for (int i = 0; i < A.length -1; i++) {
			sumA += A[i];
			sumB -= A[i];

			min = Math.min(min, Math.abs(sumA - sumB));
		}

		return min;
	}

	@Test
	public void test() {

		int[] A = { 3, 1, 2, 4, 3 };
		Assert.assertEquals(solution(A), 1);

		A = new int[] {5, 6, 2, 4, 1};
		Assert.assertEquals(solution(A), 4);
		
		A = new int[] {-1000, 1000};
		Assert.assertEquals(solution(A), 2000);
		
		
	}

}
