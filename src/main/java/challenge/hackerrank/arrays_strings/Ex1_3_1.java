package challenge.hackerrank.arrays_strings;

import java.text.MessageFormat;


public class Ex1_3_1 {

	public static void main(String[] args) {
		String s = "dog";
		String t = "god";
		
		System.out.println(MessageFormat.format("String {0} is a permution of {1}? \n{2}", s, t, permutation(s, t)));
	}

	public static boolean permutation(String s, String t) {
		if (s.length() != t.length())
			return false;

		int[] letters = new int[256];

		char[] s_array = s.toCharArray();
		for (char c : s_array) {
			letters[c]++;
		}

		for (int i = 0; i < t.length(); i++) {
			int c = t.charAt(i);
			if (--letters[c] < 0)
				return false;
		}

		return true;

	}
}
