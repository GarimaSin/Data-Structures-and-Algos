package Problem_Solving.Backtracking;

import java.util.ArrayList;
import java.util.List;


public class UniqueBSTs {

	public static void main(String[] args) {
		System.out.println(numTrees(4));
		List<TreeNode> ans = generateTrees(3);
		System.out.println(ans.size());
		System.out.println();
		for(TreeNode n: ans)
			System.out.print(n.val+" ");
		System.out.println("_________");
	}

	public static List<TreeNode> generateTrees(int n) {
		return generateBSTs(1, n);
	}

	static List<TreeNode> generateBSTs(int start, int end) {
		List<TreeNode> currentBSTs = new ArrayList<>();
		if (start > end) {
			currentBSTs.add(null);
			return currentBSTs;
		}
		else {
			for(int rootVal = start; rootVal <= end; rootVal ++) {                
				List<TreeNode> leftSubtreeRoots = generateBSTs(start, rootVal - 1);
				List<TreeNode> rightSubtreeRoots = generateBSTs(rootVal + 1, end);

				for(TreeNode leftChild : leftSubtreeRoots) {                    
					for(TreeNode rightChild : rightSubtreeRoots) {
						TreeNode root = new TreeNode(rootVal);
						root.left = leftChild;
						root.right = rightChild;
						currentBSTs.add(root);
					}
				}
			}
		}
		return currentBSTs;
	}

	public static int numTrees(int n) {
		if (n < 3) 
			return n;        

		int[] dp = new int[n+1];

		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 5;

		for (int i = 4;i<=n;i++) {
			for (int j = 0; j<i; j++) {
				dp[i] += dp[j] * dp[i-j-1];
			}
		}
		return dp[n];
	}
}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}

	TreeNode(int val) { 
		this.val = val; 
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}