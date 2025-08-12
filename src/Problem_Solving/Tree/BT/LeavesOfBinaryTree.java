package Problem_Solving.Tree.BT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeavesOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = null;
		Integer[] a1 = {1,2,3,4,5};
		ConstructTreeFromAnArray tree = new ConstructTreeFromAnArray();
		root = tree.contstructTree(a1, root);
		tree.levelOrder(root);
		LeavesOfBinaryTree o = new LeavesOfBinaryTree();
		o.findLeavesofBT(root);
		List<List<Integer>> ll = new ArrayList<>();
		
		for (List<Integer> l : map.values())  {
			ll.add(l);
		}
	}
	
	
 //	public List<List<Integer>> findLeaves(TreeNode root) {
//        
//    }

	static HashMap<Integer, List<Integer>> map = new HashMap<>();
    
    public int findLeavesofBT(TreeNode root) {
        if(root == null)
            return 0;

        if(root.left == null && root.right == null) {
        	if(map.get(1) == null) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(root.val);
                map.put(1, list);
            } else {
                List<Integer> list = map.get(1);
                list.add(root.val);
                map.put(1, list);
            }  
            return 1;
        }

        int left = findLeavesofBT(root.left);
        int right = findLeavesofBT(root.right);

        int tmp = Math.max(left, right);
        tmp++;
        if(map.get(tmp) == null) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.val);
            map.put(tmp, list);
        } else {
            List<Integer> list = map.get(tmp);
            list.add(root.val);
            map.put(tmp, list);
        }       
        return tmp;
    }

}
