package challenge.codility.iterations;

import org.junit.Assert;
import org.junit.Test;

public class BinaryGap {
	
	public int solution(int N) {
		String binary = Integer.toBinaryString(N);
		int i = binary.length() - 1;
		while (binary.charAt(i) == '0')
			i--;
		int gap = 0;
		int counter = 0;
		for (; i >= 0; i--) {
			if (binary.charAt(i) == '1') {
				gap = Math.max(gap, counter);
				counter = 0;
			} else {
				counter++;
			}
		}
		
		gap = Math.max(counter, gap);
		return gap;
	}
	
//	public int solution(int N) {
//        String binary = Integer.toBinaryString(N);
//        int i = binary.length()-1;
//        while(binary.charAt(i)=='0') {
//            i--;
//        }
//        int gap = 0;
//        int counter = 0;
//        for(; i>=0; i--) {
//            if(binary.charAt(i)=='1') {
//                gap = Math.max(gap, counter);
//                counter = 0;
//            } else {
//                counter++;
//            }
//        }
//        gap = Math.max(gap, counter);
//        return gap;
//    }
	
//    public int solution(int N) {
//    	String binaryString = Integer.toBinaryString(N);
//    	int[] array = binaryString.chars()
//    		.map(c -> c -= '0').toArray();
//    	
//    	int gap = 0;
//    	int maxGap = Integer.MIN_VALUE;
//    	for (int x = 0; x < array.length -1; x++) {
//    		if (array[x] == 0) gap++;
//    		else gap = 0;
//    		
//    		if (x ==  array.length -1 && array[x] == 0)
//    			gap = 0;
//    		
//    		maxGap = Math.max(maxGap, gap);
//    	}
//    	
//    	return maxGap;
//    }
    
    @Test
    public void test() {
    	BinaryGap binaryGap = new BinaryGap();
    	int solution = binaryGap.solution(1041);
    	Assert.assertEquals(solution, 5);
    	
    	solution = binaryGap.solution(8);
    	Assert.assertEquals(solution, 0);
    	
    	solution = binaryGap.solution(9);
    	Assert.assertEquals(solution, 2);
    	
    	solution = binaryGap.solution(529);
    	Assert.assertEquals(solution, 4);
    	
    	solution = binaryGap.solution(20);
    	Assert.assertEquals(solution, 1);
    }
}