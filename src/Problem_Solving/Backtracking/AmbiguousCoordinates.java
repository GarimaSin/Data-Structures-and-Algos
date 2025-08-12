package Problem_Solving.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates {

	//Working but not for 0 wale cases
	public static void main(String[] args) {
		System.out.println(ambiguousCoordinates("00011"));
	}

	public static List<String> ambiguousCoordinates(String s) {
		List<String> ans = new ArrayList<>();
		for (int i = 1; i < s.length(); ++i) {
			String s1 = s.substring(0,i);
			String s2 = s.substring(i);
//			if((s1.length() > 1 && Long.valueOf(s1) == 0) || (s2.length() > 1 && Long.valueOf(s2) == 0)) 
//				continue;
			List<String> left = createCoordinates(s1);
			List<String> right = createCoordinates(s2);
			for(String l: left) {
				for(String r: right) {
					ans.add(l+","+r);
				}
			}
		}
		return ans;
	}

	private static List<String> createCoordinates(String s) {
		ArrayList<String> ans = new ArrayList<String>();
		if(s.length() == 0) {
			ans.add("");
			return ans;
		}
		else if(s.length() == 1)	{
			ans.add(s);
			return ans;
		}
		else if(s.length() == 2) {
			ans.add(s);
//			String right = s.substring(1);
			ans.add(s.substring(0, 1) + "."+s.substring(1));
			return ans;
		} else {
			ans.add(s);
			for(int i = 1; i<s.length(); i++) {
				String left = s.substring(0,i);
				String right = s.substring(i);
				ans.add(left+"."+right);
			}
		}
		return ans;
	}
}