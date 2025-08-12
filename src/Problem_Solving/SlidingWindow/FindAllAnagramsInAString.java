package Problem_Solving.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInAString {

	//Working
	public static List<Integer> findAnagrams1(String s, String p) {
		int start=0;
        HashMap<Character,Integer> map=new HashMap<>();
        int end=0;
        int isMatch=0;
        List<Integer>ans=new ArrayList<>();
        
        for(int i=0;i<p.length();i++) {
            char character=p.charAt(i);
            map.put(character,map.getOrDefault(character,0)+1);
        }
        
        while(end<s.length()) {
            char character=s.charAt(end);
            if(map.containsKey(character)) {
                map.put(character, map.get(character)-1);
                if(map.get(character)==0) 
                	isMatch++;
            }
            if(isMatch==map.size()) 
            	ans.add(start);
            
            if(end >= p.length()-1) {
                char new_char=s.charAt(start);
                start++;
                if(map.containsKey(new_char)){
                    if(map.get(new_char)==0) 
                    	isMatch--;
                    map.put(new_char, map.get(new_char)+1);
                }
            }
            end++;
        }
        return ans;
	}

	//Working
	public static List<Integer> findAnagrams(String s, String p) {
		if(p.length() > s.length())
            return new ArrayList<Integer>();
		
        HashMap<Character,Integer> map=new HashMap<>();
        int isMatch=0;
        List<Integer>ans=new ArrayList<>();
        int len = p.length();
        
        for(int i=0; i<len; i++) {
            char character=p.charAt(i);
            map.put(character, map.getOrDefault(character, 0)+1);
        }
        
        for(int i=0; i<len; i++) {
        	char character=s.charAt(i);
            if(map.containsKey(character)){
                map.put(character,map.get(character)-1);
                if(map.get(character)==0) 
                	isMatch++;
            }
            if(isMatch==map.size()) 
            	ans.add(0);
        }
        
        //Remove old
        for(int i=len; i<s.length(); i++) {
        	if(i-len >= 0) {
        		char new_character = s.charAt(i-len);
                if(map.containsKey(new_character)) {
                    if(map.get(new_character)==0) 
                    	isMatch--;
                    map.put(new_character,map.get(new_character)+1);
                }
        	}
        	
        	//Add new
        	char character=s.charAt(i);
            if(map.containsKey(character)) {
                map.put(character,map.get(character)-1);
                if(map.get(character)==0) 
                	isMatch++;
            }
            if(isMatch==map.size()) 
            	ans.add(i-len+1);
        }
        return ans;
	}
		
	//Working
	public List<Integer> findAnagrams2(String s2, String s1) {
        if(s1.length() > s2.length())
            return new ArrayList<Integer>();
        
        int[] frq = new int[26];
        for(char c: s1.toCharArray()) {
            frq[c-'a']++;
        }
        
        int start = 0;
        int end = 0;
        List<Integer>ans=new ArrayList<>();
        
        while(end < s2.length()) {
            char c = s2.charAt(end);
            frq[c-'a']--;
            if(end >= s1.length()-1) {
                if(allZeroes(frq)) {
                   ans.add(start); 
                }
                char tmp = s2.charAt(start);
				frq[tmp-'a']++;
				start++;
            }
            end++;
        }
        return ans;
    }
    
    boolean allZeroes(int[] frq) {
        for(int i=0; i<26; i++) {
            if(frq[i] != 0)
                return false;
        }
        return true;
    }
	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> ans = findAnagrams1(s, p);
		for(int i: ans)
			System.out.println(i);
	}
}