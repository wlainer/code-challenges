package challenge.picnic.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ScreeningTest {
	public static void main(String[] args) {
		List<Integer> data1 = Arrays.asList(1, 4, 7);
		List<Integer> data2 = Arrays.asList(123, -2, 477, 3, 14, 6551);

		ScreeningTest obj = new ScreeningTest();

		int result = obj.fold(data1);
		System.out.println(result);

		int yourAnswer = obj.fold(data2); // what is the answer for this one???
		System.out.println(yourAnswer);
	}

	private int fold(List<Integer> input) {
		List<Integer> auxInput = null;
		for (; input.size() > 2;) {
			auxInput = new ArrayList();
			int size = input.size();
			Integer integer = input.get(0);
			for (int y = 1; y < size; y++) {
				auxInput.add(input.get(y) + integer);
			}
			input = auxInput;
		}
		return auxInput.get(0) + auxInput.get(1);
	}
}