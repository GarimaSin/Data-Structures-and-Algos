package Problem_Solving.Recursion.Pepcoding;

import java.util.ArrayList;

public class StairsPath {

	public static void main(String[] args) {
		int totStairs = 4;
		ArrayList<String> paths = getStairsPath(totStairs);
		System.out.println(paths);
		System.out.println("--------------------------------");
		printStairsPath(totStairs, "");
	}

	private static ArrayList<String> getStairsPath(int n) {
		if(n == 0) {
			ArrayList<String> path = new ArrayList<String>();
			path.add("");
			return path;
		}
		if(n < 0) {
			ArrayList<String> path = new ArrayList<String>();
			return path;
		}
		ArrayList<String> paths1 = getStairsPath(n-1);
		ArrayList<String> paths2 = getStairsPath(n-2);
		ArrayList<String> paths3 = getStairsPath(n-3);
		ArrayList<String> paths = new ArrayList<String>();
		for(String path: paths1) {
			paths.add(path + "1"); 
		}
		for(String path: paths2) {
			paths.add(path + "2"); 
		}
		for(String path: paths3) {
			paths.add(path + "3"); 
		}
		return paths;
	}
	
	private static void printStairsPath(int n, String paths) {
		if(n == 0) {
			System.out.println(paths);
			return;
		}
		if(n < 0) {
			return;
		}
		printStairsPath(n-1, paths+1);
		printStairsPath(n-2, paths+2);
		printStairsPath(n-3, paths+3);
	}
}
