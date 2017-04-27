package challenge.codility.prefixsums;

import org.junit.Assert;
import org.junit.Test;

public class MinAvgTwoSlice {
	
	public int solution(int[] A) {

		int minTwoEl = Integer.MAX_VALUE;
		int posMinTwoEl = 0;
		
		int minThreeEl = Integer.MAX_VALUE;
		int posMinThreeEL = 0;
		
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] + A[i+1] < minTwoEl) {
				minTwoEl = A[i] + A[i+1];
				posMinTwoEl = i;
			}
			
			if (i < A.length - 2 && A[i] + A[i+1] + A[i+2] < minThreeEl) {
				minThreeEl = A[i] + A[i+1] + A[i+2] ;
				posMinThreeEL = i;
			}
		}
		
		if (minThreeEl < minTwoEl) return posMinThreeEL;
		else return posMinTwoEl;
	}
	
	@Test
	public void test() {
		int[] A = new int[] {4, 2, 2, 5, 1, 5, 8};
		
		Assert.assertEquals(solution(A), 1);
				
	}

}
