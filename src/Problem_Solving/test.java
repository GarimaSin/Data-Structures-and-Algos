package Problem_Solving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test {

	public static void main(String[] args) {
		int n = 11, firstPlayer = 8, secondPlayer = 10;
		int ans[] = earliestAndLatest(n, firstPlayer, secondPlayer);
		System.out.println(ans[0] + " "+ans[1]);
	}


	public static int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
		ArrayList<Integer> inp = new ArrayList<>();
		for(int i=1; i<=n; i++)
			inp.add(i);

		score s = findScore(inp, firstPlayer, secondPlayer, 0, inp.size()-1, new ArrayList<Integer>());
		return new int[]{s.min, s.max};
	}


	static score findScore(ArrayList<Integer> inp, int first, int second, int i, int j, ArrayList<Integer> tmp) {
		if((inp.get(i).equals(first) && inp.get(j).equals(second)) || inp.get(i).equals(second) && inp.get(j).equals(first))
			return new score(1, 1);

		if(i == j) {
			int n = inp.get(i);
			tmp.add(n);
			inp = null;
			Collections.sort(tmp);
			score a = findScore(tmp, first, second, 0, tmp.size()-1, new ArrayList<Integer>());
			tmp.remove(Integer.valueOf(n));
			return new score(a.min+1, a.max+1);
		}

		if(i > j) {
			inp = null;
			Collections.sort(tmp);
			score a = findScore(tmp, first, second, 0, tmp.size()-1, new ArrayList<Integer>());
			return new score(a.min+1, a.max+1);
		}

		if(inp.size() == 0)
			return new score(99999,-999999);

		score ans1 = null, ans2 = null, ans3 = null;

		if(inp.get(i).equals(first) || inp.get(i).equals(second)) {
			tmp.add(inp.get(i));
			ans3 =  findScore(inp, first, second, i+1, j-1, tmp);
			tmp.remove(tmp.size()-1);
		}
		else if(inp.get(j).equals(first) || inp.get(j).equals(second)) {
			tmp.add(inp.get(j));
			ans3 =  findScore(inp, first, second, i+1, j-1, tmp);
			tmp.remove(tmp.size()-1);
		} else {
			tmp.add(inp.get(i));
			ans1 = findScore(inp, first, second, i+1, j-1, tmp);
			tmp.remove(tmp.size()-1);

			tmp.add(inp.get(j));
			ans2 = findScore(inp, first, second, i+1, j-1, tmp);
			tmp.remove(tmp.size()-1);
		}

		List<score> results = new ArrayList<>();
		if (ans1 != null) results.add(ans1);
		if (ans2 != null) results.add(ans2);
		if (ans3 != null) results.add(ans3);

		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (score s : results) {
			min = Math.min(min, s.min);
			max = Math.max(max, s.max);
		}
		return new score(min, max);
	}


	static class score {
		int min;
		int max;


		score(int a, int b) {
			this.min = a;
			this.max = b;
		}
	}


	static int findMinScore(ArrayList<Integer> inp, int first, int second, int i, int j, ArrayList<Integer> tmp) {
		if(i == j) {
			tmp.add(inp.get(i));
			inp = null;
			int a = 1 + findMinScore(tmp, first, second, 0, tmp.size()-1, new ArrayList<Integer>());
			tmp.remove(tmp.size()-1);
			return a;
		}

		if(i > j) {
			inp = null;
			int a = 1 + findMinScore(tmp, first, second, 0, tmp.size()-1, new ArrayList<Integer>());
			return a;
		}

		if(inp.size() == 0)
			return 99999;

		int ans = 99999;

		if((inp.get(i).equals(first) && inp.get(j).equals(second)) || inp.get(i).equals(second) && inp.get(j).equals(first))
			return 1;

		else if(inp.get(i).equals(first) || inp.get(i).equals(second)) {
			tmp.add(inp.get(i));
			ans = Math.min(ans, findMinScore(inp, first, second, i+1, j-1, tmp));
			tmp.remove(tmp.size()-1);
		}
		else if(inp.get(j).equals(first) || inp.get(j).equals(second)) {
			tmp.add(inp.get(j));
			ans = Math.min(ans, findMinScore(inp, first, second, i+1, j-1, tmp));
			tmp.remove(tmp.size()-1);
		} else {
			tmp.add(inp.get(i));
			ans = Math.min(ans, findMinScore(inp, first, second, i+1, j-1, tmp));
			tmp.remove(tmp.size()-1);

			tmp.add(inp.get(j));
			ans = Math.min(ans, findMinScore(inp, first, second, i+1, j-1, tmp));
			tmp.remove(tmp.size()-1);
		}
		return ans;
	}


}
