package challenge.hackerearth.arrays.onedimension;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import challenge.TestBase;

public class MemorizeMe extends TestBase {

	public void solution() {
		Scanner s = getScanner();
		int N = s.nextInt();
		
		Map<Integer, Integer> arr = new HashMap();
		for (int i = 0; i < N; i++) { 
			int value = s.nextInt();
			if (arr.get(value) == null) arr.put(value, 1);
			else arr.put(value, arr.get(value)+1);
		}
		
		int times = s.nextInt();
		for (int i = 0; i < times; i++){
			int value = s.nextInt();
			if (arr.get(value) == null) System.out.println("NOT PRESENT");
			else System.out.println(arr.get(value));
		}
			
	}
	
	@Test
	public void test() {
		solution();
		
		String[] lines = getLines();
		Assert.assertEquals("3", lines[0]);
		Assert.assertEquals("2", lines[1]);
		Assert.assertEquals("3", lines[2]);
		Assert.assertEquals("1", lines[3]);
		Assert.assertEquals("NOT PRESENT", lines[4]);
		Assert.assertEquals("NOT PRESENT", lines[5]);
	}
}
