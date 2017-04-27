package challenge.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindSubstring {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(FindSubstring.class.getResourceAsStream("/regex/substring/input2.txt"));
		int times = scanner.nextInt();

		StringBuilder text = new StringBuilder();
		for (int x = 0; x <= times; x++) {
			text.append(scanner.nextLine() + "\n");
		}

		int substringQuantities = Integer.valueOf(scanner.nextLine());
		String texto = text.toString();
		for (int x = 0; x < substringQuantities; x++) {
			String substring = scanner.nextLine();

			String regex = "\\w(" + substring + ")\\w";
			Matcher m = Pattern.compile(regex).matcher(texto);

			int cont = 0;
			while (m.find()) {
				cont++;
			}
			System.out.println(cont);
		}
	}

}
