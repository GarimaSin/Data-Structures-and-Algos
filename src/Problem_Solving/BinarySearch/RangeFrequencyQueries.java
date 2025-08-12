package Problem_Solving.BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;

public class RangeFrequencyQueries {

	static HashMap<Integer, ArrayList<Integer>> map = null;
	public static void intialize(int[] arr) {
		map = new HashMap<>();

		for(int i=0; i<arr.length; i++) {
			ArrayList<Integer> list = null;              
			if(map.containsKey(arr[i])) {
				list = map.get(arr[i]);
			} else {
				list = new ArrayList<>();
			}
			list.add(i);
			map.put(arr[i], list);
		}
	}

	public static int query(int left, int right, int value) {
		ArrayList<Integer> list = map.get(value);
		if(list == null)
            return 0;
		int i1 = findFirstPosition(list, left);
		int i2 = findLastPosition(list, right);
		if(i1 == -1 || i2 == -1)
            return 0;
		return i2-i1+1;
	}

	public static int findFirstPosition(ArrayList<Integer> list, int left) {
		int start = 0;
		int end = list.size()-1;
		int mid = 0;
		int first = -1;

		while(start <= end) {
			mid = start + (end - start)/2;
			if(list.get(mid) == left) {
				return mid;
			} else if(list.get(mid) > left) {
				first = mid;
				end = mid-1;
			} else
				start = mid+1;
		}
		return first;
	}

	public static int findLastPosition(ArrayList<Integer> list, int right) {
		int start = 0;
		int end = list.size()-1;
		int mid = 0;
		int last = -1;

		while(start <= end) {
			mid = start + (end - start)/2;
			if(list.get(mid) == right) {
				return mid;
			} else if(list.get(mid) > right) {
				end = mid-1;
			} else {
				last = mid;
				start = mid+1;
			}
		}
		return last;
	}
	
	public static void main(String[] args) {
		int[] nums = {8,4,2,5,4,5,8,6,2,3};
		intialize(nums);
//		System.out.println(query(0,3,5));
//		System.out.println(query(5,6,2));
		System.out.println(query(6,8,4));
//		System.out.println(query(2,8,3));
//		System.out.println(query(4,5,1));
//		System.out.println(query(2,4,2));
	}
}
