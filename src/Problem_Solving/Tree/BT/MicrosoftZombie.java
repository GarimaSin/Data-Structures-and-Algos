package Problem_Solving.Tree.BT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MicrosoftZombie {
	
	public static String solution(int[] A, int[] B) {
        int N = A.length;
        int Z = B.length;

        // Build adjacency list for the tree
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i < N; i++) {
            int parent = A[i];
            tree.get(parent).add(i);
            tree.get(i).add(parent);
        }

        // BFS to calculate distance from capital (node 0) to all other nodes
        int[] distances = new int[N];
        Arrays.fill(distances, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        distances[0] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int currentDistance = distances[node];
            for (int neighbor : tree.get(node)) {
                if (distances[neighbor] == -1) {  // not visited
                    distances[neighbor] = currentDistance + 1;
                    queue.add(neighbor);
                }
            }
        }

        // Calculate the maximum distance of zombies
        int maxZombieDistance = 0;
        for (int zombie : B) {
            maxZombieDistance = Math.max(maxZombieDistance, distances[zombie]);
        }

        // Calculate the total time needed by the doctor
        int totalDoctorTime = 0;
        for (int zombie : B) {
            totalDoctorTime += 2 * distances[zombie];
        }

        // Compare the doctor's total time with the maximum zombie distance
        if (totalDoctorTime <= maxZombieDistance) {
            return "Doable";
        } else {
            return "Hopeless";
        }
    }

    public static void main(String[] args) {
    	int[] A1 = {-1, 0};
        int[] B1 = {1};
        System.out.println(canSaveIsland(A1, B1));  // Expected: "Hopeless"

//        int[] A2 = {1, -1, 0, 0};
//        int[] B2 = {1};
        System.out.println(5/2);
        int[] A2 = {-1, 0, 1, 2, 3, 4, 5, 6};
        int[] B2 = {4, 7};
        System.out.println(canSaveIsland(A2, B2));  // Expected: "Hopeless"
    }

	private static String canSaveIsland(int[] a, int[] b) {
		if(a == null)
			return "Hopeless";
		if(b == null)
			return "Doable";
		
		//Assuming b[] is sorted
		int time = (b[0]/2)*2;
		if(time <= 0)
			return "Hopeless";
		
		for(int i=1; i<b.length; i++) {
			int tmp = b[i] - time;
			if(tmp <= 0)
				return "Hopeless";
			else
				time = time + ((tmp/2)*2);
		}
		return "Doable";
	}

}
