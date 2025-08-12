package Problem_Solving.Array.Pepcoding;

public class PartitionArrayIntoDisjointIntervals {

	// ~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~~
	//Time = O(n), space = O(1), Working
	public static int partitionDisjoint(int[] arr) {
		int leftMax = arr[0];
		int greater = arr[0];
		int ans = 0;

		for (int i = 1; i < arr.length ; i++) {
			if (arr[i] > greater) {
				greater = arr[i];
			} else if (arr[i] < leftMax) {
				leftMax = greater;
				ans = i;
			}
		}
		return ans + 1;
	}
	
	//Time = O(n), space = O(n), Working
	public int partitionDisjoint2(int[] nums) {
        int N = nums.length;
        int[] maxLeft = new int[N];
        int[] minRight = new int[N];
        
        maxLeft[0] = nums[0];
        minRight[N - 1] = nums[N - 1];

        for (int i = 1; i < N; ++i) {
            maxLeft[i] = Math.max(maxLeft[i - 1], nums[i]);
        }

        for (int i = N - 2; i >= 0; --i) {
            minRight[i] = Math.min(minRight[i + 1], nums[i]);
        }

        for (int i = 1; i < N; ++i) {
            if (maxLeft[i - 1] <= minRight[i]) {
                return i;
            }
        }
        return -1;
    }

	// ~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
	public static void main(String[] args) {
		int[] arr = {5,0,3,8,6};
		int len = partitionDisjoint(arr);
		System.out.println(len);
	}
}
