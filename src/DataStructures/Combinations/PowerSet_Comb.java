package DataStructures.Combinations;

import java.util.ArrayList;
import java.util.List;


public class PowerSet_Comb {
	
	public static ArrayList<String>al=new ArrayList<String>(); 
	
	public static void main(String[] args) {
		PowerSet_Comb powerSet = new PowerSet_Comb();
		int nums[] = {1,2,3};
		List<List<Integer>> answer = powerSet.subsets(nums);
		for(int i=0; i<answer.size(); i++) {
			for(int j=0; j<answer.get(i).size(); j++) {
				System.out.print(answer.get(i).get(j) + " ");
			}
			System.out.println();
		}
		
		//Approach 2
		String str = "123"; 
		printSubSeqRec(str, -1, ""); 
	}
	
	// working
//	public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> result = new ArrayList<List<Integer>> ();
//        if (nums.length != 0) {
//            List<Integer> temp = new ArrayList<Integer> ();
//            temp.add(nums[0]);
//            result.add(temp);
//        }
//        
//        List<Integer> temp1 = new ArrayList<Integer> ();
//        result.add(temp1);
//        
//        for (int j = 1; j < nums.length; j++){
//            int size = result.size();
//            for (int i = 0; i < size; i++) {
//                result.add(new ArrayList<>(result.get(i)));
//                result.get(i).add(nums[j]);
//            }
//        }
//        return result;
//    }
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		subsetsHelper(list, new ArrayList<>(), nums, 0);
		return list;
	}
 
	
	//Approach 1
	private void subsetsHelper(List<List<Integer>> list , List<Integer> resultList, int [] nums, int start) {
		
		list.add(new ArrayList<>(resultList));			// answer
	
		for(int i = start; i < nums.length; i++){
			resultList.add(nums[i]);
			subsetsHelper(list, resultList, nums, i + 1);
			resultList.remove(resultList.size() - 1);
		}
	}
	
	//Approach 2
	static void printSubSeqRec(String str, int index, String curr)  {
		
		System.out.println(curr); 
		
		// base case  
		if (index == str.length())  
			return; 

		for (int i=index +1; i<str.length(); i++)  				/** have to index+1 and not in recursive call (i+1) since str.charAt(i) will give error then, 
																								this will not give error in case of list though since list is added and removed after recursion**/
			printSubSeqRec(str, i, curr+str.charAt(i)); 			// cannot write i+1 here

	}
	
	
	//Approach 3
	private static void findsubsequences(String s, String ans) { 
        if(s.length()==0) { 
            al.add(ans);  
            return; 
        } 
  
                //we add adding 1st character in string            
        findsubsequences(s.substring(1),ans+s.charAt(0)) ; 
  
                // Not adding first character of the string 
                // because the concept of subsequence either  
                // character will present or not 
        findsubsequences(s.substring(1),ans);       
    }
} 
