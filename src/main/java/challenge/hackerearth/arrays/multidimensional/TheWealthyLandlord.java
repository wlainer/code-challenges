package challenge.hackerearth.arrays.multidimensional;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

import challenge.TestBase;

public class TheWealthyLandlord extends TestBase {

	public void solution() {
		Scanner s = getScanner();
		
		restoreOldOut();
		
		int N = s.nextInt();
		int[][] arr = new int[N][5];
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < 5; j++) 
				arr[i][j] = s.nextInt();
		
		int maxX = maxValue(arr, 2);
		int maxY = maxValue(arr, 3);
		
		int[][] area = new int[maxX][maxY];
		
		Map<Integer, Integer> overlapped = new HashMap();
		for (int i = 0; i < arr.length; i++) 
			for (int j = arr[i][0] - 1; j <= arr[i][2] - 1; j++) 
				for (int j2 = arr[i][1] - 1; j2 <= arr[i][3] - 1; j2++) 
					area[j][j2] += arr[i][4];
		
		Set<Integer> keySet = overlapped.keySet();
		int size = keySet.size();
		int result = 0;
		for (Integer integer : keySet) {
			result += arr[integer-1][4] * (overlapped.get(integer) / size--);
		}
		
		System.out.println(result);
		
		for (int i = 0; i < area.length; i++) { 
			for (int j = 0; j < area[0].length; j++) 
					System.out.print(area[i][j]+ " ");
			
			System.out.println();
		}
	}
	
	private static int maxValue(int[][] arr, int index) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) 
			max = Math.max(max, arr[i][index]);
		
		return max;
	}
	
	@Test
	public void test() {
		solution();
		
		String[] lines = getLines();
	}
}
