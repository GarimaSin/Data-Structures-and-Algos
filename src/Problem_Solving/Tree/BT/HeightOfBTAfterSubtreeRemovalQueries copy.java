package Problem_Solving.Tree.BT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


// Working: 38/40 TLE
// https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/description/
// Mine
public class HeightOfBTAfterSubtreeRemovalQueries {

	public static void main(String[] args) {
		TreeNode root = null;
		Integer[] a1 = {5,3,9,2,4,8,10,1,null,null,null,6,null,null,null,null,null,null,7};
		ConstructTreeFromAnArray tree = new ConstructTreeFromAnArray();
		root = tree.contstructTree(a1, root);
		tree.levelOrder(root);

		int[] queries = {4};
		HeightOfBTAfterSubtreeRemovalQueries o = new HeightOfBTAfterSubtreeRemovalQueries();
		System.out.println(o.treeQueries(root, queries));

	}

	HashMap<Integer, NodeStatus> map = new HashMap<>();
	HashMap<Integer, List<Integer>> lev = new HashMap<>();
	public int[] treeQueries(TreeNode root, int[] queries) {
		findHeight(root, 0);
		int[] ans = new int[queries.length];

		int k = 0;
		for(int i: queries) {
			NodeStatus st = map.get(i);
			int lvl = st.level;
			int maxHt = -1;
			int elem = 0;
			for(int j: lev.get(lvl)) {
				if(j != i) {
					if(maxHt < map.get(j).height) {
						maxHt = map.get(j).height;
						elem = j;
					}
				}
			}
			if(maxHt == -1)
				ans[k] = st.level -1;
			else {
				NodeStatus tmp = map.get(elem);
				ans[k] = tmp.height + tmp.level;
			}
			k++;
		}
		return ans;
	}


	int max = 0;
	public int findHeight(TreeNode root, int level) {
		if(root == null)
			return -1;

		int left = findHeight(root.left, level+1);
		int right = findHeight(root.right, level+1);

		int tmp = Math.max(left, right) + 1;
		map.put(root.val, new NodeStatus(tmp, level));
		addToList(root.val, level);

		max = Math.max(max, tmp);
		return tmp;
	}

	public void addToList(int val, int level) {
		if(lev.containsKey(level)) {
			List<Integer> list = lev.get(level);
			list.add(val);
		} else {
			List<Integer> list = new ArrayList<>();
			list.add(val);
			lev.put(level, list);
		}
	}

	class NodeStatus {
		int height;
		int level;

		NodeStatus(int h, int l) {
			this.height = h;
			this.level = l;
		}
	}

}
