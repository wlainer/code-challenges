package challenge.others;



import java.util.Scanner;

public class Sum3And5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int times = sc.nextInt();

		for (int x = 0; x < times; x++) {
			int value = sc.nextInt();
			double result = sumPA(value, 3) + sumPA(value, 5) - sumPA(value, 15);
			System.out.println((int) result);
		}
	}

	static double sumPA(float maxValue, int divisor) {
		double first = (maxValue - 1) / divisor;
		double second = ((maxValue - 1) / divisor) + 1;
		double third = divisor / 2f;

		return Math.floor(first) * Math.floor(second) * third;
		}

}
