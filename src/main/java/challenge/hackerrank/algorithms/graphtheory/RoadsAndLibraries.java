package challenge.hackerrank.algorithms.graphtheory;

import java.util.Scanner;
import java.util.Vector;

import org.junit.Test;

import challenge.TestBase;

public class RoadsAndLibraries extends TestBase {
	
	@Override
	protected String getIndexTestCase() {
		return "01";
	}

	public void solution() {
		Scanner s = getScanner();

		int N = s.nextInt();

		for (; N > 0; N--) {
			int nodes = s.nextInt();
			int edges = s.nextInt();

			int costLibrary = s.nextInt();
			int costRoad = s.nextInt();

			Vector<Integer>[] adj = new Vector[nodes + 1];
			for (int i = 0; i < adj.length; i++)
				adj[i] = new Vector<Integer>();
			
			boolean[] visited = new boolean[nodes + 1];

			for (int i = 0; i < edges; i++) {
				int x = s.nextInt();
				int y = s.nextInt();

				adj[x].add(y);
				adj[y].add(x);
			}

			int distinct = 0;
			int sumRoads = 0;
			for (int i = 1; i <= nodes; i++) {
				int sum = 0;
				if (visited[i] == false) {
					sumRoads += dfs(visited, adj, i, sum);
					distinct++;
				}
			}
			
			if (distinct * costLibrary + sumRoads * costRoad < nodes * costLibrary) {
				System.out.println(distinct * costLibrary + sumRoads * costRoad);
			} else {
				System.out.println(nodes * costLibrary);
			}
		}
	}

	private int dfs(boolean[] visited, Vector<Integer>[] adj, int s, int sum) {
		visited[s] = true;
		
		for (int i = 0; i < adj[s].size(); i++) {
			if (visited[adj[s].get(i)] == false) {
				sum++;
				sum = dfs(visited, adj, adj[s].get(i), sum);
			}
			
		}
		return sum;
	 }

	@Test
	public void test() {
		solution();
		
		checkLines();
	}
}
