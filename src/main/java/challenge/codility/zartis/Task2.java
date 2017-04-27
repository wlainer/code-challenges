package challenge.codility.zartis;


public class Task2 {

	public static int solution(int A, int B) {
		String a = Integer.toString(A);
		String b = Integer.toString(B);

		StringBuffer buffer = new StringBuffer();
		
		int maxLength = a.length() > b.length() ? a.length() : b.length();
		for (int x = 0; x < maxLength; x++) {
			if (x < a.length())
				buffer.append(a.charAt(x));
			
			if (x < b.length())
				buffer.append(b.charAt(x));
		}
		
		long result = Long.valueOf(buffer.toString());
		
		if (result < 100000000) 
			return Integer.parseInt(buffer.toString());
		else
			return -1;
					
	}

	public static void main(String[] args) {
		int a = 12345;
		int b = 678;

		System.out.println(solution(a, b));
	}
}
