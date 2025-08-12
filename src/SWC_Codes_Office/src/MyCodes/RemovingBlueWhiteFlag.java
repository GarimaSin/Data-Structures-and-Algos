package MyCodes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RemovingBlueWhiteFlag {

	static int size = 0;
	static boolean ans;
//	static int[] flags;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("RemovingFlag.txt"));
        int T;
        T=sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
        	size = sc.nextInt();
        	ans = false;
        	int blueFlags = 0;
        	int[] flags = new int[size];
        	int[] index = new int[size];
        	boolean[] visited = new boolean[size];
        	for(int i=0; i<size; i++){
        		flags[i] = sc.nextInt();
        		index[i] = -1;
        		if(flags[i] == 1)
        			blueFlags++;
        	}
        	
        	int answer[] = removeFlags(flags, index, visited, blueFlags, 0);
        	if(ans){
        		for(int i=0; i<size; i++){
            		System.out.print(answer[i]+" ");
            	}
            	System.out.println("   ");
        	}
        	else
        		System.out.println(-1);
        }
	}

	private static int[] removeFlags(int[] flags, int[] index, boolean[] visited, int blueFlags, int count) {
//		if(blueFlags == 0 || count >= size){
		if(count >= size){
			ans = true;
			return index;
		}
		int before = 0;
		int after = 0;
		int blueAdded = 0;
		boolean bef = false, aft = false;
		
		for(int i=0; i<size; i++){
			if(!visited[i] && flags[i] == 0){
				visited[i] = true;
				if(i-1 >= 0 && flags[i-1] != -1){
					bef = true;
					before = flags[i-1];
					if(flags[i-1] == 1){
						flags[i-1] = 0;
//						blueFlags = blueFlags - 1;
//						blueAdded = blueAdded - 1;
					}
					else {
						flags[i-1] = 1;
//						blueFlags = blueFlags+1;
//						blueAdded = blueAdded +1;
					}
				} 
				if(i+1 < size && flags[i+1] != -1){
					aft = true;
					after = flags[i+1];
					if(flags[i+1] == 1) {
						flags[i+1] = 0;
//						blueFlags = blueFlags - 1;
//						blueAdded = blueAdded - 1;
					}
					else {
						flags[i+1] = 1;
//						blueFlags = blueFlags+1;
//						blueAdded = blueAdded +1;
					}
				}
				flags[i] = -1;
				index[count] = i+1;
				removeFlags(flags, index, visited, blueFlags-1, count+1);
				if(ans)
					return index;
				else{
					visited[i] = false;
					index[i] = -1;
					if(bef)
						flags[i-1] = before;
					if(aft)
						flags[i+1] = after;
					flags[i] = 0;
//					blueFlags = blueFlags - blueAdded;
				}
			}
		}
		return index;
	}

}
