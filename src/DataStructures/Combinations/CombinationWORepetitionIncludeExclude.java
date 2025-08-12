package DataStructures.Combinations;


/**
 * We one by one consider every element of input array, and recur for two cases:

	1) The element is included in current combination (We put the element in data[] and increment next available index in ans[])
	2) The element is excluded in current combination (We do not put the element and do not change index)
	
	When number of elements in ans[] become equal to r (size of a combination), we print it.
	
	This method is mainly based on Pascal�s Identity, i.e. ncr = n-1cr + n-1cr-1
	
	https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
	
	
	
	Check solution with string also, there we do not have to increase the output string's index coz string automatically appends the char on increased index
 **/

public class CombinationWORepetitionIncludeExclude {
	/* input[]  ---> Input Array 
    data[] ---> Temporary array to store current combination 
    start & end ---> Staring and Ending indexes in input[] 
    indexAns  ---> Current index in ans[] 
    r ---> Size of a combination to be printed */
	
    static void combinationUtil(int input[], int r, int indexAns, int ans[], int inputIndex)  { 
        if (indexAns == r) { 
            for (int j=0; j<r; j++) 
                System.out.print(ans[j]+" "); 
            System.out.println(""); 
        return; 
        } 
  
        if (inputIndex >= input.length) 
        return; 
  
        // current is included in output array = ans[], put next at next location 
        ans[indexAns] = input[inputIndex]; 
        combinationUtil(input, r, indexAns+1, ans, inputIndex+1); 
  
        // current is excluded, replace it with next (Note that inputIndex+1 is passed, but index is not changed) 
        combinationUtil(input, r, indexAns, ans, inputIndex+1); 
    } 
    
    
    //Check this also
    private static void combStringIncludeExclude(int inputIndex, int len, String input, String ans) {
		if (ans.length() == 3) {		
			System.out.println(ans);
			return;
		}

		if (inputIndex >= input.length()) 
			return; 

		combStringIncludeExclude(inputIndex+1, len, input, ans+input.charAt(inputIndex));			//dont have to manage/inc. ans's index coz string automatically appends or does this
		combStringIncludeExclude(inputIndex+1, len, input, ans);
	}
    
    
    private static void combStringIncludeExclude1(int inputIndex, int len, String input, String ans) {
		if (ans.length() == 3) {		
			System.out.println(ans);
			return;
		}

		if (inputIndex >= input.length()) 
			return; 

		for(int i=inputIndex; i<input.length(); i++) {
			
		}
		combStringIncludeExclude1(inputIndex+1, len, input, ans+input.charAt(inputIndex));			//dont have to manage/inc. ans's index coz string automatically appends or does this
		combStringIncludeExclude1(inputIndex+1, len, input, ans);
	}
    
    
    
    
  
    // The main function that prints all combinations of size r 
    // in input[] of size n. This function mainly uses combinationUtil() 
    static void printCombination(int input[], int n, int r)    { 
        // A temporary array to store all combinations
        int ans[]=new int[r]; 
  
        combinationUtil(input, r, 0, ans, 0); 
    } 
  
    public static void main (String[] args) { 
        int arr[] = {1, 2, 3, 4}; 
        int r = 3; 
        int n = arr.length; 
//        printCombination(arr, n, r);
//        System.out.println("..................");
        combStringIncludeExclude(0, 3, "1234", "");
//        combStringIncludeExclude1(0, 3, "1234", "");
    } 
}
