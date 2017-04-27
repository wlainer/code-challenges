package challenge.hackerrank.regex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectEmail {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(DetectEmail.class.getResourceAsStream("/regex/email/input3.txt"));
		int times = scanner.nextInt();

		StringBuilder text = new StringBuilder();
		for (int x = 0; x <= times; x++) {
			text.append(scanner.nextLine() + "\n");
		}

		String texto = text.toString();
		Set<String> elements = new HashSet();
		String regex = "\\s(\\w*@\\w*\\.\\w*(?:\\.\\w+)?(?:\\.\\w+)?)";
		Matcher matcher = Pattern.compile(regex).matcher(texto);

		while (matcher.find()) {
			elements.add(matcher.group(1));
		}

		List<String> list = new ArrayList(elements);
		Collections.sort(list);

		StringBuilder builder = new StringBuilder();
		for (String string : list) {
			builder.append(string + ";");
		}

		builder.deleteCharAt(builder.length() - 1);
		System.out.println(builder.toString());
	}

}
