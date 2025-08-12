package Problem_Solving.BinarySearch.TwoD;

public class Search2DMatrix {

	public static void main(String[] args) {
		int matrix[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}}; 
		int target = 3;
		System.out.println(searchMatrix(matrix, target));
		System.out.println(searchMatrix1(matrix, target));
	}
	
	
	// Working
	public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        int st = 0;
        int end = (col*row)-1;
        
        while(st <= end) {
        	int mid = (st + end)/2;
        	int r = mid / col;
        	int c = mid % col;
        	if(matrix[r][c] == target)
        		return true;
        	if(matrix[r][c] > target) {
        		end = mid-1;
        	} else if(matrix[r][c] < target) {
        		st = mid+1;
        	}
        }
        return false; 
    }
	
	
	// Working
	public static boolean searchMatrix1(int[][] mat, int target) {
        int i = 0, j = mat[0].length-1;
        while(i <mat.length && j >=0) {
            if(mat[i][j] == target) {
                return true;
            } else if(mat[i][j] > target)
                j--;
            else
                i++;
        }
        return false;
    }
}
