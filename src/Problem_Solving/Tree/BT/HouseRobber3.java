package Problem_Solving.Tree.BT;

public class HouseRobber3 {

	public static void main(String[] args) {
		TreeNode root = null;
		Integer[] a1 = {3,2,3,null,3,null,1};
		ConstructTreeFromAnArray tree = new ConstructTreeFromAnArray();
		root = tree.contstructTree(a1, root);
		tree.levelOrder(root);
		HouseRobber3 o = new HouseRobber3();
		System.out.println(o.rob(root));
	}
	
	public static int HouseRobber (TreeNode root) {
		HousePair res = findMax(root);
		return Math.max(res.rob, res.notRob);
	} 

	//	// 1 = rob, 0 = skip, not working
		public int rob(TreeNode root) {
			findMax1(root, 1, 0);
			max1 = max;
			max = 0;
			findMax1(root, 0, 0);
			max2 = max;
	        return Math.max(max1, max2);
	    }
	                                                                                     
	    int max1 = 0;
	    static int max = 0;
	    int max2 = 0;
	    
	    void findMax1(TreeNode root, int robbed, int sum) {
	        if(root == null)
	            return;
	
	        if(root.left == null && root.right == null) {
	        	if(robbed == 1)
	        		sum = sum + root.val;
	        	max = Math.max(max, sum);
	        	return;
	        }
	        
	    	if(robbed == 1) {
	    		findMax1(root.left, 0, sum + root.val);
	            findMax1(root.right, 0, sum + root.val);
	    	} else {
	    		findMax1(root.left, 0, sum);
	            findMax1(root.right, 0, sum);
	            findMax1(root.left, 1, sum);
	            findMax1(root.right, 1, sum);
	    	}
	    }


	//Working
	public static HousePair findMax(TreeNode root) { 
		if(root == null)
            return new HousePair();
		
		if(root.left == null && root.right == null)
            return new HousePair(root.val, 0);
		
		HousePair left = findMax(root.left);
		HousePair right = findMax(root.right);
		
		int with = left.notRob + right.notRob + root.val;
		int wo = Math.max(left.rob, left.notRob) + Math.max(right.rob, right.notRob);
		
		int tmp = Math.max(with, wo);
		max = Math.max(tmp, Math.max(max, root.val));
		
		return new HousePair(with, wo);
	}

	
	static class HousePair {
		int rob = 0;
		int notRob = 0;
		
		HousePair(){}
		
		HousePair(int r, int n){
			this.rob = r;
			this.notRob = n;
		}
	}


	//    HouseRob findMax(TreeNode root) {
	//        if(root == null)
	//            return null;
	//
	//        if(root.left == null && root.right == null)
	//            return new HouseRob(-1, root.val, 0);
	//        
	//        HouseRob lSkipped = null, rSkipped = null, lRobbed = null, rRobbed = null;
	//        lSkipped = findMax(root.left);
	//    	rSkipped = findMax(root.right);
	//        
	//    	if(!robbed) { 
	//        	lRobbed = findMax(root.left);
	//            rRobbed = findMax(root.right);
	//        }
	//        
	//        int lwith = 0, lwo = 0, rwith = 0, rwo = 0;
	//        if(lRobbed != null) {
	//            lwith = lRobbed.with;
	//            lwo = lRobbed.without;
	//        }
	//
	//        if(rRobbed != null) {
	//            rwith = rRobbed.with;
	//            rwo = rRobbed.without;
	//        }
	//        
	//        int tmpW = lwith + rwith;
	//        int tmpWo = lwo + rwo;
	//
	//        int tmp = Math.max(tmpWo+root.val, tmpW);
	//        max = Math.max(max, tmp);
	//
	//        return new HouseRob(tmpWo+root.val, tmpW);
	//    }
	//
	//
	//
	//    class HouseRob {
	//    	int robbed;  // 
	//        int with;
	//        int without;
	//
	//        HouseRob(int a, int b) {
	//            this.with = a;
	//            this.without = b;
	//        }
	//    }
}
