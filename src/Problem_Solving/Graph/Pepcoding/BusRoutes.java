package Problem_Solving.Graph.Pepcoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class BusRoutes {

	public static void main(String[] args) {
		int[][] arr = {{1,2,7},{3,6,7}};

		int src = 1;
		int dest = 6;
		System.out.println(numBusesToDestination(arr, src, dest));
	}

	public static int numBusesToDestination(int[][] routes, int S, int T) {
		int n = routes.length;
		HashMap<Integer, ArrayList<Integer>> stopmap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < routes[i].length; j++) {
				int busstop = routes[i][j];

				ArrayList<Integer> busno = stopmap.getOrDefault(busstop, new ArrayList<>());
				busno.add(i);
				stopmap.put(busstop, busno);
			}
		}

		LinkedList<Integer> queue = new LinkedList<>();
		HashSet<Integer> stopvis = new HashSet<>();
		HashSet<Integer> busnovis = new HashSet<>();

		queue.addLast(S);
		stopvis.add(S);
		int level = 0;
		while (queue.size() > 0) {
			int size = queue.size();
			while (size-- > 0) {
				Integer rem = queue.removeFirst();
				if (rem == T) {
					return level;
				}

				ArrayList<Integer> buses = stopmap.get(rem);
				for (int bus : buses) {
					if (busnovis.contains(bus) == true) {
						continue;
					}

					int[] arr = routes[bus];
					for (int stop : arr) {
						if (stopvis.contains(stop) == true) {
							continue;
						}
						queue.addLast(stop);
						stopvis.add(stop);
					}
					busnovis.add(bus);
				}
			}
			level++;
		}
		return -1;
	}
}
