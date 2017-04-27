package challenge.hackerearth.searching.linearsearch;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import challenge.TestBase;

public class BreakupApp extends TestBase {

	public void solution() {
		Scanner s = getScanner();

		int times = s.nextInt();

		s.useDelimiter("\\n");

		Map<Integer, Integer> day = new HashMap();

		while (s.hasNextLine()) {
			String value = s.nextLine();
			if (value.length() == 0) continue;
			
			String person = value.substring(0, 1);
			String message = value.substring(3);
			
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < message.length(); i++) {
				if (message.charAt(i) >= '0' && message.charAt(i) <= '9') {
					buffer.append(message.charAt(i));
					if (message.charAt(i + 1) >= '0' && message.charAt(i + 1) <= '9') {
						buffer.append(message.charAt(i + 1));
						i++;
					}

					int weight = person.equals("G") ? 2 : 1;
					if (day.get(Integer.valueOf(buffer.toString())) == null)
						day.put(Integer.valueOf(buffer.toString()), weight);
					else
						day.put(Integer.valueOf(buffer.toString()), day.get(Integer.valueOf(buffer.toString())) + weight);


					buffer = new StringBuffer();
				}
			}
		}
		
		Set<Integer> keySet = day.keySet();
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, key1 = 0, key2 = 0;

		for (Integer key : keySet) {
			Integer value = day.get(key);
			if (value > max1) {
				key2 = key1;
				key1 = key;
				max2 = max1;
				max1 = value;
			} else if (value > max2) {
				max2 = value;
				key2 = key;
			}
		}


		if (key2 == 0 && (key1 == 19 || key1 == 20))
			System.out.println("Date");
		else if (key1 == 19 || key1 == 20)
			System.out.println("Date");
		else if (max1 == max2)
			System.out.println("No Date");
		else
			System.out.println("No Date");
	}
	

	@Test
	public void test() {
		solution();
		
		String[] lines = getLines();
		Assert.assertEquals("Date", lines[0]);
	}
}
