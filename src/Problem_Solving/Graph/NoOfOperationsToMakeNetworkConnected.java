package Problem_Solving.Graph;

public class NoOfOperationsToMakeNetworkConnected {

	public static int makeConnected(int n, int[][] connections) {
		UnionFind uf = new UnionFind(n);
		int initial_components = n;
	    int extra_edges = 0;
		for (int i = 0; i < connections.length; i++) {
			boolean isNotRedundant = uf.union(connections[i][0], connections[i][1]);
			if(isNotRedundant)
				initial_components--;
			else 
				extra_edges++;
		}
		
		if(initial_components == 1) {
	        return 0;
	    }
	    else {
	        int required_edges = initial_components-1;
	        if(extra_edges >= required_edges) {
	            return required_edges;
	        }
	        else {
	            return -1;
	        }
	    }
	}

	public static void main(String[] args) {
		int n = 5, connections[][] = {{0,1},{0,2},{3,4},{2,3}};
		int ans = makeConnected(n, connections);
		System.out.println(ans);
	}

	static class UnionFind {
		public int[] rank;
		public int count;
		int parent[];

		public UnionFind(int n) {
			rank = new int[n];
			parent = new int[n];
			count = 0;
			for (int i = 0; i < n; i++) {
				rank[i] = 1;
				parent[i] = i;
			}
		}

		static int find(int x, int[] parent) {
			if(parent[x] == x) {
				return x;
			}
			int tmp = find(parent[x], parent);			//recursively assign parent to all x till now
			parent[x] = tmp;
			return tmp;
		}

		boolean union(int x, int y) {
			int px= find(x, parent);
			int py= find(y, parent);

			if(px==py) {
				return false;
			}
			else {
				if(rank[px] > rank[py]) {
					parent[py] = px;
				}
				else if(rank[py] > rank[px]) {
					parent[px] = py;
				}
				else {
					parent[px] = py;
					rank[py]++;
				}
				return true;
			}
		}
	}
}
