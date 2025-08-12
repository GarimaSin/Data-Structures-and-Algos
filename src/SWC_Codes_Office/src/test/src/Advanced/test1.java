package test.src.Advanced;

public class test1 {

	public static void main(String[] args) {
		int[][] array= {
				{1, 5},
				{3, 8},
				{2, 1},
				{5, 6} };

				java.util.Arrays.sort(array, new java.util.Comparator<int[]>() {
				    public int compare(int[] a, int[] b) {
				        return Integer.compare(a[0], b[0]);
				    }
				});
				
				for(int i=0; i<4;i++){
					System.out.print(array[i][0]+"  "+array[i][1]);
					System.out.println(" ");
				}
	}

}
