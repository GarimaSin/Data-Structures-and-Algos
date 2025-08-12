package SWC_Codes_Office.src.MyCodes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class CuttingRod {
	static int len = 0;
	static int totCuts = 0;
	static int[] cuts;
//	static int[] result = null;
	static int cost = Integer.MAX_VALUE;
	static boolean flag;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("CuttingRod.txt"));
        int T=sc.nextInt();
        for(int t=1;t<=T;t++) {
        	len = sc.nextInt();
        	totCuts = sc.nextInt();
        	cuts = new int[totCuts];
        	int[] result = new int[totCuts];
        	flag = false;
        	boolean[] visited = new boolean[totCuts];
        	cost = Integer.MAX_VALUE;
        	for(int i=0; i<totCuts; i++){
        		cuts[i] = sc.nextInt();
        		result[i] = Integer.MAX_VALUE;
        	}
        	System.out.println(cutRod(result, visited, 0, 0));
        	System.out.println("...");
//        	System.out.println(re);
        }
	}

	private static int cutRod(int[] result, boolean[] visited, int peice, int tempCost) {
		if(flag == true){
			if(peice == totCuts){
				if(tempCost < cost){
					cost = tempCost;
				}
//				peice
				return cost;
			}
		}
		
		for(int i=0; i<totCuts; i++){
			if(visited[i] == false){
				visited[i] = true;
				int t = cuts[i];
				int index = 0;
				int cst = 0;
				result[peice] = t;
				if(peice >= 1){
					Arrays.sort(result);
					index = Arrays.binarySearch(result, t);
				}
				if(peice >= 2) {
					if(index == peice)
						cst = len - result[index-1];
					else if(index == 0)
						cst = len - result[index+1];
					else
						cst = result[index+1] - result[index-1];
				}
				else if(peice == 1){
					if(index != 0)
						cst = len - result[index-1];
					else
						cst = len - result[index+1];
				}
				else 
					cst = len;
				if(flag == true)
					tempCost = tempCost + cst;
				else {
					tempCost = cst;
					flag = true;
				}
				cutRod(result, visited, peice+1, tempCost);
				result[peice] = Integer.MAX_VALUE;
				tempCost = tempCost - cst;
				visited[i] = false;
			}
		}
		return cost;
	}
}
