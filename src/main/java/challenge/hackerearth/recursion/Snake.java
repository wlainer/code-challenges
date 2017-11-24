package challenge.hackerearth.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import challenge.TestBase;

public class Snake extends TestBase {

	private static final String direction = "rdlu";
	private static Integer snakeSize = 7;
	private static Integer boardSize = 10;

	public void solution() {

		List<String> lines = null;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("./challenge/hackerearth/recursion/Snake_01_in.txt")));

			lines = new ArrayList<String>();
			String strLine;
			// Read File Line By Line
			while ((strLine = reader.readLine()) != null) {
				// Print the content on the console
				lines.add(strLine);
			}

			// Close the input stream
			reader.close();
		} catch (Exception e) {

		}

		int size = lines.size();

		int[][] grid = new int[size][size];
		for (int i = 0; i < grid.length; i++) {
			String string = lines.get(i);
			String[] split = string.split(",");

			for (int j = 0; j < split.length; j++) {
				grid[i][j] = Integer.valueOf(split[j].trim());

			}

		}

		List<String> a = new ArrayList();
		a.add("r");
		a.add("l");
		a.add("u");
		a.add("d");

		List<String> generateCombinations = generateCombinations(snakeSize - 1, (ArrayList<String>) a);
		//
		// for (String string : generateCombinations) {
		// System.out.println(string);
		// }

//		int[][] board = new int[size][size];
		int[][] board = new int[boardSize][boardSize];
		int superCount = 0;
		Map<Integer, Integer> map = new HashMap();
		outer: for (String string : generateCombinations) {
			initializeBoard(board);
			int row = 0;
			int col = 0;
			board[row][col] = 1;

			int sum = grid[row][col];
			int cont = 0;
			inner: for (char c : string.toCharArray()) {
				switch (c) {
				case 'r':
					col = col + 1;

					if (col >= 0 && col < 4 && board[row][col] != 1) {
						sum += grid[row][col];
						board[row][col] = 1;
						cont++;
					} else
						continue outer;
					break;
				case 'l':
					col = col - 1;

					if (col >= 0 && col < 4 && board[row][col] != 1) {
						sum += grid[row][col];
						board[row][col] = 1;
						cont++;
					} else
						continue outer;
					break;
				case 'u':
					row = row - 1;

					if (row >= 0 && row < 4 && board[row][col] != 1) {
						sum += grid[row][col];
						board[row][col] = 1;
						cont++;
					} else
						continue outer;
					break;
				case 'd':
					row = row + 1;

					if (row >= 0 && row < 4 && board[row][col] != 1) {
						sum += grid[row][col];
						board[row][col] = 1;
						cont++;
					} else
						continue outer;
					break;

				default:
					break;
				}

			}
			if (cont == snakeSize - 1) {
				if (map.get(sum) == null) {
					map.put(sum, 0);
				} else {
					map.put(sum, map.get(sum) + 1);
				}
				
				superCount++;
				System.out.println("-------------");
				printBoard(board);
			}
		}

		System.out.println(superCount);

		// Scanner s = getScanner();
		//
		// int boardSize = s.nextInt();
		//
		// int[][] board = new int[boardSize][boardSize];
		// for (int i = 0; i < boardSize; i++)
		// for (int j = 0; j < boardSize; j++)
		// board[i][j] = 0;
		//
		// boolean result = move(board, 0, 0, 0);
		// printBoard(4, board);

	}

	private void initializeBoard(int[][] board) {
		for (int i = 0; i < boardSize; i++)
			for (int j = 0; j < boardSize; j++)
				board[i][j] = 0;
	}

	private void printBoard(int[][] board) {
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++)
				System.out.print(board[i][j] + " ");

			System.out.println();
		}
	}

	private boolean move(int[][] board, int x, int y, int direction) {
		// if (snakeSize > 0)
		// canMove(x, y, board)

		printBoard(board);
		System.out.println("---------------");

		board[x][y] = board[x][y] + 1;
		snakeSize--;

		char d = this.direction.charAt(direction % 4);
		if (snakeSize > 0) {
			switch (d) {
			case 'r':
				int row = x;
				int col = y + 1;
				if (row >= 0 && col < board.length)
					move(board, row, col, 0);

				break;
			case 'l':
				row = x;
				col = y - 1;
				if (row >= 0 && col < board.length)
					move(board, row, col, 2);

				break;
			case 'u':
				row = x - 1;
				col = y;
				if (row >= 0 && col < board.length)
					move(board, row, col, 3);

				break;
			case 'd':
				row = x + 1;
				col = y;
				if (row >= 0 && col < board.length)
					move(board, row, col, 1);

				break;

			default:
				break;
			}
		} else {
			snakeSize = snakeSize + 2;
			switch (d) {
			case 'r':
				int row = x;
				int col = y - 1;
				if (row >= 0 && col < board.length)
					move(board, row, col, direction + 1);

				break;
			case 'l':
				row = x;
				col = y + 1;
				if (row >= 0 && col < board.length)
					move(board, row, col, direction + 1);

				break;
			case 'u':
				row = x + 1;
				col = y;
				if (row >= 0 && col < board.length)
					move(board, row, col, direction + 1);

				break;
			case 'd':
				row = x - 1;
				col = y;
				if (row >= 0 && col < board.length)
					move(board, row, col, direction + 1);

				break;

			default:
				break;
			}
		}

		return false;
	}

	@Test
	public void test() {
		restoreOldOut();

		solution();

		String[] lines = getLines();
		// Assert.assertEquals("true", lines[0]);
	}

	public static void possibleStrings(int maxLength, char[] alphabet, String curr) {

		// If the current string has reached it's maximum length
		if (curr.length() == maxLength) {
			System.out.println(curr);

			// Else add each letter from the alphabet to new strings and process these new strings again
		} else {
			for (int i = 0; i < alphabet.length; i++) {
				String oldCurr = curr;
				curr += alphabet[i];
				possibleStrings(maxLength, alphabet, curr);
				curr = oldCurr;
			}
		}
	}

	private List<String> generateCombinations(int arraySize, ArrayList<String> possibleValues) {
		StringBuffer buf;
		List<String> arr = new ArrayList<String>();

		int carry;
		int[] indices = new int[arraySize];
		do {
			buf = new StringBuffer();
			for (int index : indices)
				buf.append(possibleValues.get(index));

			arr.add(buf.toString());

			carry = 1;
			for (int i = indices.length - 1; i >= 0; i--) {
				if (carry == 0)
					break;

				indices[i] += carry;
				carry = 0;

				if (indices[i] == possibleValues.size()) {
					carry = 1;
					indices[i] = 0;
				}
			}
		} while (carry != 1);

		return arr;
	}

}
