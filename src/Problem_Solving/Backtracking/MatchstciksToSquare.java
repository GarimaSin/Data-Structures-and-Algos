package Problem_Solving.Leetcode.Backtracking;

import java.util.Arrays;

public class MatchstciksToSquare {

	//TLE
	public static void main(String[] args) {
		int[] nums = {1,1,2,2,2};
		System.out.println(makeSquare(nums));
	}
	
	static public boolean makeSquare(int[] matchsticks) {
        int n = matchsticks.length;
        if(n < 4) 
        	return false;
        
        int perimeter = 0;
        for(int stick : matchsticks) 
        	perimeter += stick;
        
        //check perimeter is valid or not
        if(perimeter % 4 != 0) 
        	return false;
        
        Arrays.sort(matchsticks);
        int squareSide = perimeter / 4;
        
        if(matchsticks[n - 1] > squareSide) 
        	return false;
        return canFormSquare(matchsticks, new int[4], 0, squareSide);
    }
    
    private static boolean canFormSquare(int[] matchsticks, int[] sides, int index, int squareSide){
        if(index == matchsticks.length){
            return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3] && sides[3] == sides[0];
        }
        
        int stick = matchsticks[index];
        
        for(int i = 0; i < 4; i++){
            //ignore this side if add new stick will greater than valid square side
            if(sides[i] + stick > squareSide) continue;
            
            sides[i] += stick;
            if(canFormSquare(matchsticks, sides, index + 1, squareSide)) 
            	return true;
            sides[i] -= stick;
        }
        return false;
    }
}
