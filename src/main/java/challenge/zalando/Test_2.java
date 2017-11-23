package challenge.zalando;

import org.junit.Test;

public class Test_2 {

	public int solution(int[] T) {

		int maxValue = Integer.MIN_VALUE;
		int index = -1;

		for (int i = 0; i < T.length; i++) {
			if (T[i] > maxValue) {
				maxValue = T[i];
				index = i;
			}
		}

		return index;

	}

	@Test
	public void test() {

		Test_2 test_2 = new Test_2();

//		int solution = test_2.solution(new int[] { 5, -2, 3, 4, 8, 6 });
//		int solution = test_2.solution(new int[] { 5, -2, 3, 8, 6 });
		int solution = test_2.solution(new int[] { -5, -5, -5, -42, 6, 12 });
		
		System.out.println(solution);

	}
}