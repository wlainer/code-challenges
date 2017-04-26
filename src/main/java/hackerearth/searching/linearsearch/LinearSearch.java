package hackerearth.searching.linearsearch;

import java.util.Scanner;

class LinearSearch {
	public static void main(String args[] ) throws Exception {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int value = s.nextInt();

		int[] A = new int[N];
		int index = -1;
		for (int i = 0; i < N; i++)
			if (s.nextInt() == value)
				index = i + 1;

		System.out.println(index);
        
    }
}