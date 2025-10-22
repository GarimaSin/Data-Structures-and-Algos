package Problem_Solving.Tree.BST;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Problem_Solving.Tree.BT.TreeNode;

public class MergeBSTstoCreateSingleBST {

	public static TreeNode canMerge(List<TreeNode> trees) {
		// Map from root value to the TreeNode
		Map<Integer, TreeNode> valToNode = new HashMap<>();
		// Count how many times each value appears (as root or child)
		Map<Integer, Integer> count = new HashMap<>();

		// 1. Populate maps
		for (TreeNode tree : trees) {
			valToNode.put(tree.val, tree);
			count.put(tree.val, count.getOrDefault(tree.val, 0) + 1);
			if (tree.left != null) {
				count.put(tree.left.val, count.getOrDefault(tree.left.val, 0) + 1);
			}
			if (tree.right != null) {
				count.put(tree.right.val, count.getOrDefault(tree.right.val, 0) + 1);
			}
		}

		// 2. Find the unique global root (appears only once = not a child elsewhere)
		TreeNode root = null;
		for (TreeNode tree : trees) {
			if (count.get(tree.val) == 1) {
				root = tree;
				break;
			}
		}
		if (root == null) return null;

		// 3. Merge via DFS
		if (!dfsMerge(root, null, null, valToNode)) return null;

		// 4. After merging, only the global root should remain in the map
		if (valToNode.size() != 1) return null;
		return root;
	}

	private static boolean dfsMerge(TreeNode node, TreeNode min, TreeNode max,
			Map<Integer, TreeNode> valToNode) {
		if (node == null) return true;

		int v = node.val;
		// BST property check
		if (min != null && v <= min.val) return false;
		if (max != null && v >= max.val) return false;

		// If node is a leaf and its value matches another tree root → merge
		if (node.left == null && node.right == null &&
				valToNode.containsKey(v) && valToNode.get(v) != node) {
			TreeNode subtree = valToNode.get(v);
			node.left = subtree.left;
			node.right = subtree.right;
			valToNode.remove(v);
		}

		return dfsMerge(node.left, min, node, valToNode) &&
				dfsMerge(node.right, node, max, valToNode);
	}

	// Helper: print inorder traversal (for validation)
	public static void printInorder(TreeNode root) {
		if (root == null) return;
		printInorder(root.left);
		System.out.print(root.val + " ");
		printInorder(root.right);
	}

	public static void main(String[] args) {

		// Example test case: [[2,1],[3,2,5],[5,4]]
		TreeNode t1 = new TreeNode(2);
		t1.left = new TreeNode(1);

		TreeNode t2 = new TreeNode(3);
		t2.left = new TreeNode(2);
		t2.right = new TreeNode(5);

		TreeNode t3 = new TreeNode(5);
		t3.left = new TreeNode(4);

		List<TreeNode> trees = Arrays.asList(t1, t2, t3);

		TreeNode merged = canMerge(trees);

		if (merged == null) {
			System.out.println("Cannot merge into a valid BST");
		} else {
			System.out.print("Inorder traversal of merged BST: ");
			printInorder(merged);
			System.out.println();
		}
	}
}
