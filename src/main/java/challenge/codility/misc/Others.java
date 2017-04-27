package challenge.codility.misc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Others {
	
	public static void main(String[] args) {
//		char[] str = {'h','e','l','l','o',' ','w','o','r','l','d','\0','\0','\0'};
//		System.out.println(str);
//		replaceSpaces(str, 11);
//		System.out.println(str);
		
//		System.out.println(rotate2Numbers(8093));
//		System.out.println(swap2Numbers(9857));
//		readCharAtTime();
		int k = 4;
		logFile(4);
	}

	public static void replaceSpaces(char[] str, int length) {
 		int spaceCount = 0, newLength, i;

		for (i = 0; i < length; i++)
			if (str[i] == ' ')
				spaceCount++;

		newLength = length + spaceCount * 2;
		str[newLength] = '\0';
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
	}
	
	// 8093 -> output 9083
	public static int rotate2Numbers(int value) {
		int[] array = Integer.toString(value).chars().map(c -> c -= '0').toArray();

		int numSwaps = 2;
		for (int x = 0; x < 2; x++) {
			int index = 0;
			int maxValue = Integer.MIN_VALUE;
			for (int y = 0; y < array.length; y++) {
				if (array[y] > maxValue) {
					maxValue = array[y];
					index = y;
				}
			}
			
			if (index != 0) {
				int aux = array[index - 1];
				array[index - 1] = array[index];
				array[index] = aux;
			}
		}

		return Integer.valueOf(Arrays.toString(array).replaceAll("\\D+", ""));
	}
	
	public static int swap2Numbers(int value) {
		int[] array = Integer.toString(value).chars().map(c -> c -= '0').toArray();

		for (int x = 0; x < array.length; x++) {
			for (int y = x+1; y < array.length; y++) {
				if (array[x] < array[y]) {
					int aux = array[y];
					array[y] = array[x];
					array[x] = aux;
					break;
				}
			}
		}

		return Integer.valueOf(Arrays.toString(array).replaceAll("\\D+", ""));
	}
	
	public static void readCharAtTime() {
		try {

			String[] wordsOfInterest = new String[] { "foo", "bar", "Nam" };
			Map<String, Integer> hash = new HashMap();
			Map<String, Integer> hash2 = new HashMap();

			for (String word : wordsOfInterest) {
				hash.put(word, 0);
				hash2.put(word, 0);
			}

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream("d:/lorem.txt"),
					Charset.forName("UTF-8")));
			int c;
			while ((c = reader.read()) != -1) {
				char character = (char) c;

				Set<String> keySet = hash.keySet();
				for (String key : keySet) {
					
					if (key.charAt(hash.get(key)) == c) {
						Integer integer = hash.get(key);
						if (integer.equals(key.length()-1)) {
							hash.put(key, 0);
							Integer integer2 = hash2.get(key);
							hash2.put(key, ++integer2);
						} else {
							hash.put(key, ++integer);
						}
					} else {						
						hash.put(key, 0);
					}
				}
			}
			System.out.print("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void logFile(int j) {
		try {
			BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream("d:/example.txt"), Charset.forName("UTF-8")));
			
			String pattern = "line13";
			String[] cache = new String[j];
			int pos = 0;
			
			
			String line = null;
			while ((line = bReader.readLine()) != null) {
				Pattern o = Pattern.compile(pattern);
				Matcher matcher = o.matcher(line);
				if (matcher.find())	
					break;
				
				cache[pos % j] = line;
				pos++;
			}
			
			bReader.close();

			for (int i = pos; i < j + pos; i++) {
				System.out.println(cache[i % j]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
