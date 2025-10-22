package Problem_Solving.Backtracking;

import java.util.LinkedList;

public class BeautifulArrangements {

	//TLE
	public static void main(String[] args) {
		LinkedList<Integer> ans = new LinkedList<Integer>();
		int n = 12;
		printAllKLengthRec(n, 0, new boolean[n+1], ans);
		System.out.println(tot);
	}
	
	static int tot = 0;
	static void printAllKLengthRec(int n, int k, boolean[] vis, LinkedList<Integer> ans) {
        if (k >= n) {
        	boolean found = false;
        	int count = 1;
        	for(int i=0; i< ans.size(); i++) {
        		if(ans.get(i) % count == 0 || count%ans.get(i) == 0)
        			found = true;
        		else {
        			found = false;
        			break;
        		}
        		count++;
        	}
        	if(found) {
        		System.out.println(ans);
        		tot++;
        	}
            return;
        }
 
        for (int i = 1; i <= n; ++i) {
        	if(!vis[i]) {
        		vis[i] = true;
        		ans.add(i);
    			printAllKLengthRec(n, k + 1, vis, ans);
    			ans.removeLast();
                vis[i] = false;
        	}
        }
    }
}