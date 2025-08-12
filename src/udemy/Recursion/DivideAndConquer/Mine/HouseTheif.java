package udemy.Recursion.DivideAndConquer.Mine;

public class HouseTheif {
	
	static int houseValue[] = {6,7,1,30,8,2,4};
	static int size = houseValue.length;
	static int max = 0;
	
	public static void main(String[] args) {
//		boolean vis[] = new boolean[size];
		findCombinationOfHouses(0, houseValue, 0);
		System.out.println(max);
	}
	
//	static int findCombinationOfHouses(int start, int sum, boolean[] vis, int curr){
//		if(start > size)
//			return 0;
//		if(sum > max)
//			max = sum;
//		
//		for(int i=start; i<size; i++){
//			if(!vis[i]) {
//				sum = sum + houseValue[i];
//				vis[i] = true;
//				curr = i;
//				findCombinationOfHouses(i, sum, vis, curr);
//				vis[i] = false;
//				sum = sum - houseValue[i];
//			}
//		}
//		return max;
//	}
	
	static void findCombinationOfHouses(int sum, int houseValue[], int index){
//		if(start > size)
//			return 0;
		if(sum > max)
			max = sum;
		
		if(index >= houseValue.length)
			return;
		
		findCombinationOfHouses(sum+houseValue[index], houseValue, index+2);
		findCombinationOfHouses(sum, houseValue, index+1);
	}
}
