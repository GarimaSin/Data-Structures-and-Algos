package Problem_Solving.Recursion.Pepcoding;

//Time = exponential
public class TwoDPermutation2 { 

	//boardSize = 9, (if board = 3*3), totCells = if we have reached the last cell = 9.
	static void permute(int count, int boardSize, int totItem, int row, int col, String ans, int totCells, boolean[] vis) { 
		if (totCells == boardSize*boardSize)  {
			if(count == totItem)
				System.out.println(ans);
			return; 
		}

		int newRow = 0;
		int newCol = 0;
		String seperator = "";

		//When we have reached the last col, start a new row and make col = 0
		if(col == boardSize-1) {
			newRow = row + 1;
			newCol = 0;
			seperator = "\n";
		} else {
			newRow = row;
			newCol = col+1;
			seperator = "  ";
		}

		for(int i=0; i<totItem; i++) {
			if(!vis[i]) {
				vis[i] = true;
				permute(count + 1, boardSize, totItem, newRow, newCol, ans+"q"+(i+1)+seperator, totCells+1, vis);
				vis[i] = false;
			}
		}
		permute(count + 0, boardSize, totItem, newRow, newCol, ans+"-"+seperator, totCells+1, vis);
	} 

	//Working - mine
	static void permute1(int count, int boardSize, int totItem, String ans, boolean[] vis) { 
		if(count > totItem)
			return;
		if(count == totItem)	{
			System.out.println(ans);
			return; 
		}

		for(int i=0; i<boardSize; i++) {
			if(!vis[i]) {
				vis[i] = true;
				permute1(count + 1, boardSize, totItem, ans+"q"+(count+1)+" cell = "+i+"   ", vis);
				vis[i] = false;
			}
		}
	} 


	public static void main(String args[]) {
		int totItems = 2;
		int boardRowsize = 2;
//		permute(0, boardRowsize, totItems, 0, 0, "", 0, new boolean[totItems+1]);
		permute1(0, boardRowsize*boardRowsize, totItems, "", new boolean[boardRowsize*boardRowsize+1]);
	} 
} 
