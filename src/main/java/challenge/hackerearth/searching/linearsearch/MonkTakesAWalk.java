package challenge.hackerearth.searching.linearsearch;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import challenge.TestBase;

public class MonkTakesAWalk extends TestBase {

	public void solution() {
		Scanner s = getScanner();
		int times = s.nextInt();

		for (int i = 0; i < times; i++) {
			String value = s.next();
			int count = 0;

			for (int j = 0; j < value.length(); j++)
				if (value.charAt(j) == 'a' || value.charAt(j) == 'A' || 
					value.charAt(j) == 'e' || value.charAt(j) == 'E' || 
					value.charAt(j) == 'i' || value.charAt(j) == 'I' || 
					value.charAt(j) == 'o' || value.charAt(j) == 'O' || 
					value.charAt(j) == 'u' || value.charAt(j) == 'U')
					count++;

			System.out.println(count);
		}
	}

	@Test
	public void test() {
		solution();
		
		String[] lines = getLines();
		Assert.assertEquals(1296, Integer.parseInt(lines[0]));
		Assert.assertEquals(1398, Integer.parseInt(lines[1]));
		Assert.assertEquals(968, Integer.parseInt(lines[2]));
		Assert.assertEquals(394, Integer.parseInt(lines[3]));
		Assert.assertEquals(234, Integer.parseInt(lines[4]));
	}
}
