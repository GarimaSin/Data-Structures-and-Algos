package Problem_Solving.Array;

public class ContainerWithMostWater {

	 //Working
    public static int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int l = 0;
        int r = height.length-1;
        
        while(r > l) {
            int ht = (r-l) * Math.min(height[l], height[r]);
            max = Math.max(max, ht);
            if(height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
    	int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("Maximum water that can be accumulated is " + maxArea(height));
    }
}
