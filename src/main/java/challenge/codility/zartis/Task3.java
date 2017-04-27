package challenge.codility.zartis;

public class Task3 {

	public static int solution(int[][] A) {
		int row = A.length;
		int col = A[0].length;

		int[][] AAux = new int[row][col] ;
		for (int x = 0; x < row; x++) {
			for (int y = 0; y < col; y++) {
				AAux[x][y] = -1;
			}
		}
		

		int sum = 0;
		for (int x = 0; x < row; x++) {
			for (int y = 0; y < col; y++) {
				if (AAux[x][y] == -1) {
					int currentValue = A[x][y];
					isThereAnyNeighbor(A, AAux, currentValue, x, y);
					sum++;
				}
			}
		}

		return sum;
	}
	
	private static void isThereAnyNeighbor(int[][] A,int[][] AAux, int currentValue, int row, int col) {
//		// up
//		if (row - 1 >= 0 && currentValue == A[row - 1][col])
//			isThereAnyNeighbor(A, currentValue, row - 1, col);

		AAux[row][col] = 0;
		
		// down
		if (row + 1 < A.length && currentValue == A[row + 1][col] && AAux[row + 1][col] == -1){
			isThereAnyNeighbor(A, AAux, currentValue, row + 1, col);
		}

		// left
		if (col - 1 >= 0 && currentValue == A[row][col - 1] && AAux[row][col-1] == -1){
			isThereAnyNeighbor(A, AAux, currentValue, row, col - 1);
		}

		// right
		if (col + 1 < A[0].length && currentValue == A[row][col + 1] && AAux[row][col+1] == -1 ||
				col + 2 < A[0].length && currentValue == A[row][col + 2] && AAux[row][col+2] == -1){
			isThereAnyNeighbor(A, AAux, currentValue, row, col + 1);
		}
		
	}
	
	public static void main(String[] args) {
		int[][] A = new int[7][3];

		A[0][0] = 5;
		A[1][0] = 4;
		A[2][0] = 3;
		A[3][0] = 2;
		A[4][0] = 3;
		A[5][0] = 1;
		A[6][0] = 4;
		A[0][1] = 4;
		A[1][1] = 3;
		A[2][1] = 2;
		A[3][1] = 2;
		A[4][1] = 3;
		A[5][1] = 4;
		A[6][1] = 1;
		A[0][2] = 4;
		A[1][2] = 4;
		A[2][2] = 4;
		A[3][2] = 2;
		A[4][2] = 4;
		A[5][2] = 4;
		A[6][2] = 1;

		System.out.println(solution(A));

	}

}
