package DataStructures.Combinations;

public class CombinationWRepetition {
	 
	/**
	 * Working
	 * Same as PermutationWRepetition, only start the for loop from current value of 'i' at line# 29.
	 * Can be converted to CombinationWORepetition by passing i+1 instead of i, in recursive call ********
	 */
	
    public static void main(String[] args) {             
        System.out.println("First Test");
        char set1[] = {'1', '2'};
        int k = 3;
        printAllKLength(set1, k);
    }    
 
    static void printAllKLength(char set[], int k) {
//        int n = set.length;        
        printAllKLengthRec(set, "", k, 0);
    }
 
    static void printAllKLengthRec(char set[], String curr, int k, int start) {
         
        if (k == 0) {
            System.out.println(curr);
            return;
        }
 
        for (int i = start; i < set.length; ++i) {
            printAllKLengthRec(set, curr + set[i], k - 1, i); 
        }
    }
}
