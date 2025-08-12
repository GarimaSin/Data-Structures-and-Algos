package Problem_Solving.Graph.Pepcoding;

public class SatisfiabilityOfEqualityEquations {

	public static void main(String[] args) throws Exception {
		String[] arr = {"a==b", "b==c","b!=a"};
		System.out.println(equationsPossible(arr));
	}

	static int[] parent;
	static int[] rank;

	public static boolean equationsPossible(String[] equations) {
		parent = new int[26];
		rank = new int[26];
		for (int i = 0; i < 26; ++i) {
			parent[i] = i;
			rank[i] = 1;					//initialize rank as 1.
		}

		for (String equation : equations) {
			if (equation.charAt(1) == '=') {
				union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
			}
		}

		for (String equation : equations) {
			if (equation.charAt(1) == '!' && find(equation.charAt(0) - 'a') == find(equation.charAt(3) - 'a')) {
				return false;
			}
		}
		return true;
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
}
