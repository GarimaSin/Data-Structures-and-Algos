package SWC_Codes_Office.src.PracticeProb.src.Recursion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * 
 * office code
 *
 */
class FindAllPathsInAMaze {
	private int size;
	private String[][] board;
	private int total; //# of boards
	private int eX;
	private int eY;
	private int mX;
	private int mY;

	public FindAllPathsInAMaze( int size, String[][] board ) {
		this.size = size;
		this.board = board;
		total = 0;
	}

	private void find( String c ) {
		int x=0, y=0;
		for( int i = 0; i < size; i++ ) {
			for( int j = 0; j < size; j++ ) {
				if( board[i][j].equals(c) ) {
					x = i;
					y = j;
				}
			}
		}
		if( c.equals("M") ) {
			mX = x;
			mY = y;
		}
		else if( c.equals("E") ) {
			eX = x;
			eY = y;
		}
	}

	public void findPath() {
		find( "M" );
		find( "E" );
		findNext( mX, mY );
	}

	public void findNext( int x, int y ) { 
		String last = board[x][y];
		if( board[x][y].equals("P") ) board[x][y] = "1";
		board[x][y] = "P";

		if( rightAvailability(x,y) ) {
			findNext(x+1, y);
		}
		if( leftAvailability(x,y) ) {
			findNext(x-1, y);
		}
		if( aboveAvailability(x,y) ) {
			findNext(x, y+1);
		}
		if( belowAvailability(x,y) ) {
			findNext(x, y-1);
		}
		else {
			total++;
			printBoard();
		}
		board[x][y]= last;
	}

	public boolean rightAvailability( int x, int y ) {
		if( x+1 >= size ) return false;
		else if( board[x+1][y].equals("1") ) return false;
		else if( board[x+1][y].equals("P") ) return false;
		else return true;
	}
	
	public boolean leftAvailability( int x, int y ) {
		if( x-1 < 0) return false;
		else if( board[x-1][y].equals("1") ) return false;
		else if( board[x-1][y].equals("P") ) return false;
		else return true;
	}
	public boolean aboveAvailability( int x, int y ) {
		if( y+1 >= size ) return false;
		else if( board[x][y+1].equals("1") ) return false;
		else if( board[x][y+1].equals("P") ) return false;
		else return true;
	}
	public boolean belowAvailability( int x, int y ) {
		if( y-1 < 0) return false;
		else if( board[x][y-1].equals("1") ) return false;
		else if( board[x][y-1].equals("P") ) return false;
		else return true;
	}

	public void printBoard() {
		System.out.println( "The board number " +total+ " is: ");
		for(int i=0; i< size; i++ ) {
			for(int j=0; j< size; j++ ) {
				if( (i==mX) && (j==mY) ) {
					System.out.print("M");
				}
				else if( (i==eX) && (j==eY) ) {
					System.out.print("E");
				}
				else if( board[i][j].equals("1") ) {
					System.out.print("1");
				}
				else if( board[i][j].equals("0") ) {
					System.out.print("0");
				}
				else {
					System.out.print("P");
				}
			}
			System.out.println();
		}
	}
}

public class FindAllPathsInMaze {
    public static void main(String[] args) throws FileNotFoundException  {
    	String[][] board = new String[][]
    		{
    			{"1","1","1","1","1","1","1","1","1","1","1"},
    			{"1","0","0","0","0","0","1","0","0","0","1"},
    			{"1","0","1","0","0","0","1","0","1","0","1"},
    			{"E","0","1","0","0","0","0","0","1","0","1"},
    			{"1","0","1","1","1","1","1","0","1","0","1"},
    			{"1","0","1","0","1","0","0","0","1","0","1"},		
    			{"1","0","0","0","1","0","1","0","0","0","1"},
    			{"1","1","1","1","1","0","1","0","0","0","1"},
    			{"1","0","1","M","1","0","1","0","0","0","1"},
    			{"1","0","0","0","0","0","1","0","0","0","1"},
    			{"1","1","1","1","1","1","1","1","1","1","1"},	
    		};
    		
    		Scanner sc = new Scanner(new FileInputStream("LongestPath.txt"));
            int T = sc.nextInt();

            for(int test_case=0;test_case<T;test_case++){
                int N = sc.nextInt();
                board = new String[N][N];
//                visited = new int[N][N];
//                max=0;

                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                    	board[i][j] = sc.next();
                    }
                }
			FindAllPathsInAMaze m = new FindAllPathsInAMaze( N, board );
			m.findPath();
            }
    }
}