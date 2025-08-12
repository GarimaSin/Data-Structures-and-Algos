package Problem_Solving.Tree.BT;

public class MinFlipsInBTToGetResult {

	public static void main(String[] args) {
		TreeNode root = null;
		Integer[] a1 = {4,3,4,5,5,4,5,null,5,null,5,3,5,null,5,null,4,4,null,3,5,4,null,2,null,5,5,2,0,5,2,5,null,5,1,5,5,1,null,0,null,5,5,null,null,null,0,1,5,null,1,null,5,null,null,5,null,5,null,null,null,null,null,5,null,null,0,null,null,null,null,null,1,null,null,0,null,5,null,5,null,5,null,null,null,null,null,null,null,null,1,0,null,null,1,null,null,null,null,null,null};
		ConstructTreeFromAnArray tree = new ConstructTreeFromAnArray();
		root = tree.contstructTree(a1, root);
		tree.levelOrder(root);
		MinFlipsInBTToGetResult o = new MinFlipsInBTToGetResult();
		boolean result = false;
		System.out.println(o.minimumFlips(root, result));
	}
	
	// 2 = or, 3 = and, 4 = xor, 5 = !
	public int minimumFlips(TreeNode root, boolean result) {
		Boolean left = minFlips(root.left, result);
        Boolean right = minFlips(root.right, result);
        
        if(left == null || right == null) {
        	if(root.val == 5) {
        		if(left != null) {
        			if(left.equals(result))
        				return 1;
        			else 
        				return 0;
        		}
        		else if(right != null) {
        			if(right.equals(result))
        				return 1;
        			else 
        				return 0;
        		}
        	}
        }
        
        if((root.val == 2 && result) || root.val == 3 && !result) {
        	if(!left.equals(result) && !right.equals(result))
        		return 1;
        	else 
        		return 0;
        }
        
        if((root.val == 2 && !result) || root.val == 3 && result) {
        	if(!left.equals(result) && !right.equals(result))
        		return 2;
        	else if (left.equals(result) || right.equals(result)) 
        		return 1;
        	else 
        		return 0;
        }
        if(root.val == 4) {
    		if(left.equals(right)) {
    			return (!result) ? 0 : 1;
    		} else {
    			return (result) ? 0 : 1;
    		}
        }
		return 0;
    }
	
	public Boolean minFlips(TreeNode root, boolean result) {
		if(root == null)
			return null;
		
        if(root.left == null && root.right == null)
        	return (root.val == 1) ? true : false;
        
        Boolean left = minFlips(root.left, result);
        Boolean right = minFlips(root.right, result);
        boolean ans = false;
        
        if(root.val == 2)
        	ans = left || right;
        
        if(root.val == 3)
        	ans = left && right;
        
        if(root.val == 4)
        	ans = left ^ right;
        
        if(root.val == 5) {
        	if(left == null)
        		return !right;
        	if(right == null)
        		return !left;
        }
        return ans;
    }
}