package challenge.codility.maximumsliceproblem;

import org.junit.Assert;
import org.junit.Test;

public class MaximumSliceProblem {

	public int solution(int[] A) {
		int maxEnding = 0, maxSlice = 0;
		for (int i : A) {
			maxEnding = Math.max(0, maxEnding + i);
			maxSlice = Math.max(maxSlice, maxEnding);
		}
		return maxSlice;
	}
	
	public int solution2(int[] A) { 
		int begin = 0, end = 0, s = 0;
		int maxEnding = 0, maxSlice = 0;
		for (int i = 0; i < A.length; i++) {
			if (maxEnding + A[i] > 0 ) {
				maxEnding = maxEnding + A[i];
			} else {
				maxEnding = 0;
				s = i + 1;
			}	
			
			if (maxSlice < maxEnding) {
				maxSlice = maxEnding;
				begin = s;
				end = i;
			}
		}
		
		System.out.println("start index " + begin + " end " + end);
		
		return maxSlice;
	}

	@Test
	public void test() {
		int[] A = new int[] { 5, -7, 3, 5, -2, 4, -1 };
		Assert.assertEquals(solution2(A), 10);

		A = new int[] { -2, -3, 4, -1, -2, 1, 5, -3 };
		Assert.assertEquals(solution2(A), 7);
	}

}
