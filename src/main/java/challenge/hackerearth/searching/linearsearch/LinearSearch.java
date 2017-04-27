package challenge.hackerearth.searching.linearsearch;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import challenge.TestBase;

public class LinearSearch extends TestBase {

	public void solution() {
		Scanner s = getScanner();
		int N = s.nextInt();
		int value = s.nextInt();

		int[] A = new int[N];
		int index = -1;
		for (int i = 0; i < N; i++)
			if (s.nextInt() == value)
				index = i + 1;

		System.out.println(index);
    }

	@Test
	public void test() {
		solution();

		String[] lines = getLines();
		Assert.assertEquals(5, Integer.parseInt(lines[0]));

	}

}