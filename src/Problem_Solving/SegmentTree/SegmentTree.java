package Problem_Solving.SegmentTree;

public class SegmentTree {

	private static Node buildTree(int[] nums, int start, int end) {
		Node rt = null;
		while(start <= end) {
			if(start == end)
				return new Node(start, end, nums[start]);
			
			int mid = start + (end - start)/2;
			Node left = buildTree(nums, start, mid);
			Node right = buildTree(nums, mid+1, end);
			Node root = new Node(start, end, left.sum+right.sum);
			root.left = left;
			root.right = right;
			rt = root;
			return root;
		}
		return rt;
	}
	
	static void updateHelper(Node root, int pos, int val) {
		if (root.start == root.end) {					//imp to check start == end => reached last node
            root.sum = val;
        } else {
            // parent nodes across the path
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid) {

                updateHelper(root.left, pos, val);
            } else {
                updateHelper(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
	}
	
	public static int sumRangeHelper(Node root, int start, int end) {
		// if you found out the node that matches your search return its value
        if (root.start == start && root.end == end ) {
            return root.sum;
        } else {

            int mid = root.start + (root.end - root.start) / 2; // overflow conditions
            if (end <= mid) {
                // move left
                return sumRangeHelper(root.left, start, end);
            } else if (start >= mid+1) {
                // move right
                return sumRangeHelper(root.right, start, end);
            }  else {
                // consider both nodes
                return  sumRangeHelper(root.left, start, mid) + sumRangeHelper(root.right, mid+1, end) ;
            }
        }
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4};
		Node root = buildTree(arr, 0, arr.length-1);
//		updateHelper(root, 2, 5);
		int ans = sumRangeHelper(root, 1, 2);
		System.out.println(ans);
	}
	
	static class Node {
		int start;
		int end;
		int sum;
		Node left;
		Node right;
		
		Node(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		Node(int start, int end, int sum) {
			this.start = start;
			this.end = end;
			this.sum = sum;
		}
	}
}
