package Problem_Solving.Tree.BST;

import java.util.LinkedList;
import java.util.Queue;

public class BSTFromLevelOrder {

	static class Pair {
        Node parent;
        int min, max;

        Pair(Node parent, int min, int max) {
            this.parent = parent;
            this.min = min;
            this.max = max;
        }
    }

    public static Node constructBST(int[] levelOrder) {
        if (levelOrder.length == 0) 
        	return null;

        Queue<Pair> q = new LinkedList<>();
        Node root = new Node(levelOrder[0]);
        // Push ranges for left and right children
        q.offer(new Pair(root, Integer.MIN_VALUE, root.val));
        q.offer(new Pair(root, root.val, Integer.MAX_VALUE));

        int i = 1;
        while (i < levelOrder.length && !q.isEmpty()) {
            Pair curr = q.poll();
            int val = levelOrder[i];

            // Check if val fits this position
            if (val > curr.min && val < curr.max) {
                Node node = new Node(val);
                if (val < curr.parent.val) {
                    curr.parent.left = node;
                } else {
                    curr.parent.right = node;
                }

                // Push ranges for left and right children
                q.offer(new Pair(node, curr.min, val));
                q.offer(new Pair(node, val, curr.max));
                i++;
            }
        }
        return root;
    }

    // Inorder traversal → should be sorted if BST is valid
    private static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        int[] levelOrder = {7, 4, 12, 3, 6, 8, 15};

        Node root = constructBST(levelOrder);

        System.out.println("Inorder traversal of constructed BST:");
        inorder(root); // 3 4 6 7 8 12 15
    }
}
