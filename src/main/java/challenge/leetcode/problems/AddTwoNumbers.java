package challenge.leetcode.problems;

import java.util.Scanner;

import org.junit.Test;

import challenge.TestBase;

public class AddTwoNumbers extends TestBase {
	public void solution() {
		Scanner s = getScanner();
		int N = s.nextInt();
		int size = s.nextInt();
		
		int[][] arr = new int[2][size];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < size; j++)	 {
				arr[i][j] = s.nextInt();
			}
		}
		
		int[] solution = new int[size];
		int ten = 0;
		for (int i = 0; i < size; i++) {
			int sum = arr[0][i] + arr[1][i] + ten;
			ten = Math.floorDiv(sum, 10);
			solution[i] = sum - (ten * 10);
		}
		
		for (int i : solution) {
			System.out.print(i);
		}
	}

	@Test
	public void test() {
		solution();
		checkLines();

	}

}
