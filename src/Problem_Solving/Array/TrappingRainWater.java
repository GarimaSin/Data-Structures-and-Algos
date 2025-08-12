package Problem_Solving.Array;

public class TrappingRainWater {

	 
	//Working
    static int findWater(int[] arr)  { 
    	int n = arr.length;				// not length -1.
    	
        // left[i] contains height of tallest bar to the left of i'th bar including itself 
        int left[] = new int[n]; 
  
        // Right [i] contains height of tallest bar to the right of ith bar including itself 
        int right[] = new int[n]; 
        int water = 0; 
  
        // Fill left array 
        left[0] = arr[0]; 
        for (int i = 1; i < n; i++) 
            left[i] = Math.max(left[i - 1], arr[i]); 
  
        // Fill right array 
        right[n - 1] = arr[n - 1]; 
        for (int i = n - 2; i >= 0; i--) 
            right[i] = Math.max(right[i + 1], arr[i]); 
  
        // Calculate the accumulated water element by element consider the amount of water on i'th bar, the 
        // amount of water accumulated on this particular bar will be equal to min(left[i], right[i]) - arr[i] . 
        for (int i = 0; i < n; i++) 
            water += Math.min(left[i], right[i]) - arr[i]; 
  
        return water; 
    } 
    
    public static void main(String[] args) {
    	int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("Maximum water that can be accumulated is " + findWater(height));
    }
}
