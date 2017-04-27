package challenge.hackerrank.regex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlElements {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int times = scanner.nextInt();

		String regex = "<\\s*(\\w*)\\s*[^\\/]";
		Pattern pattern = Pattern.compile(regex);

		Set<String> elements = new HashSet();
		for (int x = 0; x < times + 1; x++) {
			String link = scanner.nextLine();
			Matcher matcher = pattern.matcher(link);

			while (matcher.find()) {
				elements.add(matcher.group(1));
			}
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
