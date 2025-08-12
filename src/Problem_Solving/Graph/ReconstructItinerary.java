package Problem_Solving.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {

	public static List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> list: tickets) {
            String key = list.get(0);
            PriorityQueue<String> pq = null;
            if(map.containsKey(key)) {
                pq = map.get(key);
            } else {
                pq = new PriorityQueue<>();
            }
            pq.add(list.get(1));
            map.put(key, pq);
        }
        LinkedList<String> ans = new LinkedList<>();
        dfs("JFK", map, ans);
        return ans;
    }
	
	public static void dfs(String dep, Map<String, PriorityQueue<String>> hm, LinkedList<String> res) {
        PriorityQueue<String> arrivals = hm.get(dep);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(), hm, res);
        }

        res.addFirst(dep);
    }
	
	public static void main(String[] args) {
		List<List<String>> list = new ArrayList<List<String>>();
		String[][] arr = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		for(String[] a: arr) {
			ArrayList<String> l = new ArrayList<String>();
			l.add(a[0]);
			l.add(a[1]);
			list.add(l);
		}
		findItinerary(list);
	}
}
