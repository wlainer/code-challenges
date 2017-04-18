package codility.countingelements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class MissingInteger {

	public int solution(int[] A) {

		Arrays.sort(A);
		
		Map<Integer, Boolean> values = new HashMap();
		for (int i = 0; i < A.length; i++) 
			values.put(A[i], true);
			
		for (int i = 1; i < A.length + 1; i++) 
			if (values.get(i) == null ) return i;
		
		return A.length + 1;
	}

	@Test
	public void test() {
		int[] A = { 1, 3, 6, 4, 1, 2 };
		Assert.assertEquals(solution(A), 5);

		A = new int[] {2};
		Assert.assertEquals(solution(A), 1);
		
		A = new int[] {1,2,3,4,5};
		Assert.assertEquals(solution(A), 6);
	}

}
