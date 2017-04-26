package codility.sorting;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class Triangle {

	public int solution(int[] A) {
		Arrays.sort(A);
		
		for (int i = 0; i < A.length - 2; i++) {
			if (A[i] + A[i+1] > A[i+2] &&
				A[i+1] + A[i+2] > A[i] &&
				A[i] + A[i+2] > A[i+1] ) {
					return 	1;
				}
		}
		
		return 0;
	}

	@Test
	public void test() {
		int[] A = new int[] { 10, 2, 5, 1, 8, 20 };
		Assert.assertEquals(solution(A), 1);

	}

}
