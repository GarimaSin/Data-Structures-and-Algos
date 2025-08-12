package Problem_Solving.Recursion.Pepcoding;

public class CombinationWORepetitionPep {
	 
	/***
	 * printAllKLengthRec and printAllKLengthRec1 will give same rslt except used i+1 wid vis[] in printAllKLengthRec 
	 * 
	 * Using vis[] itself eliminates – already used indexes. So recursing with passing cu. 
	 * Value of i again as the start index doesn’t make sense (coz it will be ultimately
	 * skipped by vis[]). Hence for optimization, use start+1 with vis[].
	 */
	static boolean vis[];
	static int outputLength = 3;
	
    public static void main(String[] args) {             
        System.out.println("First Test");
        char set1[] = {'1', '2', '3'};
        int n = set1.length;    
        vis = new boolean[n];
        printAllKLengthRec(set1, "", 0, 0);
//        System.out.println("__________________");
//        printAllCombs(set1, "", 0, -1);
//        System.out.println("__________________");
//        printAllCombs2(set1, "", 0, 0);
    }    
 
 
    static void printAllKLengthRec(char set[], String curr, int k, int start) {
//        if (k >= outputLength) {
//            System.out.println(curr);
//            return;
//        }
        
        System.out.println(curr);
 
        for (int i = start; i < set.length; ++i) {
//        	if(!vis[i]) {
//        		vis[i] = true;
    			printAllKLengthRec(set, curr + set[i], k+1, i+1);   //using i+1 will give same rslt as printAllKLengthRec1 but will optimize d code.  
//                vis[i] = false;
//        	}
        }
    }
    
    static void printAllKLengthRec1(char set[], String curr, int k, int start) {
        if (k >= outputLength) {
            System.out.println(curr);
            return;
        }
 
        for (int i = start; i < set.length; ++i) {
        	if(!vis[i]){
        		vis[i] = true;
    			printAllKLengthRec1(set, curr + set[i], k+1, i);   //vis[] can be removed to convert it to repetition code
                vis[i] = false;
        	}
        }
    }
    
    static void printAllCombs(char set[], String curr, int k, int start)  {
        if (k >= outputLength) {
            System.out.println(curr);
            return;
        }
 
        for (int i = start+1; i < set.length; ++i) {
        		printAllCombs(set, curr + set[i], k + 1, i);       //i+1 can be replaced with i to convert it to repetition code
        }
    }
    
    static void printAllCombs2(char set[], String curr, int k, int i)  {
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