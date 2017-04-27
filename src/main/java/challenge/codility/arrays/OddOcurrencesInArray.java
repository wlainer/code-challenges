package challenge.codility.arrays;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;


public class OddOcurrencesInArray {

	public int solution(int[] A) {
		int length = A.length;
		
		Map<Integer, Integer> ocurrences = new HashMap();
		
		for (int x = 0; x < length ; x++) { 
			Integer integer = ocurrences.get(A[x]);
			if ( integer == null ) ocurrences.put(A[x], 1);
			else ocurrences.put(A[x], ++integer);
		}

		int value = 0;
		for (Integer key: ocurrences.keySet()) {
			if (ocurrences.get(key) % 2 != 0)
				value = key;
		}
		
		return value;
	}

	@Test
	public void test() {
		OddOcurrencesInArray oddOcurrencesInArray = new OddOcurrencesInArray();

		int[] A = {9, 3, 9, 3, 9, 7, 9};
		int solution = oddOcurrencesInArray.solution(A);
		Assert.assertEquals(solution, 7);
		
	}
		
}