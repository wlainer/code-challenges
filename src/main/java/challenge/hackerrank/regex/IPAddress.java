package challenge.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAddress {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int times = Integer.valueOf(scanner.nextLine());

		String regexIpv4 = "(?:(?:25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|[0-9][0-9]|[0-9])\\.){3}(?:25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|[0-9][0-9]|[0-9])";
		String regexIpv6 = "(?:(?:[0-9a-f\\s]?){4}:){7}(?:[0-9a-f\\s]?){4}";

		for (int x = 0; x <= times; x++) {
			String word = scanner.nextLine();

			Matcher m = Pattern.compile(regexIpv4).matcher(word);

			if (m.find()) {
				System.out.println("IPv4");
			} else {
				m = Pattern.compile(regexIpv6).matcher(word);
				if (m.find()) {
					System.out.println("IPv6");
				} else {
					System.out.println("Neither");
				}
			}
		}
	}

}
