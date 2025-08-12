package Problem_Solving.Recursion.Pepcoding;

public class CombinationFromPermutation {

	static void printCombinations(boolean[] boxes, int cuItem, int totItems, int lastBox) {
		if (cuItem > totItems) {										
			for (int i = 0; i < boxes.length; i++) {	
				if(boxes[i]) 
					System.out.print("i");
				else
					System.out.print("-");
			}
			System.out.println();	
			return;
		}

		for (int b = lastBox+1; b < boxes.length; b++) {					
			if(!boxes[b]) {												
				boxes[b] = true;
				printCombinations(boxes, cuItem+1, totItems, b);
				boxes[b] = false;
			}
		}
	}
	
	//Comb WITHOUT repitition
	static void printAllKLengthRec(char set[], String curr, int k, int start, boolean[] vis, int outputLength) {
        if (k >= outputLength) {
            System.out.println(curr);
            return;
        }
 
        for (int i = start; i < set.length; ++i) {
        	if(!vis[i])	{
        		vis[i] = true;
    			printAllKLengthRec(set, curr + set[i], k + 1, i, vis, outputLength);       // i can be replaced with i+1 to remove vis[]
                vis[i] = false;
        	}
        }
    }
	
	
	//Same code as printAllKLengthRec = but since no vis => comb WITH repitition
	static void printAllKLength(char set[], String curr, int k, int start, boolean[] vis, int outputLength) {
        if (k >= outputLength) {
            System.out.println(curr);
            return;
        }
 
        for (int i = start; i < outputLength; ++i) {
//        	if(!vis[i])	{
        		vis[i] = true;
        		printAllKLength(set, curr + set[i], k + 1, i, vis, outputLength);       // i can be replaced with i+1 to remove vis[]
                vis[i] = false;
//        	}
        }
    }
	
	public static void main(String[] args) {
		
//		printCombinations(new boolean[4], 1, 2, -1);
//		System.out.println();
		
		char set1[] = {'1', '2', '3', '4'};
        int n = set1.length;    
		boolean[] vis = new boolean[n];
		int outputLength = 3;
		printAllKLengthRec(set1, "", 0, 0, vis, outputLength);
	}
}
