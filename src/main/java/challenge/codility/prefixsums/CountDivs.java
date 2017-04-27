package challenge.codility.prefixsums;

import org.junit.Assert;
import org.junit.Test;

public class CountDivs {
	
	public int solution(int[] A) {
		
		int max = Integer.MIN_VALUE;
		int[] triplet = new int[3];
		int count = 0;
		for (int i = 0; i < A.length - 2; i++) {
			triplet[count++] = A[i];
			for (int j = i + 1; j < A.length; j++) {
				if (A[j]>= triplet[count -1]) triplet[count++] = A[j];
				
				if (count == 3) break;
			}
			
			if (count == 3 && triplet[0]*triplet[1]*triplet[2] > max) max = triplet[0]*triplet[1]*triplet[2];
			count = 0;
		}
		
		return max;
	}
	
	@Test
	public void test() {
		int[] A = new int[] {-3, 1, 2, -2, 5, 6};
		Assert.assertEquals(solution(A), 60);
		
		A = new int[] {10,10,10};
		Assert.assertEquals(solution(A), 1000);
		
		A = new int[] {4, 5, 1, 0};
		Assert.assertEquals(solution(A), 20);
		
	}

}
