package challenge.hackerearth.searching.linearsearch;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import challenge.TestBase;

public class RestInPeace extends TestBase {

	public void solution() {

		Scanner s = getScanner();
		int times = s.nextInt();

		outer: for (int i = 0; i < times; i++) {

			int nextInt = s.nextInt();

			if (nextInt % 21 == 0) {
				System.out.println("The streak is broken!");
				continue;
			}

			int cont = 0;
			String value = String.valueOf(nextInt);
			inner: for (int j = 0; j < value.length() - 1; j++)
				if (value.charAt(j) == '2' && value.charAt(j + 1) == '1') {
					System.out.println("The streak is broken!");
					continue outer;
				}

			System.out.println("The streak lives still in our heart!");
		}
	}

	@Test
	public void test() {
		solution();

		String[] lines = getLines();
		Assert.assertEquals("The streak lives still in our heart!", lines[0]);
		Assert.assertEquals("The streak is broken!", lines[1]);
		Assert.assertEquals("The streak is broken!", lines[2]);
	}

}
