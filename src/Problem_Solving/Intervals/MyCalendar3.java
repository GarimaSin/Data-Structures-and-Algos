package Problem_Solving.Intervals;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar3 {

	public static void main(String[] args) {
		System.out.println(book(10,20));
		System.out.println(book(50,60));
		System.out.println(book(10,40));
		System.out.println(book(5,15));
		System.out.println(book(5,10));
		System.out.println(book(25,55));
	}

	static int max = 0;
	static TreeMap<Integer, Integer> map = new TreeMap<>();

	// Working
	public static int book(int startTime, int endTime) {
		max = 0;
		int sum = 0;
		int st = map.getOrDefault(startTime, 0);
		int end = map.getOrDefault(endTime, 0);

		map.put(startTime, st+1);
		map.put(endTime, end-1);

		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
			sum = sum+entry.getValue();
			max = Math.max(max, sum);
		}
		return max;
	}

}
