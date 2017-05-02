package challenge.hackerearth.arrays.onedimension;

import java.util.Scanner;

import org.junit.Test;

import challenge.TestBase;

public class MarkTheAnswer extends TestBase {

	public void solution() {
		Scanner s = getScanner();

		int N = s.nextInt();
		int maximumDifficulty = s.nextInt();
		
		int canSkip = 1;
		int count = 0;
		for (; N > 0; N--) {
			int question = s.nextInt();
			if (question <= maximumDifficulty) {
				count++;
			} else if (canSkip > 0 && question > maximumDifficulty) {
				canSkip--;
				continue;
			} else {
				break;
			}
		}

		System.out.println(count);

	}
	
	@Test
	public void test() {
		solution();
		
		checkLines();

	}
}
