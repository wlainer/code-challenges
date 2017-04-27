package challenge.hackerearth.searching.linearsearch;


import java.io.IOException;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import challenge.TestBase;

public class SquareTransaction extends TestBase {

	public void solution() {

		Scanner s = getScanner();
		int N = s.nextInt();
		int[] A = new int[N + 1];

		for (int i = 1; i < N + 1; i++)
			A[i] = A[i - 1] + s.nextInt();


		int times = s.nextInt();
		for (int i = 0; i < times; i++) {
			int limit = s.nextInt();

			for (int j = 0; j < A.length; j++) {
				if (limit > A[A.length - 1]) {
					System.out.println("-1");
					break;
				}

				if (A[j] >= limit) {
					System.out.println(j);
					break;
				}
			}
		}
			
		
	}

	@Test
	public void test() throws IOException {
		solution();

		String[] lines = getLines();
		Assert.assertEquals(3, Integer.parseInt(lines[0]));
		Assert.assertEquals(2, Integer.parseInt(lines[1]));
		Assert.assertEquals(5, Integer.parseInt(lines[2]));
		Assert.assertEquals(-1, Integer.parseInt(lines[3]));
	}
}
