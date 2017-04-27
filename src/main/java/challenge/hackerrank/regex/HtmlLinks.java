package challenge.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlLinks {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(HtmlLinks.class.getResourceAsStream("/regex/html_links/input5.txt"));
		int times = scanner.nextInt();

		String regex = "a.*?href=\"(.*?)\".*?>(.*?)<\\/";
		Pattern pattern = Pattern.compile(regex);

		for (int x = 0; x < times + 1; x++) {
			String link = scanner.nextLine();
			Matcher matcher = pattern.matcher(link);

			while (matcher.find()) {
				System.out.println(matcher.group(1) + "," + matcher.group(2));
			}
		}
	}

}
