package Problem_Solving.Backtrack_Recur_DC.Working;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber2 {

	Map<String, String> phone = (Map<String, String>) new HashMap<String, String>() {{
	    put("2", "abc");
	    put("3", "def");
	    put("4", "ghi");
	    put("5", "jkl");
	    put("6", "mno");
	    put("7", "pqrs");
	    put("8", "tuv");
	    put("9", "wxyz");
	  }};

	  List<String> output = new ArrayList<String>();
	  
	  public static void main(String[] args) {
		LetterCombinationsPhoneNumber2 lt = new LetterCombinationsPhoneNumber2();
		List<String> list = lt.letterCombinations("234");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i)+" ");
		}
	}

	  public void backtrack(String combination, String next_digits) {
	    // if there is no more digits to check
	    if (next_digits.length() == 0) {					/** Terminate on outer loop **/
	      output.add(combination);
	    }
	    // if there are still digits to check
	    else {
	      // iterate over all letters which map the next available digit
	      String digit = next_digits.substring(0, 1);
	      String letters = phone.get(digit);
	      for (int i = 0; i < letters.length(); i++) {				/** i starts from 0 **/
	        String letter = phone.get(digit).substring(i, i + 1);
	        // append the current letter to the combination and proceed to the next digits
	        backtrack(combination + letter, next_digits.substring(1));
	      }
	    }
	  }

	  public List<String> letterCombinations(String digits) {
	    if (digits.length() != 0)
	      backtrack("", digits);
	    return output;
	  }
}
