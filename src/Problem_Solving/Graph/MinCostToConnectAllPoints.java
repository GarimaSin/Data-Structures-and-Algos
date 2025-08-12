package Problem_Solving.Graph;

import java.util.ArrayList;
import java.util.Collections;

public class MinCostToConnectAllPoints {

	public static int minCostConnectPoints(int[][] points) {
		int n = points.length;
		ArrayList<int[]> allEdges = new ArrayList<>();

		// Storing all edges of our complete graph.
		for (int currPt = 0; currPt < n; ++currPt) {
			for (int nextPt = currPt + 1; nextPt < n; ++nextPt) {
				int weight = Math.abs(points[currPt][0] - points[nextPt][0]) + 
						Math.abs(points[currPt][1] - points[nextPt][1]);

				int[] currEdge = {weight, currPt, nextPt};
				allEdges.add(currEdge);
			}
		}

		// Sort all edges in increasing order.
		Collections.sort(allEdges, (a, b) -> Integer.compare(a[0], b[0]));   

		UnionFind uf = new UnionFind(n);
		int mstCost = 0;
		int edgesUsed = 0;

		for (int i = 0; i < allEdges.size() && edgesUsed < n - 1; ++i) {
			int node1 = allEdges.get(i)[1];
			int node2 = allEdges.get(i)[2];
			int weight = allEdges.get(i)[0];

			if (uf.union(node1, node2)) {
				mstCost += weight;
				edgesUsed++;
			}
		}
		return mstCost;
	}
	
	public static void main(String[] args) {
		int points[][] = {{0,0},{2,2},{3,10},{5,2},{7,0}};
		System.out.println(minCostConnectPoints(points));
	}
}

class UnionFind {
	int n = 0;
	int[] parent;
	int[] rank;
	
	UnionFind(int n) {
		this.n = n;
		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}
	
	
	boolean union(int x, int y) {
		int p1 = find(x);
		int p2 = find(y);
		
		if(p1 != p2) {
			if(rank[p1] > rank[p2]) {
				parent[p2] = p1;
			} else if(rank[p2] > rank[p1]) {
				parent[p1] = p2;
			} else {
				parent[p1] = p2;
				rank[p2]++;
			}
			return true;
		}
		return false;
	}


	private int find(int x) {
		if(parent[x] == x)
			return x;
		
		int p = find(parent[x]);
		parent[x] = p;
		return p;
	}
}
