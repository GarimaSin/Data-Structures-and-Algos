package Problem_Solving.Graph;

public class MostStonesRemovedWithSameRowOrCol {

	public static int removeStones(int[][] stones) {
		int n = stones.length;
		int[] parent = new int[n];
		int[] rank = new int[n];
		for(int i=0; i<parent.length; i++) {
			parent[i] = i;
			rank[i] = 1;
		}

		UnionFind uf = new UnionFind(n);
		/* For every stone, check all other stones, if they belong to same row or column */
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
					uf.union(i, j, parent, rank);
				}
			}
		}
		/* The no. of stones that can be removed is unique stone parents  */
		return uf.count;
	}

	public static void main(String[] args) {
		int[][] stones = {{0,0},{0,2},{1,1},{2,0},{2,2}};
		removeStones(stones);
	}
	
	static class UnionFind {
		public int[] rank;
	    public int[] root;
	    public int count;

	    public UnionFind(int n) {
	        rank = new int[n];
	        root = new int[n];
	        count = 0;
	        for (int i = 0; i < n; i++) {
	            rank[i] = 1;
	            root[i] = i;
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

		boolean union(int x, int y, int[] parent, int[] rank) {
			int lx = find(x, parent);
			int ly = find(y, parent);
			if(lx != ly) {
				if(rank[lx] > rank[ly]) {			
					parent[ly] = lx;					//when smaller is merged into larger, rank doesn't change
				} else if (rank[lx] < rank[ly]) {
					parent[lx] = ly;
				} else {
					parent[lx] = ly;
					rank[ly]++;					//rank only changes when both are of same rank
				}
				count++;
				return true;
			}
			return false;
		}
	}

}

