package Problem_Solving.BinarySearch;

public class SmallestNoGreaterThanTarget {
	public static void main(String[] args) {
		char letters[] = {'c','f','j'};
		char target = 'j';
		char ans = nextGreatestLetter(letters, target);
		System.out.println(ans);
	}

	public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;
        int mid = 0;
        int ans = 0;
        
        while(start <= end) {
            mid = start + (end-start)/2;
//            if(letters[mid] == target)		//coz we dont want the answer as the char itself.
//                return target;
            if(letters[mid] >= target) {
            	ans = mid;
                end = mid-1; 	
            } else {
                start = mid+1;
            }
        }
        if(letters[ans] == target && ans == letters.length-1)
            return letters[0];		//For case: letters = c,f,j, target = j. Here expected ans = c
        else
            return letters[ans];
    }
}