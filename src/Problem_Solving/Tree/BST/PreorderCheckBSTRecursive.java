package Problem_Solving.Tree.BST;

public class PreorderCheckBSTRecursive {
	
	
	// Working
	static int index; // global index
    static void buildBSThelper(int n, int[] pre, int min, int max) {
        if (index >= n) 
        	return;

        int val = pre[index];

        // If value lies within range, use it
        if (val >= min && val <= max) {
            index++; // use this value

            // Recurse for left and right subtrees
            buildBSThelper(n, pre, min, val - 1);
            buildBSThelper(n, pre, val + 1, max);
        }
    }

    static boolean canRepresentBST(int[] arr) {
        index = 0; // reset before processing
        buildBSThelper(arr.length, arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return index == arr.length;
    }

    public static void main(String[] args) {
    	int[] pre1 = {10, 20, 5};
        int[] pre2 = {8, 5, 1, 7, 10, 12};

        System.out.println(canRepresentBST(pre1)); // true
        System.out.println(canRepresentBST(pre2)); // false
    }
}