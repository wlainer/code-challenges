package challenge.hackerearth.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import challenge.TestBase;

public class Snake extends TestBase {

	private static final String DIRECTION = "rdlu";
	private static Integer SNAKE_SIZE = 7;
	private static boolean FIND_FIRST = true;
	private Integer boardSize;

	public void solution() {

		List<String> lines = null;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader()
				.getResourceAsStream("./challenge/hackerearth/recursion/Snake_01_in.txt")))) {
			lines = new ArrayList<String>();
			String strLine;
			while ((strLine = reader.readLine()) != null) {
				lines.add(strLine);
			}
		} catch (IOException e) {
			System.err.println("Error while reading the file.");
			e.printStackTrace();
		}

		boardSize = lines.size();

		int[][] grid = new int[boardSize][boardSize];
		for (int i = 0; i < grid.length; i++) {
			String line = lines.get(i);
			String[] values = line.split(",");

			for (int j = 0; j < values.length; j++)
				grid[i][j] = Integer.valueOf(values[j].trim());
		}

		List<String> pathways = generateCombinations(SNAKE_SIZE - 1, DIRECTION.toCharArray());

		Map<Integer, List<Structure>> map = new HashMap();

		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				for (String path : pathways) {
					Integer sum = getSum(i, j, grid, path);
					if (sum != null) {
						Structure structure = new Structure(path, i, j);
						List<Structure> list;
						if (map.get(sum) == null) {
							list = new ArrayList<>();
							list.add(structure);
							map.put(sum, list);
						} else {
							list = map.get(sum);
							if (!verifyStructure(structure, list)) {
								list.add(structure);
								map.put(sum, list);

								printSnakes(list);
								if (FIND_FIRST)
									System.exit(0);

							}
						}
					}
				}
			}
		}
		
//		int count = 0;
//		for (Entry<Integer, List<Structure>> e: map.entrySet()) {
//			if (e.getValue().size() > 1) {
//				count++;
//				if (count == 500) {
//					printSnakes(e.getValue());
//				}
//			}
//		}
//		
//		System.out.println(count);
	}

	private void printSnakes(List<Structure> list) {
		for (Structure structure : list) {
			List<Coordinates> coordinates = getCoordinates(structure.getRow(), structure.getCol(), structure.getPath());
			plotCoord(coordinates);
		}
	}

	private Integer getSum(int row, int col, int[][] grid, String path) {
		List<Coordinates> coordinates = getCoordinates(row, col, path);
		int[][] auxiliarGrid = new int[boardSize][boardSize];
		initializeBoard(auxiliarGrid);

		Integer sum = 0;
		for (Coordinates coord : coordinates) {
			if ((coord.getRow() >= 0 && coord.getRow() < boardSize)
					&& (coord.getCol() >= 0 && coord.getCol() < boardSize)
					&& auxiliarGrid[coord.getRow()][coord.getCol()] != 1) {
				auxiliarGrid[coord.getRow()][coord.getCol()] = 1;
				sum += grid[coord.getRow()][coord.getCol()];
			} else
				return null;
		}

		if (checkSurroundings(coordinates, auxiliarGrid))
			return sum;
		return null;
	}

	private boolean checkSurroundings(List<Coordinates> coordinates, int[][] auxiliarGrid) {

		for (Coordinates coord : coordinates) {
			Integer count = 0;
			// right
			if (coord.getCol() + 1 < boardSize && auxiliarGrid[coord.getRow()][coord.getCol() + 1] == 1)
				count++;

			// left
			if (coord.getCol() - 1 >= 0 && auxiliarGrid[coord.getRow()][coord.getCol() - 1] == 1)
				count++;

			// up
			if (coord.getRow() - 1 >= 0 && auxiliarGrid[coord.getRow() - 1][coord.getCol()] == 1)
				count++;

			// down
			if (coord.getRow() + 1 < boardSize && auxiliarGrid[coord.getRow() + 1][coord.getCol()] == 1)
				count++;

			if (count > 2)
				return false;

		}

		return true;

	}

	private List<Coordinates> getCoordinates(int row, int col, String path) {
		List<Coordinates> list = new ArrayList<>();
		Coordinates coord = new Coordinates(row, col);
		list.add(coord);
		for (char c : path.toCharArray()) {
			switch (c) {
			case 'd':
				row++;
				break;
			case 'u':
				row--;
				break;
			case 'l':
				col--;
				break;
			case 'r':
				col++;
				break;
			default:
				break;
			}
			coord = new Coordinates(row, col);
			list.add(coord);
		}
		return list;
	}

	private boolean verifyStructure(Structure st1, List<Structure> list) {
		List<Coordinates> coordinatesSt1 = getCoordinates(st1.getRow(), st1.getCol(), st1.getPath());

		for (Structure structure : list) {
			List<Coordinates> coordinatesSt2 = getCoordinates(structure.getRow(), structure.getCol(),
					structure.getPath());

			for (Coordinates coordinates : coordinatesSt2) {
				if (coordinatesSt1.contains(coordinates))
					return true;
			}
		}
		return false;
	}

	private void plotCoord(List<Coordinates> coordinates) {
		int[][] board = new int[boardSize][boardSize];
		initializeBoard(board);

		for (Coordinates coord : coordinates)
			board[coord.getRow()][coord.getCol()] = 1;

		printBoard(board);
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
		System.out.println("#####################");
		System.out.println();
	}

	private List<String> generateCombinations(int arraySize, char[] cs) {
		StringBuffer buf;
		List<String> arr = new ArrayList<String>();

		int carry;
		int[] indices = new int[arraySize];
		do {
			buf = new StringBuffer();
			for (int index : indices)
				buf.append(cs[index]);

			arr.add(buf.toString());

			carry = 1;
			for (int i = indices.length - 1; i >= 0; i--) {
				if (carry == 0)
					break;

				indices[i] += carry;
				carry = 0;

				if (indices[i] == cs.length) {
					carry = 1;
					indices[i] = 0;
				}
			}
		} while (carry != 1);

		return arr;
	}

	class Structure {

		private String path;
		private int row, col;

		public Structure(String path, int row, int col) {
			super();
			this.path = path;
			this.row = row;
			this.col = col;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		public int getRow() {
			return row;
		}

		public void setRow(int row) {
			this.row = row;
		}

		public int getCol() {
			return col;
		}

		public void setCol(int col) {
			this.col = col;
		}

	}

	class Coordinates {
		private Integer row;
		private Integer col;

		public Coordinates(Integer row, Integer col) {
			this.row = row;
			this.col = col;
		}

		public Integer getRow() {
			return row;
		}

		public void setRow(Integer row) {
			this.row = row;
		}

		public Integer getCol() {
			return col;
		}

		public void setCol(Integer col) {
			this.col = col;
		}

		@Override
		public boolean equals(Object obj) {
			Coordinates coord = (Coordinates) obj;
			return this.col == coord.getCol() && this.row == coord.getRow();
		}

		@Override
		public String toString() {
			return String.format("%s,%s", this.row, this.col);
		}
	}

	@Test
	public void test() {
		restoreOldOut();
		solution();
	}

}
