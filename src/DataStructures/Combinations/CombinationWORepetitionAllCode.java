package DataStructures.Combinations;

/** 
 * The idea is to start from first index (index = 0) in data[], one by one fix elements at this index 
 * and recur for remaining indexes. Let the input array be {1, 2, 3, 4, 5} and r be 3. 
 * We first fix 1 at index 0 in data[], then recur for remaining indexes, then we fix 2 at index 0 and recur. 
 * Finally, we fix 3 and recur for remaining indexes. 
 * When number of elements in data[] becomes equal to r (size of a combination), we print data[]
 * 
 * https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
 * 
 * 
 * Vis[] array can be replaced by passing i+1 instead of 'i' when calling recursive func.
 * **/

public class CombinationWORepetitionAllCode {
	 
	static boolean vis[];
	static int outputLength = 3;
	
    public static void main(String[] args) {             
        System.out.println("First Test");
        char set1[] = {'1', '2', '3','4'};
        int n = set1.length;    
        vis = new boolean[n];
        printAllKLengthRec(set1, "", 0, 0);
        System.out.println("__________________");
        printAllCombs(set1, "", 0, -1);
        System.out.println("__________________");
        printAllCombs2(set1, "", 0, 0);
    }    
 
 
    static void printAllKLengthRec(char set[], String curr, int k, int start) {
        if (k >= outputLength) {
            System.out.println(curr);
            return;
        }
 
        for (int i = start; i < set.length; ++i) {
        	if(!vis[i]){
        		vis[i] = true;
    			printAllKLengthRec(set, curr + set[i], k + 1, i);       //vis[] can be removed to convert it to repetition code
                vis[i] = false;
        	}
        }
    }
    
    static void printAllCombs(char set[], String curr, int k, int start) {
        if (k >= outputLength) {
            System.out.println(curr);
            return;
        }
 
        for (int i = start+1; i < set.length; ++i) {
        	printAllCombs(set, curr + set[i], k + 1, i);       //i+1 can be replaced with i to convert it to repetition code
        }
    }
    
    static void printAllCombs2(char set[], String curr, int k, int i) {
    	if (k == outputLength) {
            System.out.println(curr);
            return;
        }
        
        if(i >= set.length)
        	return;
 
        printAllCombs2(set, curr + set[i], k + 1, i+1);
        printAllCombs2(set, curr, k, i+1);
    }
}