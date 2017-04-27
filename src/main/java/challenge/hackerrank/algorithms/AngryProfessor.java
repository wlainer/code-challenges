package challenge.hackerrank.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class AngryProfessor {

	public static void main(String[] args) {
		Scanner in = new Scanner(AngryProfessor.class.getResourceAsStream("/algorithms/angry_professor/input.txt"));
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int a[] = new int[n];
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextInt();
			}

			Arrays.sort(a);

			int index = 0;
			for (int x = 0; x < a.length; x++) {
				if (a[x] > 0) {
					index = x;
					break;
				}
			}
			if (index >= k)
				System.out.println("NO");
			else
				System.out.println("YES");
				
		}
	}
}
