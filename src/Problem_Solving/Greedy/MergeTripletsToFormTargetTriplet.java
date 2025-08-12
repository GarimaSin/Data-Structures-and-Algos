package Problem_Solving.Greedy;

public class MergeTripletsToFormTargetTriplet {

	//working
	public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean f = false , s = false , t = false;
        for(int[] tri : triplets) {
            if(tri[0] > target[0] || tri[1] > target[1] || tri[2] > target[2]) 
                continue;
            if(tri[0] == target[0]) 
                f = true;
            if(tri[1] == target[1]) 
                s = true;
            if(tri[2] == target[2]) 
                t = true;
            
            if(f && s && t)
                return true;
        }
      return false;
    }
}
