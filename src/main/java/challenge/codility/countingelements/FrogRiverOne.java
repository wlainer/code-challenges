package challenge.codility.countingelements;

import org.junit.Assert;
import org.junit.Test;

public class FrogRiverOne {

	public static int solution(int[] A, int X) {
		int tmp = 0;
		boolean[] hasLeaf = new boolean[X+1];
		for (int i = 0; i < A.length; i++) {
			if (!hasLeaf[A[i]] && A[i]<=X) {
				hasLeaf[A[i]] = true;
				tmp++;
			}
			if (tmp ==X)
				return i;
		}
		return -1;
}

	@Test
	public void test() {

		int[] A = new int[]{1,3,1,4,2,3,5,4};
		int X = 5;
		Assert.assertEquals(solution(A, X), 6);
		

	}

}
