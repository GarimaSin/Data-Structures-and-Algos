package DataStructures.Combinations;

/** 
 *  Works for sorted arrays only 
 * 	vis[] and i+1 both ------------------
 * 
 * O/p for ccd:  (same char 'c' is not printed twice, when adjacent)
 * c
	cc
	ccd
	cd
	d
	
	O/p for cdc:
	c
	cd
	cdc
	cc
	d
	dc
	c
 **/


public class PowerSet_Comb_Unique {
	
	static boolean vis[];
	
	public static void main(String[] args) {
		String str = "ccd"; 
		vis = new boolean[str.length()];
		printSubSeqRec(str, 0, ""); 
	}
	
	static void printSubSeqRec(String str, int index, String curr)  {
		
		System.out.println(curr);				/** shud print b4 return **/
//		if (index == str.length()-1)  
//			return; 

		for (int i = index; i < str.length(); i++) {
			if(i>0 && !vis[i-1] && str.charAt(i) == str.charAt(i-1))  			/** This only works when 2 same chars are adjacent.
																												This is the check for not printing same single char twice. Check above eg. **/
				continue;
			
			if(!vis[i]){
        		vis[i] = true;
				printSubSeqRec(str, i+1, curr+str.charAt(i)); 
				vis[i] = false;
			}
		}
	}
}	
