package challenge.zalando;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class Test_1 {

	public String solution(String S) {

		StringTokenizer tokenizer = new StringTokenizer(S, "\n");

		Map<String, List<Date>> location = new HashMap();

		String patternString = "([a-zA-z]*).\\s?([a-zA-z]*),\\s?([a-zA-z]*),(.*)";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		while (tokenizer.hasMoreElements()) {
			String file = (String) tokenizer.nextElement();

			Pattern pattern = Pattern.compile(patternString);
			Matcher matcher = pattern.matcher(file);

			if (matcher.find()) {
				String cityName = matcher.group(3);
				Date date = null;
				try {
					date = sdf.parse(matcher.group(4).trim());
				} catch (ParseException e) {
					e.printStackTrace();
				}

				if (location.get(cityName) == null) {
					List<Date> arr = new ArrayList();
					arr.add(date);
					location.put(cityName, arr);
				} else {
					location.get(cityName).add(date);
				}
			}
		}

		for (String key : location.keySet()) {
			Collections.sort(location.get(key));
		}

		StringTokenizer tokenizer2 = new StringTokenizer(S, "\n");
		StringBuffer result = new StringBuffer();
		while (tokenizer2.hasMoreElements()) {
			String file = (String) tokenizer2.nextElement();

			Pattern pattern = Pattern.compile(patternString);
			Matcher matcher = pattern.matcher(file);

			if (matcher.find()) {
				String extension = matcher.group(2);
				String cityName = matcher.group(3);
				Date date = null;
				try {
					date = sdf.parse(matcher.group(4).trim());
				} catch (ParseException e) {
					e.printStackTrace();
				}

				String numberDigits = String.valueOf(location.get(cityName).size());
				String index = String.format("%0"+numberDigits.length()+"d", location.get(cityName).indexOf(date) + 1);

				result.append(cityName + index + "." + extension+"\\n");
				
			}
		}

		return result.toString();
	}

	@Test
	public void test() {
		Test_1 test1 = new Test_1();

		String files = "photo.jpg, Warsaw, 2013-09-05 14:08:15\njohn.png, London, 2015-06-20 15:13:22\nmyFriends.png, Warsaw, 2013-09-05 14:07:13\nEiffel.jpg, Paris, 2015-07-23 08:03:02\npisatower.jpg, Paris, 2015-07-22 23:59:59\nBOB.jpg, London, 2015-08-05 00:02:03\nnotredame.png, Paris, 2015-09-01 12:00:00\nme.jpg, Warsaw, 2013-09-06 15:40:22\na.png, Warsaw, 2016-02-13 13:33:50\nb.jpg, Warsaw, 2016-01-02 15:12:22\nc.jpg, Warsaw, 2016-01-02 14:34:30\nd.jpg, Warsaw, 2016-01-02 15:15:01\ne.png, Warsaw, 2016-01-02 09:49:09\nf.png, Warsaw, 2016-01-02 10:55:32\ng.jpg, Warsaw, 2016-02-29 22:13:11";

		String solution = test1.solution(files);
		
		System.out.println(solution);

	}
}