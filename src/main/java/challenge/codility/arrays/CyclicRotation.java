package challenge.codility.arrays;

import org.junit.Assert;
import org.junit.Test;

public class CyclicRotation {
	
	public int[] solution(int[] A, int K) {
		if (A.length == 1) return A;
		
		int[] copy = A.clone();
		
		for (int x = 0; x < A.length; x++) {
			if (x + K >= A.length) {
				copy[(x+K) % A.length] = A[x];
			} else {
				copy[x+K] = A[x];
			}
		}
		return copy;
    }
    
    @Test
    public void test() {
    	CyclicRotation cyclicRotation = new CyclicRotation();
    	
    	int[] A = {3, 8, 9, 7, 6};
    	int K = 3;
    	int[] solution = cyclicRotation.solution(A, K);
    	int[] resp1 = {9, 7, 6, 3, 8};
    	Assert.assertArrayEquals(solution,  resp1);
    	
    	A = new int[] {1, 1, 2, 3, 5};
    	K = 42;
    	solution = cyclicRotation.solution(A, K);
    	resp1 = new int[] {3, 5, 1, 1, 2};
    	Assert.assertArrayEquals(solution,  resp1);
    	
    }
}