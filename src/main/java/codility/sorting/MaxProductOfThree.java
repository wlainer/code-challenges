package codility.sorting;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MaxProductOfThree {

	public int solution(int[] A) {
		Arrays.sort(A);
		
		int max1 = A[A.length-3] * A[A.length-2] * A[A.length-1];
		int max2 = A[0] * A[1] * A[A.length-1];
		
		return Math.max(max1, max2);
	}

	@Test
	public void test() {
		int[] A = new int[] { -3, 1, 2, -2, 5, 6 };
		Assert.assertEquals(solution(A), 60);
		
	}

}
