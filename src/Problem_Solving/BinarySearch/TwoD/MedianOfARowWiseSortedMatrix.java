package Problem_Solving.BinarySearch.TwoD;

public class MedianOfARowWiseSortedMatrix {

	public static void main(String a[])	{
		int grid[][] = {{1,1,3,3,4}};
		System.out.println(matrixMedian(grid));
	}

	// Working
	public static int matrixMedian(int[][] grid) {
		int min = 9999999;
		int max = -1;

		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				int tmp = grid[i][j];
				max = tmp > max ? tmp : max;
				min = tmp < min ? tmp : min;
			}
		}

		int st = min, end = max;
		int ans = -1;
		int median = ((grid.length*grid[0].length)/2)+1;
		while(st <= end) {
			int mid = st + (end-st)/2;
			int count = countFrq(grid, mid);
			if(count >= median) {
				end = mid-1;
				ans = mid;
			} else {
				st = mid+1;
			}
		}
		return ans;
	}

	static int countFrq(int[][] grid, int target) {
		int count = 0;
		for(int i=0; i<grid.length; i++) {
			int st = 0;
			int end = grid[0].length-1;
			int c1 = -1;
			while(st <= end) {
				int mid = st + (end-st)/2;
				if(grid[i][mid] <= target) {
					c1 = mid;
					st = mid + 1;
				} else {
					end = mid-1;
				}
			}
			count = c1>=0 ? count+c1+1 : count;
		}
		return count;
	}

	//    static int countFrq(int[][] grid, int mid) {
	//        int count = 0;
	//        for(int i=0; i<grid.length; i++) {
	//            for(int j=0; j<grid[0].length; j++) {
	//                int tmp = grid[i][j];
	//                if(tmp <= mid)
	//                    count++;
	//            }
	//        }
	//        return count;
	//    }

}
