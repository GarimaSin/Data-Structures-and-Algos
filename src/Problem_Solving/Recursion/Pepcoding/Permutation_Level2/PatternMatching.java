package Problem_Solving.Recursion.Pepcoding.Permutation_Level2;

import java.util.HashMap;
import java.util.HashSet;

public class PatternMatching {

	public static void solution(String str, String pattern, HashMap<Character,String> map, String op){
		if(pattern.length() == 0) {
			if(str.length() == 0) {
				HashSet<Character> alreadyPrinted = new  HashSet<>(); 
				for (int i = 0; i < op.length(); i++) {
					char ch = op.charAt(i);
					if(alreadyPrinted.contains(ch) == false) {
						System.out.println(ch+" -> "+map.get(ch) + ", ");
						alreadyPrinted.add(ch);
					}
				}
				System.out.println();
			}
			return;
		}
		
		char ch = pattern.charAt(0);
		String patternLeft = pattern.substring(1);
		
		if(map.containsKey(ch)) {
			String prevMapping = map.get(ch);
			
			if(str.length() >=  prevMapping.length()) {
				String left = str.substring(0, prevMapping.length());
				String right = str.substring(prevMapping.length());
				if(prevMapping.equals(left))
					solution(right, patternLeft, map, op);
			}
		} else {
			for (int i = 0; i < str.length(); i++) {
				String left = str.substring(0, i+1);
				String right = str.substring(i+1);
				map.put(ch, left);
				solution(right, patternLeft, map, op);
				map.remove(ch);
			}
		}
	}
	
	public static void main(String[] args) {
		String str = "graphtreesgraph";
		String pattern = "pep";
		HashMap<Character,String> map = new HashMap<>();
		solution(str,pattern,map,pattern);
	}
}