package challenge.others;


public class Stair {

	public static void main(String[] args) {
		System.out.println(possibleWays(3));
	}

	public static int possibleWays(int n) {
		if (n < 1) {
			return 0;
		}
		return 1 + possibleWays(n - 1) + possibleWays(n - 2) + possibleWays(n - 3);
	}

}
