package Problem_Solving.Blind75.Array;

//https://youtu.be/VMtyGnNcdPw
public class KadaneAlgo {

	static int findMax(int[] arr) {
		int currSum = arr[0];
		int maxSum = arr[0];
		int start = 0;						//Starting index
		int end = 0;							//ending index
		for (int i = 1; i < arr.length; i++) {
			if(currSum >= 0) {					//if previous sum > 0 then add the current val to prev
				currSum += arr[i];
			}
			else	{									// else leave the prev value and start a new subarray from this index.
				currSum = arr[i];
				start = i;
				end = i;
			}
			if(currSum > maxSum)	{
				end = i;
				maxSum = currSum;
			}
		}
		System.out.println(maxSum + "  start = "+start+", end = "+end);
		return maxSum;
	}
	
	//Same code as above, removed start and end
	public static int maxSubArray(int[] nums) {
        int currSum = nums[0];
		int maxSum = nums[0];
        
		for (int i = 1; i < nums.length; i++) {
			if(currSum >= 0) 					// 	currSum is not -ve
				currSum += nums[i];
			else 								
				currSum = nums[i];		//for all -ve nos.
			
		    maxSum = Math.max(currSum, maxSum);
		}
		return maxSum;    
    }
	
	public static void main(String[] args) {
		int arr[] = {-2, -3, -1};
		maxSubArray(arr);
	}
}
