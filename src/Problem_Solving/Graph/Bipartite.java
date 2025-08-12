package Problem_Solving.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Using BFS
public class Bipartite {

	final static int V = 4; // No. of Vertices

	boolean isBipartite(int arr[][], int n)	{
		int[] color = new int[n+1]; 

		ArrayList<Integer> graph[] = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<Integer>();
			color[i] = -1;
		}

		for (int i = 0; i < arr.length; i++) {
			ArrayList<Integer> list = graph[arr[i][0]];
			list.add(arr[i][1]);
			graph[arr[i][0]] = list;

			ArrayList<Integer> list1 = graph[arr[i][1]];
			list1.add(arr[i][0]);
			graph[arr[i][1]] = list1;
		}

		Queue<Integer> que = new LinkedList<>();
		for (int i = 0; i < n+1; i++) {
			if(color[i] == -1) {
				int source = i;
				que.add(source);
				color[source] = 0;
				while(!que.isEmpty()) {
					int tmp = que.remove();
					for(int node: graph[tmp]) {
						if(color[node] == -1) {
							color[node] = 1 - color[tmp];
							que.add(node);
						} else if(color[node] == color[tmp])
							return false;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int dislikes[][] = {{1,2},{1,3},{2,4}};
		Bipartite b = new Bipartite();
		if (b.isBipartite(dislikes, 5))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}