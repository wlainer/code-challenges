package codility.prefixsums;

import org.junit.Assert;
import org.junit.Test;

public class CountDivs {
	
	public int solution(int A, int B, int K) {
		if (A % K == 0)
			return B/K - A/K +1;

		return B/K - A/K;
	}
	
	@Test
	public void test() {
		int A = 6;
		int B = 11;
		int K = 2;
		
		Assert.assertEquals(solution(A, B, K), 3);
		
	}

}
