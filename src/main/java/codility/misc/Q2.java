package codility.misc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class Q2 {

	public int[][] solution(int[][] A) {
		
		Arrays.sort(A, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		Stack stack = new Stack<>();
		stack.push(A[0]);
		for (int i = 1; i < A.length; i++) {
			int[] top = (int[]) stack.peek();
			if (top[1] < A[i][0]) {
				stack.push(A[i]);
			} else {
				if (top[1] < A[i][1]) {
					top[1] = A[i][1];
					stack.pop();
					stack.push(top);
				}
			}
		}
		
		int[][] res = new int[stack.size()][];
		for (int i = stack.size() -1 ; i >= 0 ; i--) {
			res[i] = (int[]) stack.pop();
		}
		return res;
	}

	@Test
	public void test() {
		int[][] A = new int[][] {
			{0,1},
			{2,5},
			{4,7},
			{1,6},
			{8,9}
		};

		Assert.assertArrayEquals(solution(A), new int[][] {{0,7}, {8,9}});
		
		A = new int[][]{ {6,8}, {1,9}, {2,4}, {4,7} };
		Assert.assertArrayEquals(solution(A), new int[][] {{1,9}});
	}

}
