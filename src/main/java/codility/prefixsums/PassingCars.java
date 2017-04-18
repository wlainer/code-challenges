package codility.prefixsums;

import org.junit.Assert;
import org.junit.Test;

public class PassingCars {
	
	public int solution(int[] A) {
		int zeroes = 0;
		int res = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) zeroes++;
			else { 
				res += zeroes;
				if (res > 1000000000) return -1;
			}
		}
		
		return res;
	}
	
	@Test
	public void test() {
		int[] A = new int[] { 0, 1, 0, 1, 1 };
		Assert.assertEquals(solution(A), 5);
		
		A = new int[] {0, 1};
		Assert.assertEquals(solution(A), 1);
		
		A = new int[] {1, 0};
		Assert.assertEquals(solution(A), 0);
	}

}
