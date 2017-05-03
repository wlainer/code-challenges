package challenge.hackerearth.graph.graphrepresentation;

import java.util.Scanner;

import org.junit.Test;

import challenge.TestBase;

public class MonkAtTheGraphFactory extends TestBase {

	public void solution() {
		Scanner s = getScanner();

		int N = s.nextInt();
		int sum = 0;
		for (int i = 0; i < N; i++)
			sum += s.nextInt();
		
		if (sum / 2 == N - 1)
			System.out.println("Yes");
		else
			System.out.println("No");
			
	}
	
	@Test
	public void test() {
		solution();
		checkLines();
	}
}
