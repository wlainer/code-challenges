package challenge.others;

import challenge.TestInterface;

public class Test4 implements TestInterface {

	public static void main(String[] args) {
		Test4 test3 = new Test4();
		test3.run();
	}

	@Override
	public Object run() {
		Test4 test3 = new Test4();

		String value = "1111111111";
		String solution = test3.solution(value);

		System.out.println(solution);
		// 555-372-654
		return null;
	}

	public String solution(String S) {
		S = S.replace(" ", "");
		   S = S.replace("-", "");

			StringBuffer buffer = new StringBuffer();

			int length;
			boolean dividedBy3 = S.length() % 3 == 0 ? true : false;
			if (S.length() % 3 == 0) {
				length = S.length();
				dividedBy3 = true;
			}
			else {
				length = S.length() - 2;
				dividedBy3 = false;
			}
			
			for (int x = 0; x < length; x++) {
				if (x != 0 && x % 3 == 0)
					buffer.append("-");
				buffer.append(S.charAt(x));
			}

	        if (dividedBy3) 
	            return buffer.toString();
	        else
	            return buffer.toString() + "-" + S.substring(S.length() - 2);
	}

}
