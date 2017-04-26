package codility.misc;

import org.junit.Assert;
import org.junit.Test;

public class Robot {

	@Test
	public void test() {
		String path = "GLGLGLG";
		Assert.assertEquals(solution(path), true);

	}

	private boolean solution(String path) {
		int N = 0, E = 1, S = 2, W = 3;
		
		int x = 0;
		int y = 0;
		int dir = N;
		for (char c: path.toCharArray()) {
			if (c == 'R')
				dir = (dir + 1) % 4;
			else if (c == 'L')
				dir = (4 + dir - 1) % 4;
			else {
				if (dir == N) y++;
				else if (dir == E) x++;
				else if (dir == S) y--;
				else x--;
			}
		}
		
		return (x == 0 && y == 0);
	}

}
