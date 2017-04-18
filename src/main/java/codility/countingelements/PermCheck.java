package codility.countingelements;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class PermCheck {

	public int solution(int[] A) {
		if (A.length == 1) return 1;
		
		Arrays.sort(A);
		
		for (int i = 0; i < A.length; i++) 
			if(A[i] != i+1) return 0;
			
		return 1;
    }

	@Test
	public void test() {

		int[] A = { 4,1,3,2 };
		Assert.assertEquals(solution(A), 1);
		
		A = new int[]{ 2 };
		Assert.assertEquals(solution(A), 1);
		
		A = new int[]{ 4, 1, 3 };
		Assert.assertEquals(solution(A), 0);

	}

}
