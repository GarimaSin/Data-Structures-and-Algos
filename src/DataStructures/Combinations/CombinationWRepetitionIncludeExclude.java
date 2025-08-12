package DataStructures.Combinations;


/**
 * We one by one consider every element of input array, and recur for two cases:

	1) The element is included in current combination (We put the element in data[] and increment next available index in data[])
	2) The element is excluded in current combination (We do not put the element and do not change index)
	
	When number of elements in data[] become equal to r (size of a combination), we print it.
	
	This method is mainly based on Pascal’s Identity, i.e. ncr = n-1cr + n-1cr-1
	
	https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
 **/

public class CombinationWRepetitionIncludeExclude {
	/* input[]  ---> Input Array 
    ans[] ---> Temporary array to store current combination 
    start & end ---> Staring and Ending indexes in input[] 
    indexAns  ---> Current index in ans[] 
    r ---> Size of a combination to be printed */
	
    static void combinationUtil(int input[], int r, int indexAns, int ans[], int inputIndex, String s)  { 
        if (indexAns == r) { 
//            for (int j=0; j<r; j++) 
//                System.out.print(data[j]+" "); 
            System.out.println(s); 
        return; 
        } 
  
        if (inputIndex >= input.length) 
        return; 
  
//        ans[indexAns] = input[inputIndex]; 						// storing ans in String not array
        combinationUtil(input, r, indexAns+1, ans, inputIndex, s+input[inputIndex]); 
        combinationUtil(input, r, indexAns, ans, inputIndex+1, s); 
    } 
  
    static void printCombination(int arr[], int r)    { 
        int data[]=new int[r]; 
  
        combinationUtil(arr, r, 0, data, 0, ""); 
    } 
  
    public static void main (String[] args) { 
        int arr[] = {1, 2, 3, 4}; 
        int r = 3; 
        printCombination(arr, r); 
    } 
}
