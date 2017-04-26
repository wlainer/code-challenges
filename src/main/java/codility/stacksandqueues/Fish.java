package codility.stacksandqueues;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class Fish {

	public int solution(int[] A, int[] B) {
		
		Stack<Integer> stack = new Stack();
		
		int duels = 0;
		for (int i = 0; i < A.length; i++) {
			if (B[i] == 1) {
				stack.push(A[i]);
				continue;
			}
			
			while (!stack.isEmpty()) {
				
				duels++;
				if (A[i] > stack.peek()) {
					stack.pop();
				} else {
					break;
				}
				
			}
		}
		
		return A.length - duels;
		
	}

	@Test
	public void test() {
		int[] A = new int[] { 4, 3, 2, 1, 5 };
		int[] B = new int[] { 0, 1, 0, 0, 0 };
		Assert.assertEquals(solution(A, B), 2);
		
		
		A = new int[] { 4, 3, 2, 1, 5 };
		B = new int[] { 0, 0, 0, 0, 0 };
		Assert.assertEquals(solution(A, B), 5);
		
		A = new int[] { 6, 3, 2, 1, 5 };
		B = new int[] { 1, 0, 0, 0, 0 };
		Assert.assertEquals(solution(A, B), 1);
		
		A = new int[] { 6, 3, 2, 6, 5 };
		B = new int[] { 0, 0, 0, 1, 0 };
		Assert.assertEquals(solution(A, B), 4);
		

	}

}
