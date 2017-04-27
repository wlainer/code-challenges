package challenge.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlienName {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int times = Integer.valueOf(scanner.nextLine());

		String regex = "^[_\\.][0-9]+[a-zA-Z]*_?$";
		Pattern pattern = Pattern.compile(regex);
		
		for (int x = 0; x <= times; x++) {
			String word = scanner.nextLine();
			Matcher m = pattern.matcher(word);
			
			System.out.println(m.find() ? "VALID" : "INVALID");
		}
	}

}
