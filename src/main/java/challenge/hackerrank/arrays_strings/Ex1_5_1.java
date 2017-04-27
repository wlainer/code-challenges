package challenge.hackerrank.arrays_strings;

public class Ex1_5_1 {

	public static void main(String[] args) {
		String s = "aabccccaaa";
		System.out.println(compressBad(s));
	}

	public static String compressBad(String str) {
		String myStr = "";
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				myStr += last + "" + count;
				last = str.charAt(i);
				count = 1;
			}
		}
		return myStr + last + count;
	}
}
