package Problem_Solving.Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


//Working
public class MergeKSortedArray {

	public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) 
	{
		PriorityQueue<ArrayContainer> que = new PriorityQueue<ArrayContainer>(new Comparator<ArrayContainer>() {
			@Override
			public int compare(ArrayContainer a, ArrayContainer b) {
				return arrays[a.arrayIndex][a.pos] - arrays[b.arrayIndex][b.pos];
			}
		});
		for(int i=0; i<arrays.length; i++) {
			ArrayContainer tmp = new ArrayContainer(i, 0);
			que.add(tmp);
		}

		ArrayList<Integer> result = new ArrayList<Integer>();
		while(!que.isEmpty()) {
			ArrayContainer temp = que.poll();										//remove the min elem from the heap
			result.add(arrays[temp.arrayIndex][temp.pos]);					// add the removed elem to the answer
			if(arrays[temp.arrayIndex].length > temp.pos+1) {
			    que.add(new ArrayContainer(temp.arrayIndex, temp.pos+1));		//add the elem 4m the same array 4m which the elem is removed
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int arr[][] = {{1,3,4 },{2,3,6},{5,6,7}};
		ArrayList<Integer> result = mergeKArrays(arr, 3);
		for(int no : result) {
			System.out.print(no + " ");
		}
	}
}
class ArrayContainer {				//To keep track of elem and its array
	int arrayIndex;
	int pos;

	public ArrayContainer(int arrayIndex, int pos) {
		this.arrayIndex = arrayIndex;
		this.pos = pos;
	}
}