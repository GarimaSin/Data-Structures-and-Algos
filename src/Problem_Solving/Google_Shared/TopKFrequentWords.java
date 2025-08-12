package Problem_Solving.Google_Shared;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
	public static void main(String[] args) {
		String inp[] = {"aa","aa","aa","cc","aa","cc","cc","dd","ee","ee","dd","ff"};
		List<String> ans = topKFrequent(inp, 4);
		List<String> ans1 = topKFrequent1(inp, 4);
		for(int i=0; i<ans.size(); i++) {
			System.out.println(ans.get(i));
		}
		System.out.println("---------------------");
		for(int i=0; i<ans1.size(); i++) {
			System.out.println(ans1.get(i));
		}
	}
	
	//Working - simple
	public static List<String> topKFrequent1(String[] words, int k) {
		List<String> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++) {
            if(map.containsKey(words[i]))
                map.put(words[i], map.get(words[i])+1);
            else
                map.put(words[i], 1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                 (a,b) -> a.getValue()==b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue().compareTo(a.getValue())
        );
        
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            pq.offer(entry);
        }
        while(!pq.isEmpty() && k>0)	{
            result.add(pq.poll().getKey());
            k--;
        }
        return result;
	}

	//Working
	public static List<String> topKFrequent(String[] words, int k) {
		List<String> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++) {
            if(map.containsKey(words[i]))
                map.put(words[i], map.get(words[i])+1);
            else
                map.put(words[i], 1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                 (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue().compareTo(b.getValue())
        );
        
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            pq.offer(entry);
            if(pq.size()>k)
                pq.poll();
        }

        while(!pq.isEmpty())
            result.add(0, pq.poll().getKey());		//add the items at index 0, in front like queue
        
        return result;
	}
}