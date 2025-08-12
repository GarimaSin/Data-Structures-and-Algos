package Problem_Solving.Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

	public static void main(String[] args) {
		RestoreIPAddresses ip = new RestoreIPAddresses();
//		List<String> answer = ip.restoreIpAddresses("25525511135");
		restoreIpsMySol("25525511135", "", 0);
	}
	
	//Working
	static public void restoreIpsMySol(String s, String ans, int count) {
    	if(count > 4) 
    		return;
    	if(count == 4) {
    		if(s.length() == 0)
    			System.out.println(ans);
    		else
    			return;
    	}
    	
    	int tmp = 3;
    	if(s.length() < 3)
    		tmp = s.length();
    	
        for (int i = 0; i < tmp; i++) {
			String left = s.substring(0,i+1);
			if(!isValid(left))
				continue;
			String right = s.substring(i+1);
			if(ans == "")
				restoreIpsMySol(right, ans+left, count+1);
			else
				restoreIpsMySol(right, ans+"."+left, count+1);
		}
    }
	
	public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        for(int i = 1; i<4 && i<len-2; i++){
            for(int j = i+1; j<i+4 && j<len-1; j++){
                for(int k = j+1; k<j+4 && k<len; k++){
                    String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }
    public static boolean isValid(String s){
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
            return false;
        return true;
    }
}
