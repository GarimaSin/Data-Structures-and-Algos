package InterviewExperience.Microsoft;

public class SkillSet {

	static int[] parent;
	static int[] rank;

	public static int equationsPossible(int[] T, int[] A) {
		parent = new int[T.length];
		rank = new int[T.length];
		for (int i = 0; i < T.length; ++i) {
			parent[i] = i;
			rank[i] = 1;					
		}
		for (int i = 0; i < T.length; ++i) {
			union(i, T[i]);
		}
		for (int i = 0; i < A.length; i++) {
			System.out.println(rank[parent[A[i]]]);
		}
		return 0;
	}

	public static void union(int x, int y) {
		int lx = find(x);
		int ly = find(y);
		if (lx != ly) {
			if (rank[lx] > rank[ly]) {
				parent[ly] = lx;
			} else if (rank[lx] < rank[ly]) {
				parent[lx] = ly;
			} else {
				parent[lx] = ly;
				rank[ly]++;
			}
		}
	}

	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		int temp = find(parent[x]);
		parent[x] = temp;
		return temp;
	}
	
	public static void main(String[] args) {
		int T[]= {0,3,0,0,5,0,5};
		int A[]= {4,2,6,1,0};
		equationsPossible(T, A);
	}
}