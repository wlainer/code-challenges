package codility.timecomplexity;


import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class PermMissingElement {
	
//	 public static int solution(int[] A) {
//		 if (A.length == 0) return 1;
//		 
//		 Map<Integer, Boolean> map = new HashMap();
//		 
//		 for (int i = 0; i < A.length; i++) 
//			map.put(A[i], Boolean.FALSE);
//		
//
//		 int value = 0;
//		 for (int i = 1; i <= A.length +1; i++)  
//			if (map.get(i) == null) value = i;
//		
//		return value;
//	 }
	 
	 public int solution(int[] A) {
	        // write your code in Java SE 8
	        // this is the key declaration.if you use int instead of long, you'll
	        // not pass the performance test.
	        long N = A.length + 1;
	        // calculate the sum of 1 + 2 + ... + (N + 1)
	        long result = (N * (N + 1)) / 2;
	        // get the result by subtracting all the array element from 1 + 2 +
	        // ... (N + 1)
	        for (int element : A)
	            result -= element;
	        return (int)result;
	    }
	 
	 @Test
	 public void test() {
		 
		 int[] A = {2, 3, 1, 5};
		 Assert.assertEquals(solution(A), 4);
		 
		 A = new int[] {1,2,3,4,5,6,7,8,10,11};
		 Assert.assertEquals(solution(A), 9);
		 
		 A = new int[] {};
		 Assert.assertEquals(solution(A), 1);
		 
		 A = new int[] {1, 2, 3,4, 5};
		 Assert.assertEquals(solution(A), 6);
		 
		 A = new int[] {1};
		 Assert.assertEquals(solution(A), 2);
		 
	 }
	 
	 

	
	
}
