package challenge.codility.compositeandprimenumbers;

import org.junit.Assert;
import org.junit.Test;

public class CompositeAndPrimeNumbers {

	public int divisors(int n) {
		int i = 1;
		int result = 0;
		while (i * i < n) {
			if (n % i == 0)
				result += 2;

			i++;
		}

		if (i * i == n)
			result++;

		return result;
	}

	@Test
	public void test() {
		int n = 36;
		Assert.assertEquals(divisors(n), 9);
		

	}

}
