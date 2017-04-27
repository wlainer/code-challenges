package challenge.codility.sorting;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class Distinct {

	public int solution(int[] A) {
		Arrays.sort(A);
		
		int distinct = 0;
		for (int i = 1; i < A.length-1; i++) 
			if (A[i] == A[i-1]) distinct++;

		return A.length - distinct;
		
	}

	@Test
	public void test() {
		int[] A = new int[] { 2, 1, 1, 2, 3, 1 };
		Assert.assertEquals(solution(A), 3);
		
		A = new int[] {1,1,1,1,1,1};
		Assert.assertEquals(solution(A), 1);
		
		A = new int[] {};
		Assert.assertEquals(solution(A), 0);

	}

}
