package Problem_Solving.Queue;

public class GasStation {

	public int canCompleteCircuit(int[] petrol, int[] distance) {
        int currPetrol=0, prevPetrol=0, start=0;
        for(int i=0;i<petrol.length;i++){
            currPetrol+=petrol[i] - distance[i];
            if(currPetrol<0){
                start=i+1;	 
                if(currPetrol<0) { 
                    prevPetrol+=currPetrol;	
                    currPetrol=0;
                }
            }
        }
        return (currPetrol + prevPetrol >= 0) ? start: -1;
    }
	
	public static void main(String[] args) {
		
	}
}
