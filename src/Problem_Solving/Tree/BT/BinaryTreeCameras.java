package Problem_Solving.Tree.BT;

public class BinaryTreeCameras {

	public static void main(String[] args) {
		TreeNode root = null;
		Integer[] a1 = {0,null,0,null,0,null,0};
		ConstructTreeFromAnArray tree = new ConstructTreeFromAnArray();
		root = tree.contstructTree(a1, root);
		tree.levelOrder(root);
		BinaryTreeCameras o = new BinaryTreeCameras();
		o.minCameraCover(root);
	}
	
	int cameras = 0;
    public int minCameraCover(TreeNode root) {
        if(root.left == null && root.right == null)
            return 1;
        NodeStatus s = minCamera(root);
        if(s.status == -1)
            return cameras+1;
        return cameras;
    }

    public NodeStatus minCamera(TreeNode root) {
        if(root == null)
            return new NodeStatus(0, 99999);

        if(root.left == null && root.right == null)
            return new NodeStatus(-1, 99999);
        
        NodeStatus left = minCamera(root.left);
        NodeStatus right = minCamera(root.right);
        int min = Math.min(left.count, right.count);

        if(left.status == -1 || right.status == -1) {
            cameras++;
            cameras = Math.min(min, cameras);
            return new NodeStatus(1, min+1);
        }

        if(left.status == 1 || right.status == 1) 
            return new NodeStatus(0, min);  
        
        if(left.status == 0 && right.status == 0) 
            return new NodeStatus(-1, min);

        return new NodeStatus(-1, min);
    }

    class NodeStatus {
        int status;
        int count;

        public NodeStatus(int s, int c) {
            this.status = s;
            this.count = c;
        }
    }
}
