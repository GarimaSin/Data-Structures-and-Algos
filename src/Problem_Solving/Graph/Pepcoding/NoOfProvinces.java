package Problem_Solving.Graph.Pepcoding;

public class NoOfProvinces {

	private int[] root;
	private int[] rank;
	public int findCircleNum(int[][] isConnected) {
		int size  = isConnected.length;
		root=new int[size];
		rank=new int[size];

		for(int i=0;i<size;i++){
			root[i]=i;
			rank[i]=1;
		}

		for(int i=0;i<size;i++){
			for(int j=0;j<isConnected[0].length;j++){
				if(isConnected[i][j]==1)
					union(i,j);
			}
		}
		return noOfRoots();
	}

	public int find(int x){
		if(x==root[x])
			return x;
		return root[x] = find(root[x]);
	}

	public void union(int x, int y){
		int rootX =find(x);
		int rootY =find(y);

		if(rootX != rootY){
			if(rank[rootX]>rank[rootY])
				root[rootY]=rootX;
			else if(rank[rootX]<rank[rootY])
				root[rootX]=rootY;
			else{
				root[rootY]=rootX;
				rank[rootX] += 1;
			}
		}
	}

	public int noOfRoots() {
		int cnt = 0;
		for (int i = 0; i < root.length; i++)
			if (root[i] == i) {
				cnt++;
			}
		return cnt;
	}
}
