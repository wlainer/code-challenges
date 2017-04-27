package challenge.hackerrank.arrays_strings;

import java.text.MessageFormat;

public class Ex1_1_1 {

	public static void main(String[] args) {
		String str = "asdfghjklqwertyuiop´zxcvbndm";
		System.out.println(MessageFormat.format("String ''{0}'' contains only uniqueChars?", str));
		System.out.println(isUniqueChars2(str));
		;
	}

	public static boolean isUniqueChars2(String str) {
		if (str.length() > 256)
			return false;

		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) {
				return false;
			}

			char_set[val] = true;
		}

		return true;
	}

}
