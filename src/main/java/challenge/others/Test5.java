package challenge.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import challenge.TestInterface;

public class Test5 implements TestInterface {

	public static void main(String[] args) {
		Test5 test3 = new Test5();
		test3.run();
	}

	@Override
	public Object run() {
		Test5 test5 = new Test5();

		int A[] = new int[] {
			7,
			3,
			7,
			3,
			1,
			3,
			4,
			1
		};

		int solution = solution(A);
		
		System.out.println(solution);
		
		return null;
	}

	public int solution(int[] A) {
		int[] distinctArray = IntStream.of(A).distinct().toArray();
		List<Integer> distinctList = new ArrayList();
		for (int x = 0; x < distinctArray.length; x++) {
			distinctList.add(distinctArray[x]);
		}
		
		int minimumDays = Integer.MAX_VALUE;
		List<Integer> locations = new ArrayList();
		
		for(int x = 0; x < A.length; x++) {
			int days = 0;
			for (int y = x; y < A.length; y++) {
				locations.add(A[y]);
				days++;
								
				if (locations.containsAll(distinctList)) {
					minimumDays = Math.min(minimumDays, days);
					locations.clear();
					days = 0;
					break;
				}
			}
		}
		
		return minimumDays;
    }

}
