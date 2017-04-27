package challenge.codility.misc;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class Intersection {

	public int solution(int[] A, int[] B) {
		
		Set<Integer> arrA = new HashSet();
		
		int sum = 0;
		
		for (int i = 0; i < A.length; i++) 
			arrA.add(A[i]);
			
		for (int i = 0; i < B.length; i++) 
			if (arrA.contains(B[i])) sum += B[i];
				
		return sum;
	}

	@Test
	public void test() {
		int[] A = {5,9,7,6,1};
		int[] B = {4,9,3,8,1};
		
		Assert.assertEquals(solution(A, B), 10);
		
		A = new int[] {3,6,2,5,67,3,5,6,7};
		B = new int[] {8,5,7,8,4,67,9,5};		
		Assert.assertEquals(solution(A, B), 84);

	}

}
