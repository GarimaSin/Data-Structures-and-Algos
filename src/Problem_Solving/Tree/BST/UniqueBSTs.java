package Problem_Solving.Tree.BST;

import java.util.ArrayList;
import java.util.List;

import Problem_Solving.Tree.BT.TreeNode;

public class UniqueBSTs {

	public static void main(String[] args) {

	}

	public List<TreeNode> generateTrees(int n) {
		return generateBSTs(1, n);
	}
	

	List<TreeNode> generateBSTs(int start, int end) {
		List<TreeNode> currentBSTs = new ArrayList<>();
		if (start > end) {
			currentBSTs.add(null);
			return currentBSTs;
		}

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
		return currentBSTs;
	}

}
