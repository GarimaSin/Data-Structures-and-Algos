package DataStructures.Combinations;

public class PowerSetComb_Arrays {
	 
	/**
	 * Working
	 * Same as CombWRepetition, only increase the value of 'i' by +1 at line# 32.
	 */
	
    public static void main(String[] args) {             
        System.out.println("First Test");
        char set1[] = {'1', '2', '3'};
        int k = -1;
        printAllKLength(set1, k);
    }    
 
    static void printAllKLength(char set[], int k) {
        int n = set.length;        
        printAllKLengthRec(set, k, 0, new char[n+6]);
    }
 
    static void printAllKLengthRec(char set[], int k, int start, char[] ans) {
         
    	for(int j=0; j<=k; j++) {
            System.out.print(ans[j]);
    	}
    	System.out.println();
 
        for (int i = start; i < set.length; ++i) {
        	ans[k+1] = set[i];
            printAllKLengthRec(set, k+1, i+1, ans); 
        }
    }
}
