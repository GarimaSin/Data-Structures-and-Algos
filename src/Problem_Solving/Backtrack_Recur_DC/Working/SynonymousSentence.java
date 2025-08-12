package Problem_Solving.Leetcode.Backtrack_Recur_DC.Working;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SynonymousSentence {

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
			generatePermutationText(parentRef, groupedWord, text, index + 1, output, curr == null ? text[index] : curr+" "+text[index]);
		} else {
			for(String word : wordSets) {
				generatePermutationText(parentRef, groupedWord, text, index + 1, output, curr == null ? word : curr+" "+word);
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
}
