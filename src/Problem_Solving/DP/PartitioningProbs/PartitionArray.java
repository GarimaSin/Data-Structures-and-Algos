package Problem_Solving.DP.PartitioningProbs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartitionArray {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
//		String s = "abcd";
		List<List<List<Integer>>> result = new ArrayList<>();
		List<List<String>> result1 = new ArrayList<>();
//		backtrackString(s, new ArrayList<>(), result1);
		backtrack(arr, 0, new ArrayList<>(), result);
//
		for (List<List<Integer>> partition : result) {
			System.out.println(partition);
		}
		
//		System.out.println();
//		System.out.println("---------------------");
//		System.out.println();
		
//		result = new ArrayList<>();
//		result = partition2(arr, 0);
//
//        for (List<List<Integer>> partition : result) {
//            System.out.println(partition);
//        }
//		result = new ArrayList<>();
//        System.out.println();
//		System.out.println("---------------------");
//		System.out.println();
//		backtrack1(arr, 0, new ArrayList<>(), result);
//		for (List<List<Integer>> partition : result) {
//			System.out.println(partition.toString());
//		}
//        List<List<List<Integer>>> partitions = partition1(arr, 0, arr.length - 1);
//        for (List<List<Integer>> partition : partitions) {
//            System.out.println(partition);
//        }
	}
	
	// Backtracking code for a string
	static void backtrackString(String inp, ArrayList<String> list, List<List<String>> ans) {
		if(inp.length() == 0) {
			ans.add(new ArrayList<>(list));
			return;
		}

		for (int i=0; i<inp.length(); i++) {
			String left = inp.substring(0, i+1);
			String right = inp.substring(i+1);

			list.add(left);
			backtrackString(right, list, ans);
			list.remove(list.size()-1);
		}
	}
	
	// Backtracking code for a string - same
	static void backtrackString(String inp, ArrayList<String> list, List<List<String>> ans, int st) {
		if(inp.length() == 0) {
			ans.add(new ArrayList<>(list));
			return;
		}

		for (int i=st; i<inp.length(); i++) {
			String left = inp.substring(st, i+1);			
			String right = inp.substring(i+1);				// same as above just replaced 0 with st

			list.add(left);
			backtrackString(right, list, ans, st);
			list.remove(list.size()-1);
		}
	}
	
	
	// Backtracking code for a int[] - Consistent with backtrackString
	static void backtrack(int[] arr, int start, List<List<Integer>> list, List<List<List<Integer>>> ans) {
        if (start == arr.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // iterates over all possible end positions 4 the next partition segment, 
        // starting 4m the cu start index up to the end of the array.
        for (int i=start; i<arr.length; i++) {
            List<Integer> part = new ArrayList<>();
            
            // Builds the actual subarray (partition segment) from arr[start] to arr[i]
            for (int j=start; j<=i; j++) {
                part.add(arr[j]);
            }

            list.add(part);
            backtrack(arr, i+1, list, ans);
            list.remove(list.size() - 1);
        }
    }
	
	
	// Optimised code for backtrack()
	// currentPartition is List of lists
	static void backtrack1(int[] arr, int start, List<List<Integer>> currentPartition, List<List<List<Integer>>> result) {
	    if (start == arr.length) {
	        // Add a deep copy of current partition to results
	        List<List<Integer>> partitionCopy = new ArrayList<>();
	        for (List<Integer> segment : currentPartition) {
	            partitionCopy.add(new ArrayList<>(segment));
	        }
	        result.add(partitionCopy);
	        return;
	    }

	    List<Integer> part = new ArrayList<>();// Create a new list for every recursion call, = left in backtrackString
	    for (int i=start; i<arr.length; i++) {
	        part.add(arr[i]);  // Incrementally build the current segment
	        
	        currentPartition.add(part);
	        backtrack1(arr, i+1, currentPartition, result);
	        currentPartition.remove(currentPartition.size() - 1);
	        
	        // Important: create a new list for the next iteration
	        part = new ArrayList<>(part);
	    }
	}
	
	
	// Divide and conquer Code
	static List<List<List<Integer>>> partition1(int[] arr, int start, int end) {
        List<List<List<Integer>>> result = new ArrayList<>();

        if (start == end) {
            List<List<Integer>> single = new ArrayList<>();
            single.add(Collections.singletonList(arr[start]));
            result.add(single);
            return result;
        }

        // For every possible split point, make two recursive calls
        for (int i=start; i<end; i++) {
        	
            List<List<List<Integer>>> leftPart = partition1(arr, start, i);
            List<List<List<Integer>>> rightPart = partition1(arr, i+1, end);

            // Combine each left partition with each right partition
            for (List<List<Integer>> left : leftPart) {
                for (List<List<Integer>> right : rightPart) {
                    List<List<Integer>> combined = new ArrayList<>();
                    combined.addAll(left);
                    combined.addAll(right);
                    result.add(combined);
                }
            }
        }

//         Also include the whole segment as one part (no split)
        List<List<Integer>> whole = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        for (int i = start; i <= end; i++) 
        	part.add(arr[i]);
        whole.add(part);
        result.add(whole);

        return result;
    }
	
	static List<List<List<Integer>>> partition2(int[] arr, int start) {
        List<List<List<Integer>>> result = new ArrayList<>();
        if (start == arr.length) {
            result.add(new ArrayList<>());
            return result;
        }
        for (int end = start+1; end <= arr.length; end++) {
            List<Integer> part = new ArrayList<>();
            for (int i = start; i < end; i++) {
                part.add(arr[i]);
            }
            for (List<List<Integer>> rest : partition2(arr, end)) {
                List<List<Integer>> temp = new ArrayList<>();
                temp.add(part);
                temp.addAll(rest);
                result.add(temp);
            }
        }
        return result;
    }

}
