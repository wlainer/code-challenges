package challenge.redmart.skiing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

import challenge.TestBase;

public class Skiing extends TestBase {

	@Override
	protected String getIndexTestCase() {
		return "02";
	}

	Map<Integer, List<Integer[]>> paths = new HashMap();
	int maxValue = -1;

	public void solution() {
		restoreOldOut();

		Scanner scanner = getScanner();
		String[] size = scanner.nextLine().split(" ");
		int row = Integer.valueOf(size[0]);
		int col = Integer.valueOf(size[1]);

		int[][] map = new int[row][col];

		for (int i = 0; i < row; i++) {
			String[] line = scanner.nextLine().split(" ");
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.valueOf(line[j]);
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				List<Integer> path = new ArrayList<Integer>();
				move(i, j, map, 1, path);
			}
		}

		// priting the values of the path
		int largestDifference = -1;
		int index = 0;
		List<Integer[]> list = paths.get(maxValue);
		for (int i = 0; i < list.size(); i++) {
			Integer[] integers = list.get(i);
			int difference = integers[0] - integers[maxValue - 1];
			largestDifference = Math.max(integers[0] - integers[maxValue - 1], largestDifference);

			if (largestDifference == difference)
				index = i;
		}

		System.out.println(String.format("Length: %s", maxValue));
		System.out.println(String.format("Largest drop: %s", largestDifference));
		for (Integer x : list.get(index)) {
			System.out.print(String.format("%s ", x));
		}
	}

	private int move(int i, int j, int[][] map, int max, List<Integer> path) {

		path.add(map[i][j]);

		// north
		int north = i - 1;
		if (north >= 0 && map[north][j] < map[i][j])
			max = move(north, j, map, ++max, path);

		// south
		int south = i + 1;
		if (south < map[0].length && map[south][j] < map[i][j])
			max = move(south, j, map, ++max, path);

		// west
		int west = j - 1;
		if (west >= 0 && map[i][west] < map[i][j])
			max = move(i, west, map, ++max, path);

		// east
		int east = j + 1;
		if (east < map.length && map[i][east] < map[i][j])
			max = move(i, east, map, ++max, path);

		maxValue = Math.max(max, maxValue);

		// storing paths
		if (max == maxValue) {
			List<Integer[]> list = paths.get(max);
			if (list == null)
				list = new ArrayList<Integer[]>();

			list.add(path.toArray(new Integer[path.size()]));
			paths.put(max, list);
		}

		path.remove(path.size() - 1);
		return max - 1;

	}

	@Test
	public void test() {
		solution();

		checkLines();
	}
}
