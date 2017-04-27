package challenge.hackerrank.java.datastructures;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Java1DArrayPart2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(Java1DArrayPart2.class.getResourceAsStream("/java/dataestructures/java_1d_array_part2/input00.txt"));

		int T = Integer.parseInt(sc.next());
		for (; T > 0; T--) {
			int N = Integer.parseInt(sc.next());
			int M = Integer.parseInt(sc.next());
			int[] a = new int[N];
			for (int i = 0; i < N; i++)
				a[i] = Integer.parseInt(sc.next());
			System.out.println(solve(N, M, a) ? "YES" : "NO");
		}
	}

	static boolean solve(int N, int M, int[] a) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(0);
		a[0] = 1;
		for (; !q.isEmpty();) {
			int cur = q.poll();
			int[] x = new int[] { -1, 1, M };
			for (int d : x) {
				int nxt = cur + d;
				if (nxt >= N)
					return true;
				if (nxt > 0 && a[nxt] == 0) {
					q.add(nxt);
					a[nxt] = 1;
				}
			}
		}
		return false;
	}

}
