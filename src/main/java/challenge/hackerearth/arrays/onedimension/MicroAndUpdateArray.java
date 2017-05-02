package challenge.hackerearth.arrays.onedimension;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import challenge.TestBase;

public class MicroAndUpdateArray extends TestBase {

	public void solution() {
		Scanner s = getScanner();
		int N = s.nextInt();
		
		for (; N > 0; N--) {
			int size = s.nextInt();
			int minValue = s.nextInt();
			
			int[] A = new int[size];
			for (int i = 0; i < size; i++)
				A[i] = s.nextInt();

			Arrays.sort(A);
			
			if (A[0] > minValue) System.out.println("0");
			else System.out.println(minValue - A[0]);
		}
			
	}
	
	@Test
	public void test() {
		solution();
		
		String[] lines = getLines();
		Assert.assertEquals("3", lines[0]);
		Assert.assertEquals("0", lines[1]);
	}
}
