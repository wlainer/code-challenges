package challenge.hackerrank.arrays_strings;

public class Ex1_4_1 {
	
	public static void main(String[] args) {
		String s = "wlainer ribeiro";
		System.out.println(replaceSpaces(s));
	}

	public static String replaceSpaces(String s) {
		char[] s_array = s.toCharArray();
		int spaceCount = 0, newLength, i;

		for (i = 0; i < s_array.length; i++) {
			if (s_array[i] == ' ')
				spaceCount++;
		}

		newLength = s_array.length + spaceCount * 2;
		s_array[newLength] = '\0';
		for (i = s_array.length - 1; i >= 0; i--) {
			if (s_array[i] == ' ') {
				s_array[newLength - 1] = '0';
				s_array[newLength - 2] = '2';
				s_array[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				s_array[newLength - 1] = s_array[i];
				;
				newLength = newLength - 1;
			}
		}
		return new String(s_array);
	}
}
