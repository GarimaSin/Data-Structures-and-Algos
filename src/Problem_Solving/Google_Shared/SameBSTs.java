package Problem_Solving.Google_Shared;

import java.util.ArrayList;
import java.util.Arrays;

public class SameBSTs {

	public static void main(String[] args) {
		ArrayList<Integer> aL1 = new ArrayList<Integer>(Arrays.asList(3, 5, 4, 6, 1, 0, 2)); 
		ArrayList<Integer> aL2 = new ArrayList<Integer>(Arrays.asList(3, 1, 5, 2, 4, 6, 0)); 
		System.out.println(sameBSTs(aL1, aL2)); 
	} 
	
	static boolean sameBSTs(ArrayList<Integer> aL1, ArrayList<Integer> aL2) {
		// Base cases 
		if (aL1.size() != aL2.size()) 
			return false; 
		if (aL1.size() == 0) 
			return true; 
		if (aL1.get(0) != aL2.get(0)) 
			return false; 

		// Construct two lists from each input array. The first 
		// list contains values smaller than first value, i.e., 
		// left subtree. And second list contains right subtree. 
		ArrayList<Integer> aLLeft1 = new ArrayList<Integer>(); 
		ArrayList<Integer> aLRight1 = new ArrayList<Integer>(); 
		ArrayList<Integer> aLLeft2 = new ArrayList<Integer>(); 
		ArrayList<Integer> aLRight2 = new ArrayList<Integer>(); 
		for (int i = 1; i < aL1.size(); i++) { 
			if (aL1.get(i) < aL1.get(0)) 						//Move all elements less than root to left list/subtree for list1
				aLLeft1.add(aL1.get(i)); 
			else
				aLRight1.add(aL1.get(i)); 

			if (aL2.get(i) < aL2.get(0)) 						//Move all elements less than root to right list/subtree for list2
				aLLeft2.add(aL2.get(i)); 
			else
				aLRight2.add(aL2.get(i)); 
		} 

		// Recursively compare left and right subtrees. 
		return sameBSTs(aLLeft1, aLLeft2) && sameBSTs(aLRight1, aLRight2); 
	} 

}
