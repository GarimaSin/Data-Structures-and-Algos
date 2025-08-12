package Problem_Solving.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops {

	//Working for 47/51, TLE
	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[n];
		for (int i = 0; i <n; i++) {
			graph[i] = new ArrayList<>();
		}

		for(int[] arr: flights) {
			int from = arr[0];
			int dest = arr[1];
			int weight = arr[2];
			ArrayList<Edge> list = graph[from];
			list.add(new Edge(dest, weight, 1));
			graph[from] = list;
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(src, 0, 0));
		HashSet<Integer> vis = new HashSet<Integer>();
//		int stops = -1;
		while(!pq.isEmpty()) {
			Edge e = pq.remove();
			int to = e.to;
			int wt = e.wt;
			int lvl = e.stops;
			if(to == dst)
				return e.wt;
			if (vis.contains(to) || lvl > k) 
				continue;
			ArrayList<Edge> edges = graph[to];
			if(edges != null) {
				for(Edge l: edges) {
					if(!vis.contains(l.to)) {
						if(l.wt >=  e.stops+1)
							pq.add(new Edge(l.to, l.wt+wt, e.stops+1));
					}
				}
			}
		}
		return -1;
	}
	
	
	//Working
	public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
        // city, price, stop
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] flight : flights) {
            if (!graph.containsKey(flight[0])) {
                graph.put(flight[0], new HashMap<>());
            }
            graph.get(flight[0]).put(flight[1], flight[2]);
        }
        
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;
        int[] stops = new int[n]; // Shortest stops so far
        Arrays.fill(stops, Integer.MAX_VALUE);
        stops[src] = 0;

        queue.offer(new int[]{src, 0, 0});
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int cur = top[0];
            int curPrice = top[1];
            int curStop = top[2];
            if (cur == dst) {
                return curPrice;
            }
            
            if (curStop == k + 1) {
                continue;
            }
            
            Map<Integer, Integer> next = graph.get(cur);
            if (next != null) {
                for (int key : next.keySet()) {
                    int newCost = curPrice + next.get(key);
                    int newStop = curStop + 1;
                    if (newCost < costs[key] || newStop < stops[key]) {
                        queue.offer(new int[]{key, newCost, newStop});
                        costs[key] = newCost;
                        stops[key] = newStop;
                    }
                }
            }            
        }
        return -1;
    }
	
	public static void main(String[] args) {
		int n = 4, src = 0, dst = 3, k = 1;
		int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
		int ans = findCheapestPrice(n, flights, src, dst, k);
		System.out.println(ans);
	}
}

class Edge implements Comparable<Edge>{
	int to;
	int wt;
	int stops = 1;

	public int compareTo(Edge n1) {
		return this.wt-n1.wt;
	}

	Edge(int to, int wt, int level) {
		this.to = to;
		this.wt = wt;
		this.stops = level;
	}
}
