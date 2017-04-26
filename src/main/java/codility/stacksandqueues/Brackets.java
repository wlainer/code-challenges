package codility.stacksandqueues;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class Brackets {

	public int solution(String S) {
		Stack stack = new Stack<>();
		
		for (char c: S.toCharArray()) {
			switch (c) {
			case '{': stack.push(c); break;
			case '[': stack.push(c); break;
			case '(': stack.push(c); break;
			
			default: break;
			}

			if (stack.isEmpty())
				return 0;
			
			switch (c) {
			case '}': 
				if ((char) stack.peek() == '{') stack.pop();
				break;
			case ']': 
				if ((char) stack.peek() == '[') stack.pop();
				break;
			case ')': 
				if ((char) stack.peek() == '(') stack.pop();
				break;

			default: break;
			}
		}
		
		return stack.size() == 0 ? 1 : 0;
	}

	@Test
	public void test() {
		String A = "{[()()]}";
		Assert.assertEquals(solution(A), 1);

		A = "([)()]";
		Assert.assertEquals(solution(A), 0);
		
		A = ")(";
		Assert.assertEquals(solution(A), 0);
	
		A = "";
		Assert.assertEquals(solution(A), 1);
	}

}
