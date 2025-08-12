package Problem_Solving.Recursion.Pepcoding;

import java.util.ArrayList;

public class MazePath {
	
	public static void main(String[] args) {
		ArrayList<String> paths = getMazePath(1, 1, 3, 3);
		System.out.println(paths);
		System.out.println("--------------------------------");
		printMazePath(1, 1, 3, 3, "");
	}
	
	
	//Smart call, dumb base case
	static ArrayList<String> getMazePath(int srcR, int srcC, int desR, int desC) {
		if(srcR == desR && srcC == desC) {
			ArrayList<String> res = new ArrayList<String>();
			res.add("");
			return res;
		}
		
		ArrayList<String> horzPath = new ArrayList<String>();
		ArrayList<String> vertPath = new ArrayList<String>();
		ArrayList<String> paths = new ArrayList<String>();
		
		if(srcC < desC)
			horzPath  = getMazePath(srcR, srcC+1, desR, desC);
		
		if(srcR < desR)
			vertPath  = getMazePath(srcR+1, srcC, desR, desC);
		
		for(String  hpath: horzPath)
			paths.add("h" + hpath);
	
		for(String  vpath: vertPath)
			paths.add("v" + vpath);
		
		return paths;
	}
	
	
	//Smart call, dumb base case
	static void printMazePath(int srcR, int srcC, int desR, int desC, String paths) {
		if(srcR == desR && srcC == desC) {
			System.out.println(paths);
			return;
		}
		
		if(srcC < desC)
			printMazePath(srcR, srcC+1, desR, desC, paths+"h");
		
		if(srcR < desR)
			printMazePath(srcR+1, srcC, desR, desC, paths+"v");
	}
}
