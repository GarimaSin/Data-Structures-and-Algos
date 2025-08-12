package InterviewExperience.Broadcom;
import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

	public static void generateParenthesis(int n) {
        backtrack(new ArrayList<String>(), "", 0, 0, n);
    }
	
	public static void main(String[] args) {
		generateParenthesis(3);
	}

	public static void backtrack(List<String> ans, String string, int open, int close, int n) {
		if(string.length() > n*2) {
			return;
		}
		if(close > n || open > n || close>open)
			return;
		
		if(string.length() == n*2) {
			ans.add(string);
			System.out.println(string);
//			return ;
		}
		backtrack(ans, string+ "(", open+1, close, n);
		backtrack(ans, string+ ")", open, close+1, n);
	}
}
