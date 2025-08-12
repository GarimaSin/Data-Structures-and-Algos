package DataStructures.Combinations;

public class PermutationWRepetition {
	 
	/** Main function, can be converted to ------
	 *  CombinationWRepetition by starting the for loop from current value of 'i' and not 0
	 *  PermutationWORepetition by adding visited array.
	 *  CombinationWORepetition by starting the for loop from current value of 'i' and not 0 and using vis[].
	 *  
	 *  Combination = loop from cu. value of i 
	 *  WO Repetition = use visited array
	 */
	
	//-------------To toggle between 0 and 1 for any length, PermutationWR is used. Call printCombinationsOfZero.--------------//
	
    public static void main(String[] args) {             
        System.out.println("First Test");
        char set1[] = {'0', '1'};
        int k = 4;
        printAllKLength(set1, k);
         
        System.out.println("\nSecond Test");
        char set2[] = {'1', '2', '3'};
        k = 4;
        printAllKLength(set2, k);
        
        System.out.println("\nThird Test");
        printCombinationsOfZero(new int[3], 0, 3);
        
        System.out.println("\nFourth Test");
        permute("ab", "");
    }    
 
    static void printAllKLength(char set[], int k) {
        int n = set.length;        
        printAllKLengthRec(set, "", n, k);
    }
 
    static void printAllKLengthRec(char set[], String curr, int n, int k) {
        if (k == 0) {
            System.out.println(curr);
            return;
        }
 
        for (int i = 0; i < n; ++i)
            printAllKLengthRec(set, curr+set[i], n, k - 1); 
    }
    
    static void permute(String inp, String ans) {
        if (ans.length() == inp.length()) {
            System.out.println(ans);
            return;
        }
 
        for (int i = 0; i < inp.length(); ++i) 
        	permute(inp, ans+inp.charAt(i)); 
    }
    
    static void printCombinationsOfZero(int temp[], int count, int outputLength) {
        if (count >= outputLength) {
            for (int i = 0; i < outputLength; ++i) {
            	System.out.print(temp[i]);
            }
            System.out.println();
            return;
        }
 
        for (int i = 0; i < 2; ++i) {
			temp[count] = i;
			printCombinationsOfZero(temp, count+1, outputLength); 
        }
    }
}