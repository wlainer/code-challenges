package challenge.hackerearth.searching.linearsearch;


import java.io.IOException;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import challenge.TestBase;

public class MannaFirstName extends TestBase {

	public void solution() {

		Scanner s = getScanner();
		int times = s.nextInt();
		
		String[] words = new String[] { "SUVO", "SUVOJIT" };

		for (int i = 0; i < times; i++) {
			String value = s.next();
			int[] size = new int[words.length];
			int[] count = new int[words.length];

			for (char c : value.toCharArray()) {

				for (int j = 0; j < words.length; j++) {

					if (c == words[j].charAt(size[j]))
						size[j]++;

					if (words[j].length() == size[j]) {
						count[j]++;
						size[j] = 0;
					}

				}
				
			}

			System.out.println(String.format("SUVO = %d, SUVOJIT = %d", count[0] - count[1], count[1]));
		}
	}

	@Test
	public void test() throws IOException {
		solution();

		String[] lines = getLines();
		Assert.assertEquals("SUVO = 0, SUVOJIT = 1", lines[0]);
		Assert.assertEquals("SUVO = 1, SUVOJIT = 0", lines[1]);
		Assert.assertEquals("SUVO = 1, SUVOJIT = 1", lines[2]);
	}
}
