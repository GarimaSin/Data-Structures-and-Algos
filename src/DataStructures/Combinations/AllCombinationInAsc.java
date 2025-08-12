package DataStructures.Combinations;

class AllCombinationInAsc {
	 
	//  Remove visited array and rest is same as Unique Combinations
	static boolean vis[];
	static int size;
    public static void main(String[] args) {             
        System.out.println("First Test");
        int set1[] = {1,2,3};
        int k = 2;
        size = set1.length;       
        vis = new boolean[size];
        int a[] = new int[k];
        printAllKLengthRec(set1, a, 0, 0, k);
    }    
 
    static void printAllKLengthRec(int set[], int[] data, int old, int n, int k) {
        if (k == 0) {
        	for (int j=0; j<size; j++)
                System.out.print(data[j]+" ");
            System.out.println("");
            return;
        }
 
        for (int i = 0; i < size; ++i) {
        	if(!vis[i]){
        		vis[i] = true;
        		boolean flag = false;
        		int num = set[i];
        		int big = num;
        		if(old < num){
        			flag = true;
        			data[n] = num;
        			n = n+1;
        			k = k-1;
        		} else
        			big = old;
	            printAllKLengthRec(set, data, big, n, k); 
	            vis[i] = false;
	            if(flag){
	            	n = n-1;
	            	k = k+1;
	            	data[n] = -1;
	            }
        	}
        }
    }
}