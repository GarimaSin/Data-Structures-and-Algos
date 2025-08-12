package SWC_Codes_Office.src.test.src.test;

public class rotateMatrix {

	public static void main(String[] args) {
		int[][] array = new int[][] {
		    { 1,2,3 },
		    { 4,5,6 },
		    { 7,8,9 },
		};
//		for(int i=0;i<3;i++){
//			for(int j=0;j<3;j++){
//				System.out.print(array[i][j]);
//			}
//			System.out.println("");
//		}

		int[][] rotated = RotateMatrix(array, 3);
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(rotated[i][j]);
			}
			System.out.println("");
		}

	}
	
	static int[][] RotateMatrix(int[][] matrix, int n) {
	    int[][] ret = new int[n][n];

	    for (int i = 0; i < n; ++i) {
	        for (int j = 0; j < n; ++j) {
	            ret[i][j] = matrix[n - j - 1][i];
	        }
	    }
	    return ret;
	}
}
