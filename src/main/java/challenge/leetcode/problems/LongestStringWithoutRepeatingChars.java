package challenge.leetcode.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

import challenge.TestBase;

public class LongestStringWithoutRepeatingChars extends TestBase {

	@Test
	public void test() {
		solution();
		checkLines();
	}

	private void solution() {
		Scanner s = getScanner();

		String value = s.next();

		if (value.length() == 0) {
			System.out.println("0");
			return;
		}
		
		Map<Character, Integer> map = new HashMap();
		int max = 0;
		for (int i=0, j=0; i<value.length(); ++i){
            if (map.containsKey(value.charAt(i))){
                j = Math.max(j,map.get(value.charAt(i))+1);
            }
            map.put(value.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
		System.out.println(max);
	}

}
