package challenge.others;



import java.util.Arrays;
import java.util.List;

public class StringReducer {

	static int reduce(String[] w) {
		List<String> asList = Arrays.asList(w);

		int max = 0;
		for (String string : asList) {
			int reduceLoop = reduceLoop(string, asList);
			if (reduceLoop > max)
				max = reduceLoop;
		}
		return max;
	}

	private static int reduceLoop(String string, List<String> w) {
		int cont = 0;	
		for (int x = 0; x < string.length(); x++) {
				StringBuilder sb = new StringBuilder(string);
				if (sb.length() == 1) break;
				sb.deleteCharAt(x);
				String string2 = sb.toString();
				if (w.contains(string2)) cont = cont + reduceLoop(string2, w) + 1;
			}
		return cont;
	}

	static int countWords(String string, int pos) {
		try {
			string.charAt(pos);
			return countWords(string, ++pos) + 1;
		} catch (Exception e) {
			return 0;
		}
	}

	static int countWordsTail(String string, int sum) {
		try {
			string.charAt(sum);
			return countWords(string, sum++);
		} catch (Exception e) {
			return 0;
		}
	}

	public static void main(String[] args) {
		String[] w = new String[] { "a", "b", "ba", "bda", "bca", "bdca" };
		String[] w2 = new String[] { "bcda", "bda", "bca", "cda", "da" };
		System.out.println(reduce(w));

		//
		// int maxReduction = maxReduction(w);
		// System.out.println(maxReduction);

		// String test = "fsdafksadlfjldsajflsdakjfldjsalfdjsaklgjsdalk�ffsadfsdagfdafdwqregfsdatewqsdjdsalkfjsda";
		// System.out.println("Tail => " + countWordsTail(test, 0));
		// System.out.println("Normal => " + countWords(test, 0));
	}

}
