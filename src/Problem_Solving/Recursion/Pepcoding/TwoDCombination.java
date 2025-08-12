package Problem_Solving.Recursion.Pepcoding;

//Time = exponential
public class TwoDCombination { 

	// boardSize = 9, (if board = 3*3), totCells = if we have reached the last cell = 9.
	// 1 D sol
	static void combine(int count, int boardSize, int totItem, int row, int col, String ans, int totCells) { 
		if (totCells == boardSize*boardSize)  {
			if(count == totItem)
				System.out.println(ans);
			return; 
		}

		int newRow = 0;
		int newCol = 0;
		String selectAns = "";
		String notSelectAns = "";

		//When we have reached the last col, start a new row and make col = 0
		if(col == boardSize-1) {
			newRow = row + 1;
			newCol = 0;
			selectAns = ans + "q\n";
			notSelectAns = ans + "-\n";
		} else {
			newRow = row;
			newCol = col+1;
			selectAns = ans + "q";
			notSelectAns = ans + "-";
		}
		combine(count + 1, boardSize, totItem, newRow, newCol, selectAns, totCells+1);
		combine(count + 0, boardSize, totItem, newRow, newCol, notSelectAns, totCells+1);
	} 


	public static void main(String args[]) {
		int totItems = 2;
		int boardRowsize = 2;
		combine(0, boardRowsize, totItems, 0, 0, "", 0);
	} 
} 
