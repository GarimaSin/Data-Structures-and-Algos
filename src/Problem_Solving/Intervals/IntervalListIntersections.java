package Problem_Solving.Intervals;

import java.util.ArrayList;
import java.util.Arrays;

//Given lists will be sorted, o/w sort both the lists.
public class IntervalListIntersections {
	public static int[][] intersection(int intervalList1[][], int intervalList2[][]) {
		ArrayList<int[]> ans = new ArrayList<>();

		int i = 0, j = 0;

		while (i < intervalList1.length && j < intervalList2.length) {
			int cSP = Math.max(intervalList1[i][0], intervalList2[j][0]);
			int cEP = Math.min(intervalList1[i][1], intervalList2[j][1]);

			if (cSP <= cEP) {
				int tmp[] = {cSP, cEP};
				ans.add(tmp);
			}										// dont put below statements in else condition
						
			if (intervalList1[i][1] < intervalList2[j][1]) { // compare the ends of both the lists
				i++;
			} else {
				j++;
			}
		}
		return ans.toArray(new int[ans.size()][]);
	}
	
	
	public static void main(String[] args) {
		int list1[][] = {{0,2},{5,10},{13,23},{24,25}};
		int list2[][] = {{1,5},{8,12},{15,24},{25,26}};
		int ans[][] = intersection(list1, list2);
		System.out.print("[");
		for (int interval[] : ans) {
			System.out.print(Arrays.toString(interval));
		}
		System.out.println("]");
	}
}
