package SWC_Codes_Office.src.test.src.Advanced;

public class puzzle {
	static int noOfMoves = 0;
	static int marker;
	static int solution;
	static int[] board = {3,6,4,1,3,4,2,5,3,0};
	public static void main(String args[])
	{
			move(0,board);
	}
	
	public static void move(int cuPos, int arr[]){
		noOfMoves++;
		int val = arr[cuPos];
		if(cuPos == 9){
			System.out.println("Done..."+noOfMoves);
			solution = cuPos;
			return;
		}
		if(marker == 9)
			System.out.println("");
		else {
			if(cuPos+val <= 10)
				cuPos = cuPos+val;
			marker = cuPos;
			move(cuPos, arr);
		}
	}
}
