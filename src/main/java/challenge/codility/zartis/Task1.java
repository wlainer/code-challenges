package challenge.codility.zartis;

public class Task1 {

	static int solution(int[] A) {
		int N = A.length;

		int result1 = 0;
		int result2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) break;
				if (A[i] == A[j]) {
					result1 = Math.max(result1, Math.abs(i - j));
					break;
				}
			}
			
			for (int j = N - 1; j > -1; j--) {
				if (i == j) break;
				if (A[i] == A[j]) {
					result2 = Math.max(result2, Math.abs(i - j));
					break;
				}
			}
		}

		return Math.max(result1, result2);
	}

	public static void main(String[] args) {
		int[] a = new int[] { 4, 6, 2, 2, 6, 6, 1 };
//		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		int solution = solution(a);
		System.out.println(solution);

	}

}
