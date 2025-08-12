package Problem_Solving.Leetcode.Backtracking;

public class NextCombination {

	static int[] nextCombination; // indexes of chars for the next combination
	static int combinationLength;
	static char[] characters; // the base string with all the characters as an array
	StringBuilder sb = new StringBuilder();
	
	private void getNextCombination(){
		boolean combinationFound = false;
		//go from right to left and look for the first element that can be increased
		for (int i=combinationLength-1; i>=0 && !combinationFound; i--){
			//max value of the current element
			int maxValue = characters.length-1 //The max element
					- (combinationLength-i-1); //the index offset of the current element
			if (nextCombination[i]<maxValue){
				nextCombination[i]++;
				//the element was increased, let's change all the right elements
				for (int j = 1; j+i<combinationLength; j++){
					//j is an index offset from the current (i) element to the right
					nextCombination[j+i] = nextCombination[i]+j;
				}
				combinationFound = true;
			}
		}

		if (!combinationFound)
			//all the combinations were used, let's use the first element as a flag
			nextCombination[0]=-1;        
	}
	
	public String next() {
        if (!hasNext())
            return "";
        
        sb.delete(0, sb.length());
        for (int n:nextCombination)            
            sb.append(characters[n]);
        
        //This combination is already used, let's generate one for the next call
        getNextCombination();
        
        return sb.toString();
    }
	
	public boolean hasNext() {
        //The negative first element of a combination is used as a flag
        return nextCombination[0]!=-1;
    }
	
	public static void main(String[] args) {
		String str = "abcde";
		combinationLength = 3;
		characters = str.toCharArray();
        nextCombination = new int[combinationLength];
		
        //Fill the first combination with first characters
        for (int i=0; i<combinationLength; i++)
            nextCombination[i]=i;
	}	
}