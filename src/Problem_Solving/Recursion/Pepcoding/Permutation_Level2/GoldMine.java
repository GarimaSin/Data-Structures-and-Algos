package Problem_Solving.Recursion.Pepcoding.Permutation_Level2;

import java.util.ArrayList;

public class GoldMine {

	static int max = 0;

	//*********************** travelAndCollectGold Function ***********************

	public static void travelAndCollectGold(int[][] arr, int i, int j, boolean[][]visited, ArrayList< Integer>bag) {

		if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 0 || visited[i][j] == true) { //1
			return;
		}
		visited[i][j] = true; //2
		bag.add(arr[i][j]);   //3
		travelAndCollectGold(arr, i - 1, j, visited, bag); //4
		travelAndCollectGold(arr, i, j + 1, visited, bag);
		travelAndCollectGold(arr, i, j - 1, visited, bag);
		travelAndCollectGold(arr, i + 1, j, visited, bag);

	}

	//************************** getMaxGold Function **************************

	public static void getMaxGold(int[][]arr) {
		boolean[][]visited = new boolean[arr.length][arr[0].length]; //1
		for (int i = 0; i < arr.length; i++) { //2
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] != 0 && visited[i][j] == false) {
					ArrayList< Integer> bag = new ArrayList<>(); //3
					travelAndCollectGold(arr, i, j, visited, bag); //4
					int sum = 0;
					for (int val : bag) { //5
						sum += val;
					}
					if (sum > max) { //6
						max = sum;
					}
				}
			}
		}
	}

	//***************************** main() Function ****************************

	public static void main(String[] args) {
		int[][] arr = {{0,6,0},
				{5,8,7},
				{0,9,0}};
		getMaxGold(arr);
		System.out.println(max);
	}
}
