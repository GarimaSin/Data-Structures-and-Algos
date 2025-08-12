package test.src.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class chessBoard {
	
	static int index = 0;
    static boolean isIndexEven = false, isPossible = true;
    static boolean isColEven = false;
    static int rows = 0, columnSize = 0;
    static String input = "";
    static String[] in = new String[rows];
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc=new Scanner(new FileInputStream("board.txt"));
        int T=sc.nextInt();
        for(int t=1;t<=T;t++) {
        	rows=sc.nextInt();
        	input = "";
        	input = sc.next();
        	columnSize = input.length();
        	if(columnSize%2 != 0){
        		isColEven = false;
	        	for(int i=1; i<rows; i++){
	        		input = input+sc.next();
	        	}
        	} else {
        		isColEven = true;
        		in = new String[rows];
        		in[0] = input;
        		for(int i=1; i<rows; i++){
	        		in[i] = sc.next();
	        	}
        	}
        	System.out.println("#"+t+" "+checkSolution(isColEven));
        }
	}
	
	private static boolean checkSolution(boolean isColEven) {
		boolean firstChar = false;
		if(isColEven != true) {
	        for(int i=0; i<input.length(); i++){
	            if(input.charAt(i) != '?' && firstChar != true){
	            	firstChar = true;
	                index = i;
	                isIndexEven = isEvenIndex(i);
	            }
	            else if(input.charAt(i) != '?' && firstChar == true){
	            	if(isEvenIndex(i) == isIndexEven){
	            		if (input.charAt(index) != input.charAt(i))
	                        return false;
	            	} else{
	            		if (input.charAt(index) == input.charAt(i))
	                        return false;
	            	}
	            }
	        }
	    } else {
	    	int fRow = -1, fCol = -1;
	    	for(int row=0; row<rows; row++){
	    		for(int col=0; col<columnSize; col++){
	    			if(firstChar == false && in[row].charAt(col) != '?'){
	    				fRow = row; fCol = col;
	    				firstChar = true;
	    			} else if(firstChar == true && in[row].charAt(col) != '?'){
	    				if((isEvenIndex(fRow) == isEvenIndex(row) && isEvenIndex(col) == isEvenIndex(fCol)) 
	    						|| (isEvenIndex(fRow) != isEvenIndex(row) && isEvenIndex(col) != isEvenIndex(fCol))){
	    					if(in[row].charAt(col) != in[fRow].charAt(fCol))
    							return false;
	    				} else if((isEvenIndex(fRow) != isEvenIndex(row) && isEvenIndex(col) == isEvenIndex(fCol)) 
	    						|| (isEvenIndex(fRow) == isEvenIndex(row) && isEvenIndex(col) != isEvenIndex(fCol))){
	    					if(in[row].charAt(col) == in[fRow].charAt(fCol))
    							return false;
	    				}
	    			}
	    		}
	    	}
	    }
		return isPossible;
	}
	

	private static boolean isEvenIndex(int i) {
        if(i%2 == 0)
            return true;
        else
            return false;
    }
}