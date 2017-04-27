package challenge.hackerrank.arrays_strings;

import java.text.MessageFormat;


public class Ex1_3_2 {

	public static void main(String[] args) {
		String s = "dog";
		String t = "god";
		
		System.out.println(MessageFormat.format("String {0} is a permution of {1}? \n{2}", s, t, permutation(s, t)));
	}

	public static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}

	public static boolean permutation(String s, String t) {
		if (s.length() != t.length())
			return false;

		return sort(s).equals(sort(t));
	}
}
