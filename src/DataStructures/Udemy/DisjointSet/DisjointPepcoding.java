package DataStructures.Udemy.DisjointSet;

public class DisjointPepcoding {
	
	public static void main(String[] args) {
		
	}
	
	int find(int x, int[] parent) {
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
			return true;
		}
		return false;
	}
}