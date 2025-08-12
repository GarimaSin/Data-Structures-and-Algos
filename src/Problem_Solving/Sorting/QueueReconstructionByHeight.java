package Problem_Solving.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionByHeight {

	public static int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (b[0] == a[0]) return a[1] - b[1];
				return b[0] - a[0];
			}
		});

		List<int[]> res = new ArrayList<>();
		for(int[] p : people){
			res.add(p[1], p);
		}
		int n = people.length;
		return res.toArray(new int[n][2]);
	}

	public static void main(String[] args) {
		int people[][] = {{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};
		int ans[][] = reconstructQueue(people);
		for(int i[]: ans) {
			for(int j: i) {
				System.out.print(j+" ");
			}
			System.out.println("");
		}
	}
}
