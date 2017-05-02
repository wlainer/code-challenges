package challenge.hackerearth.arrays.multidimensional;

import java.util.Scanner;

import org.junit.Test;

import challenge.TestBase;

public class AddAlternateElementsOf2DimensionalArrays extends TestBase {

	public void solution() {
		Scanner s = getScanner();
		
		int N = 9;
		int[] A = new int[2];
		for (; N > 0; N--)
			A[N % 2] += s.nextInt();

		System.out.println(A[1]);
		System.out.println(A[0]);

	}
	
	
	@Test
	public void test() {
		solution();

		checkLines();
		
	}
}
