package Problem_Solving.Graph.Pepcoding;

public class RedundantConnections {
	public static void main(String[] args) {
		int[][] pos = {{1,2},{1,3},{2,3}};
		int[] ans = findRedundantConnection(pos);
		System.out.println(ans[0] + " " + ans[1]);
	}

	public static int[] findRedundantConnection(int[][] edges) {
		int[] parent = new int[2001];
		for (int i = 0; i < parent.length; i++)
			parent[i] = i;

		for (int[] edge : edges) {
			int f = edge[0], t = edge[1];
			int p1 = find(parent, f);
			int p2 = find(parent, t);
			if (p1 == p2)
				return edge;
			else
				parent[p1] = p2;
		}
		return new int[2];
	}

	private static int find(int[] parent, int f) {
		if (f != parent[f]) {
			parent[f] = find(parent, parent[f]);
		}
		return parent[f];
	}
}
