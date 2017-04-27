package challenge.hackerrank.dynamic_programming;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

	public static void main(String[] args) {
		Scanner sc = new Scanner(FibonacciModified.class.getResourceAsStream("/dynamic_programming/fibonacci/input.txt"));

		int i, n;
		BigInteger a, b;
		a = sc.nextBigInteger();
		b = sc.nextBigInteger();
		n = sc.nextInt();
		BigInteger[] val = new BigInteger[n];
		val[0] = a;
		val[1] = b;
		for (i = 2; i < n; i++) {
			val[i] = (val[i - 1].pow(2)).add(val[i - 2]);
		}
		System.out.println(val[i - 1]);
	}

}
