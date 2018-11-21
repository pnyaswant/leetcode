package com.yash.graph;

public class GraphSubgraphProduct {

	public static void main(String[] args) {
		int[] graph = new int[] { 2, 5, 7, 83, 6, 3, 56, 6 };

		boolean[][] am = new boolean[][] { { false, true, true, false, false, false, false, false },
				{ true, false, true, false, false, false, false, false },
				{ true, true, false, false, false, false, false, false },
				{ false, false, false, false, true, false, true, true },
				{ false, false, false, true, false, false, true, true },
				{ false, false, false, false, false, false, false, false },
				{ false, false, false, true, true, false, false, true },
				{ false, false, false, true, true, false, true, false } };

		int res[] = new int[graph.length];
		boolean visited[] = new boolean[graph.length];
		for (int i = 0; i < am.length; i++) {
			if (visited[i]) {
				continue;
			}
			int even = 1;
			int odd = 1;
			boolean evenCame = false;
			boolean oddCame = false;
			for (int j = 0; j < am[0].length; j++) {
				if (i != j && !am[i][j]) {
					continue;
				}
				visited[j] = true;
				res[j] += graph[j];
				if (graph[j] % 2 == 0) {
					evenCame = true;
					even *= graph[j];
				} else {
					oddCame = true;
					odd *= graph[j];
				}
			}
			for (int j = 0; j < am[0].length; j++) {
				if (i != j && !am[i][j]) {
					continue;
				}
				res[j] += (oddCame ? odd : 0) + (evenCame ? even : 0);

			}
		}
		
		System.out.println(res);
	}

}
