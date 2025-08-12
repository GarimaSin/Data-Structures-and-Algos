package Problem_Solving.Recursion.Pepcoding;

import java.util.ArrayList;

public class MazePathWithJumps {
	public static void main(String[] args) {
		ArrayList<String> paths = getMazePathWithJumps(1, 1, 3, 3);
		System.out.println(paths);
		System.out.println("--------------------------------");
		printMazePathWithJumps(1, 1, 3, 3, "");
	}

	static ArrayList<String> getMazePathWithJumps(int srcR, int srcC, int desR, int desC) {
		if(srcR == desR && srcC == desC) {
			ArrayList<String> res = new ArrayList<String>();
			res.add("");
			return res;
		}

		ArrayList<String> paths = new ArrayList<String>();

		//Horizontal move
		for(int moveSize = 1; moveSize <= desC-srcC; moveSize++) {
			ArrayList<String> horzPath  = getMazePathWithJumps(srcR, srcC+moveSize, desR, desC);
			for(String  hpath: horzPath)
				paths.add("h" +moveSize + hpath);
		}

		//Vertical move
		for(int moveSize = 1; moveSize <= desR-srcR; moveSize++) {
			ArrayList<String> vertPath  = getMazePathWithJumps(srcR+moveSize, srcC, desR, desC);
			for(String  vpath: vertPath)
				paths.add("v" +moveSize+ vpath);
		}

		//Diagonal move
		for(int moveSize = 1; moveSize <= desR-srcR && moveSize <= desC-srcC; moveSize++) {
			ArrayList<String> diagonalPath  = getMazePathWithJumps(srcR+moveSize, srcC+moveSize, desR, desC);
			for(String  dpath: diagonalPath)
				paths.add("d" +moveSize + dpath);
		}
		return paths;
	}
	
	
	static void printMazePathWithJumps(int srcR, int srcC, int desR, int desC, String paths) {
		if(srcR == desR && srcC == desC) {
			System.out.println(paths);
			return;
		}

		//Horizontal move
		for(int moveSize = 1; moveSize <= desC-srcC; moveSize++) {
			printMazePathWithJumps(srcR, srcC+moveSize, desR, desC, paths+"h" +moveSize);
		}

		//Vertical move
		for(int moveSize = 1; moveSize <= desR-srcR; moveSize++) {
			printMazePathWithJumps(srcR+moveSize, srcC, desR, desC, paths+"v" +moveSize);
		}

		//Diagonal move
		for(int moveSize = 1; moveSize <= desR-srcR && moveSize <= desC-srcC; moveSize++) {
			printMazePathWithJumps(srcR+moveSize, srcC+moveSize, desR, desC, paths+"d" +moveSize);
		}
	}
}
