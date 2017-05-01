package challenge.hackerearth.arrays.onedimension;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import challenge.TestBase;

public class BinaryQueries extends TestBase {

	public void solution() {
		Scanner s = getScanner();
		
		int N = s.nextInt();
		int M = s.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) 
			arr[i] = s.nextByte();
		
		for (;M > 0; M--) {
			int kindQuery = s.nextInt();
			if (kindQuery == 1) {
				int pos = s.nextInt();
				arr[pos-1] ^= arr[pos+1];
			} else {
				int begin = s.nextInt();
				int end = s.nextInt();
				
				int value = convertBinaryStringToInt(arr, begin, end);
				
				if (value % 2 == 0) System.out.println("EVEN");
				else System.out.println("ODD");
			}
		}
	}
	
	
	
	private int convertBinaryStringToInt(int[] arr, int begin, int end) {
		int result = 0;
		int pow = 0;
		for (int i = begin-1; i < end; i++) 
			if (arr[i] == 1) result +=  Math.pow(2, pow++);
		
		return result;
	}



	@Test
	public void test() {
		solution();
		
		String[] lines = getLines();
		Assert.assertEquals("ODD", lines[0]);
	}
}
