package Problem_Solving.Leetcode.Backtracking;

import java.util.LinkedList;

public class LetterCasePermutation {

	public static void main(String[] args) {
		String s = "a1b2";
		LetterCasePermutation t = new LetterCasePermutation();
		LinkedList<String> output = t.letterCasePermutation(s);
		for(String answer: output) {
			System.out.println(answer);
		}
	}

	private LinkedList<String> letterCasePermutation(String s) {
		LetterCasePermutation t = new LetterCasePermutation();
		return t.letterCasePermutation1(s.toCharArray(), 0, new char[s.length()], new LinkedList<String>(), 0);
		
	}
	private LinkedList<String> letterCasePermutation1(char[] chars, int index, 
			char[] temp,LinkedList<String> list, int i) {
		if(i >= chars.length) {
			list.add(new String(temp));
			return list;
		}
		
		Character extracted = chars[index];
		if(Character.isDigit(extracted)) {
			temp[index] = extracted;
			letterCasePermutation1(chars, index+1, temp, list, i+1);
		} else {
			char c = Character.toLowerCase(chars[i]);
			temp[index] = c;
			letterCasePermutation1(chars, index+1, temp, list, i+1);
			c = Character.toUpperCase(chars[index]);
			temp[index] = c;
			letterCasePermutation1(chars, index+1, temp, list, i+1);
		}
		return list;
	}
}
