package hackerearth.searching.linearsearch;

import java.util.Scanner;

import codility.TestBase;

public class RestInPeace extends TestBase {

	public static void main(String[] args) {

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
}
