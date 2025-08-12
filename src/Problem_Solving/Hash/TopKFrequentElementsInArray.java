package Problem_Solving.Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentElementsInArray {
	
	public static int[] topK(int[] nums, int k) {
//		PriorityQueue<Map.Entry<Integer, Integer>> que = new PriorityQueue<Map.Entry<Integer, Integer>>(
//				new Comparator<Map.Entry<Integer, Integer>>(){
//					@Override
//					public  int compare(Entry<Integer, Integer> a, Entry<Integer, Integer> b) {
//						if(a.getKey() == b.getKey())
//							return b.getKey().compareTo(a.getKey());
//						return a.getValue().compareTo(b.getValue()); 
//					}
//				});
		
		PriorityQueue<Map.Entry<Integer, Integer>> que = new PriorityQueue<>(
		        (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : b.getValue().compareTo(a.getValue())
		        		//Sort in decreasing order
		   );


		HashMap<Integer, Integer> map = new HashMap<>();  
		for(int num: nums) {
			if(map.containsKey(num))
				map.put(num, map.get(num) + 1);
			else
				map.put(num, 1);
		}

		for(Entry<Integer, Integer> entry: map.entrySet()){
			que.add(entry);
		}

		int result[] = new int[k];
		for(int i=0; i<k; i++) {
			result[i] = que.remove().getKey();
		}
		return result;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,1,2,2,3,3,3,4};
		int ans[] = topK(arr, 2);
		for(int no: ans) {
			System.out.println(no);
		}
	}
}
