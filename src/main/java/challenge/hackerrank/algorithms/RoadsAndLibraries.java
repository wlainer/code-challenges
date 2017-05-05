package challenge.hackerrank.algorithms;

import java.util.Scanner;
import java.util.Vector;

import org.junit.Test;

import challenge.TestBase;

public class RoadsAndLibraries extends TestBase {

	public void solution() {
		Scanner s = getScanner();

		int N = s.nextInt();

		for (; N >= 0; N--) {
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
			int sum = 0;
			for (int i = 1; i <= nodes; i++) {
				if (visited[i] == false) {
					dfs(visited, adj, i, sum);
					distinct++;
				}
			}
			System.out.println();
		}
	}

	private int dfs(boolean[] visited, Vector<Integer>[] adj, int s, int sum) {
		if (sum == 0)
			sum = 1;

		visited[s] = true;
		for (int i = 0; i < adj[s].size(); i++) {
			if (visited[adj[s].get(i)] == false) {
				return sum + 1 + dfs(visited, adj, adj[s].get(i), sum);
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
