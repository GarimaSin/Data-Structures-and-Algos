package DataStructures.Combinations;

import java.util.ArrayList;
import java.util.List;

public class PermutationWORepetition {
	 
	// Working
	//If k+1 is passed in recursive call, no need to perform k=k-1 later. LN - 35
	// This will not work if n > size of inputs, here 3, as there will be repetitions and hence no unique combinations.
	
	static boolean vis[];
	static int n = 0;
	static int outputLength = 0;
	
    public static void main(String[] args) {             
        System.out.println("First Test");
        char set1[] = {'1', '2', '3'};
        n = set1.length; 
        outputLength = n;
        vis = new boolean[n];
        printAllKLengthRec(set1, "", n, 0);
    }    
 
    static void printAllKLengthRec(char set[], String curr, int n, int k) {
        if (k >= outputLength) {
            System.out.println(curr);
            return;
        }
 
        for (int i = 0; i < n; ++i) {
        	if(!vis[i]) {
        		vis[i] = true;
    			printAllKLengthRec(set, curr+ set[i], n, k + 1);
                vis[i] = false;
        	}
        }
    }
    
    void findPermutations(List<Integer> list, List<List<Integer>> ans, int[] nums, boolean[] vis) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        } 
        for (int i=0; i<nums.length; i++) {
             if(list.contains(nums[i])) 					//Instead of vis[]
            	 continue;
            list.add(nums[i]);
            findPermutations(list, ans, nums, vis);
            list.remove(list.size()-1);
        }
    }
}