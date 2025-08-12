package Problem_Solving.Backtrack_Recur_DC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 
 * https://youtu.be/caNM6seeJC0
 *
 */
public class SynonymousSentence {

	public static void main(String[] args) {
		SynonymousSentence syn = new SynonymousSentence();
		 HashMap<String, String> parentRef = new HashMap<>();
		 parentRef.put("happy","joy");
		 parentRef.put("sad","sorrow");
		 parentRef.put("joy","cheerful");
		 parentRef.put("excited","elated");
		 parentRef.put("cheerful","excited");
//		 String test = "I am happy today but happy sad yesterday";
//		 System.out.println(test.indexOf("happy", 8));
		syn.findParent("I am happy today but happy sad yesterday", parentRef);
	}
	
	
	String findParent(String s, HashMap<String, String> parentRef) {
        if(parentRef.get(s) == null || parentRef.get(s).equals(s)) {
            parentRef.put(s, s);
            return s;
        } else {
            String parent = parentRef.get(s);
            parentRef.put(s, findParent(parent, parentRef));
            return parentRef.get(parent);
        }
    }
    
    void merge(HashMap<String, String> parentRef, String s1, String s2) {
        parentRef.put(findParent(s1, parentRef), findParent(s2, parentRef));
    }
    
    Map<String, Set<String>> populateGroup(List<List<String>> synonyms, HashMap<String, String> parentRef) {
        for(List<String> synonym : synonyms) {
            merge(parentRef, synonym.get(0), synonym.get(1));
        }
        
        Map<String, Set<String>> output = new HashMap<>();
        for(List<String> synonym : synonyms) {
            output.putIfAbsent(findParent(synonym.get(0), parentRef), new HashSet<>());
            output.get(findParent(synonym.get(0), parentRef)).add(synonym.get(1));
            output.get(findParent(synonym.get(0), parentRef)).add(synonym.get(0));
        }
        
        return output;
    }
    
    void generatePermutationText(HashMap<String, String> parentRef, Map<String, Set<String>> groupedWord, String[] text, int index, List<String> output, String curr) {
        if(index == text.length) {
            output.add(curr);
            return;
        }
        String group = findParent(text[index], parentRef);
        Set<String> wordSets = groupedWord.get(group);
        if(wordSets == null) {
            generatePermutationText(parentRef, groupedWord, text, index + 1, output, curr == null ? text[index] : curr+" "+text[index]);   //don't include the word from dict
        } else {
            for(String word : wordSets) {
                generatePermutationText(parentRef, groupedWord, text, index + 1, output, curr == null ? word : curr+" "+word);		//include the word from dict
            }
        }
    }
    
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        HashMap<String, String> parentRef = new HashMap<>();
        Map<String, Set<String>> groupedWord = populateGroup(synonyms, parentRef);
        List<String> output = new ArrayList<>();
        System.out.println(groupedWord);
        System.out.println(parentRef);
        generatePermutationText(parentRef, groupedWord, text.split(" "), 0, output, null);
        Collections.sort(output);
        return output;
    }
	
//	private String findParent(String s, HashMap<String, String> parentRef) {
//		
//		HashMap<String, List<String>> synonyms = new HashMap<>();		//{joy=[cheerful, elated, excited, joy], happy=[cheerful, elated, excited, happy, joy], sad=[sad, sorrow]}
//		HashMap<String, String> references = new HashMap<>();			//{elated=happy, excited=happy, joy=happy, happy=happy, sad=sad, cheerful=happy, sorrow=sad}
//		
//		for(String key: parentRef.keySet()){
//			List<String> list = new ArrayList<String>();
//			list.add(key);
//			String parent = key;
//			if(references.get(key) == null) {
//				references.put(parentRef.get(key), key);
//				while(parentRef.get(key) != null) {
//					String val = parentRef.get(key);
//					list.add(val);
//					references.put(val, parent);
//					key = val;
//				}
//				Collections.sort(list);
//				synonyms.put(parent, list);
//				references.put(parent, parent);
//			}
//		}
//		
//		int index = 0;
//		for(String temp: s.split(" ")) {
//			System.out.println(temp);
//			int tempIndex;
//			if(references.get(temp) != null) {
//				tempIndex = s.indexOf(temp, index);
//				System.out.println(s.substring(0, tempIndex) + "added" + s.substring(tempIndex+temp.length()));
//			}
//			index = index + temp.length() + 1;
//		}
//		return null;
//	}
}
