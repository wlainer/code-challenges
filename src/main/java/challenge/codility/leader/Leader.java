package challenge.codility.leader;

import org.junit.Assert;
import org.junit.Test;

public class Leader {

	public int solution(int[] A) {
		int leader = -1;
		
		for (int i = 0; i < A.length; i++) {
			int candidate = A[i];
			int count = 0;
			for (int j = 0; j < A.length; j++) {
				if (A[j] == candidate) count++;
				
				if (count > A.length / 2) leader = candidate;
			}
		}

		return leader;
	}
	
	public int solution2(int[] A) {
		int leader = -1;
		int candidate = A[A.length / 2];
		
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == candidate) count++;
			
			if (count > A.length /2) leader = candidate;
		}
		
		return leader;
	}
	
	public int solution3(int[] A) {
		int stack = 0;
		int size = 0;
		for (int i = 0; i < A.length; i++) {
			if (size == 0) {
				stack = A[i];
				size++;
			} else {
				if (A[i] == stack) size++;
				else size--;
			}
		}
		
		int candidate = -1;
		if (size > 0) candidate = stack;
		
		int leader = -1;
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == candidate) count++;
			
			if (count > A.length /2) leader = candidate;
		}
		
		return leader;
		
	}
	
	@Test
	public void test() {
		int[] A = new int[] { 6,8,4,6,8,6,6 };
		Assert.assertEquals(solution(A), 6);
		
		A = new int[] { 6,8,4,6,8,6,6 };		
		Assert.assertEquals(solution2(A), 6);
		
		A = new int[] { 6,8,4,6,8,6,6 };
		Assert.assertEquals(solution3(A), 6);
	}

}










