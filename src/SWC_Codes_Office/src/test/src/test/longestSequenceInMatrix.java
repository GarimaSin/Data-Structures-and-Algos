package test.src.test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class longestSequenceInMatrix {
	
	public static void main(String a[]) {
		int[][] mat = new int[][]{
				{1, 1, 1, 1, 1},
				{1, 2, 0, 0, 0},
				{1, 0, 2, 0, 0},
				{3, 3, 3, 2, 0},
				{3, 3, 3, 3, 2},
		};
		int size = 5;
		
		int sol = findLongestSequence(mat, size);
		System.out.println(sol);
	}

	private static int findLongestSequence(int[][] mat, int size) {
		int[] ar = new int[10];
		int count = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				if(map.containsKey(mat[i][j]))
					map.put(mat[i][j], map.get(mat[i][j])+1);
				else
					map.put(mat[i][j],1);
			}
		}
		return 0;
	}

}
