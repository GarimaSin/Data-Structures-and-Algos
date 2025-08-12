package Problem_Solving.Graph.Pepcoding;

import java.util.Arrays;

public class RemoveMaxNoOfEdgesToKeepGraphFullyTraversable {

	public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a,b) -> Integer.compare(b[0], a[0]));
        int[] parenta = new int[n+1];
        int[] parentb = new int[n+1];
        int[] ranka = new int[n+1];
        int[] rankb = new int[n+1];
        
        for(int i=0; i<parenta.length; i++) {
            parenta[i] = i;
            parentb[i] = i;
            ranka[i] = 1;
            rankb[i] = 1;
        }
        
        int mergeda = 1;
        int mergedb = 1;
        int removedEdges = 0;
        for(int[] e: edges) {
            if(e[0] == 3) {
                boolean tempa = union(e[1], e[2], parenta, ranka);
                boolean tempb = union(e[1], e[2], parentb, rankb);
                if(tempa == true)
                    mergeda++;
                if(tempb == true)
                    mergedb++;
                if(tempa == false && tempb == false) 
                    removedEdges++;
            } else if(e[0] == 1) {
                boolean tempa = union(e[1], e[2], parenta, ranka);
                if(tempa == true)
                    mergeda++;
                else
                    removedEdges++;
            } else {
                boolean tempb = union(e[1], e[2], parentb, rankb);
                if(tempb == true)
                    mergedb++;
                else
                    removedEdges++;
            }
        }
        if(mergeda != n || mergedb != n) 
            return -1;
        return removedEdges;
    }
    
    int find(int x, int[] parent) {
		if(parent[x] == x) {
			return x;
		}
		
		int tmp = find(parent[x], parent);
		parent[x] = tmp;
		return tmp;
	}
	
	boolean union(int x, int y, int[] parent, int[] rank) {
		int lx = find(x, parent);
		int ly = find(y, parent);
		if(lx != ly) {
			if(rank[lx] > rank[ly]) {
				parent[ly] = lx;
			} else if (rank[lx] < rank[ly]) {
				parent[lx] = ly;
			} else {
				parent[lx] = ly;
				rank[ly]++;
			}
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int n = 4;
		int[][] edges = {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
		RemoveMaxNoOfEdgesToKeepGraphFullyTraversable o = new RemoveMaxNoOfEdgesToKeepGraphFullyTraversable();
		int count = o.maxNumEdgesToRemove(n, edges);
		System.out.println(count);
	}

}
