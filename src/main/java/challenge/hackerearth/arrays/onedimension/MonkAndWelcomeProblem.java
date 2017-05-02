package challenge.hackerearth.arrays.onedimension;

import java.util.Scanner;

import org.junit.Test;

import challenge.TestBase;

public class MonkAndWelcomeProblem extends TestBase {

	public void solution() {
		Scanner s = getScanner();

		int N = s.nextInt();
		int A[] = new int[N];

		for (int i = 0; i < N * 2; i++)
			A[i % N] += s.nextInt();

		System.out.println(intArrayToString(A));
			
	}
	
	@Test
	public void test() {
		solution();
		
		checkLines();

		// String[] lines = getLines();
		// Assert.assertEquals("5 7 6 6 15", lines[0]);
	}
}
