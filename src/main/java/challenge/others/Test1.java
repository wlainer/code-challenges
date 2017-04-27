package challenge.others;import java.nio.Buffer;

import challenge.TestInterface;

public class Test1 implements TestInterface {

	
	
	private static final String divisibleBy3 = "Fizz";
	private static final String divisibleBy5 = "Buzz";
	private static final String divisibleBy7 = "Woof";

	@Override
	public Object run() {
		Test1 test1 = new Test1();
		test1.solution(24);
		
		return null;
		
	}

	public void solution(int N) {
		for (int x = 1; x <= N ; x ++) {
			StringBuffer output = new StringBuffer();
			
			if (x % 3 == 0)
				output.append(divisibleBy3);
			
			if (x % 5 == 0)
				output.append(divisibleBy5);
			
			if (x % 7 == 0)
				output.append(divisibleBy7);
			
			if (output.length() == 0)
				output.append(String.valueOf(x));
			
			System.out.println(output.toString());
		}
	}
	
	public static void main(String[] args) {
		Test1 test1 = new Test1();
		test1.run();
	}

}
