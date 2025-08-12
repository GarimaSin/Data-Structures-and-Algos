package Problem_Solving.Array.Pepcoding;

public class PushDominoes {

	public static String pushDominoes(String dominoes) {
		dominoes = "L"+dominoes+"R";
		String tmp = "";
		char start = ' ';
		char end = ' ';
		String ans = "";
		for(char ch: dominoes.toCharArray()) {
			if(ch == 'L' || ch == 'R') {
				if(start == ' ') {
					start = ch;
					end = ' ';
				} else {
					end = ch;
					ans = ans + findAlignment(tmp, start, end);
					start = ' ';
				}
			} else {
				tmp = tmp + ch;
			}
		}
		return ans.substring(1,ans.length()-2);
	}

	public static String findAlignment(String inp, char st, char end) {
		String ans = st+"";
		if(st == 'L' && end == 'L') {
			for(int i =0; i< inp.length(); i++) {
				ans = ans + "L";
			}
			return ans+end;
		}
		if(st == 'L' && end == 'R') {
			return inp;
		}
		if(st == 'R' && end == 'L') {
			String tmp = "";
			if(inp.length() % 2 == 0) {
				for(int i =0; i< inp.length()/2; i++) {
					ans = ans + "L";
					tmp = tmp + "R";
				}
				return tmp + ans+end;
			} else {
				return tmp+"."+ans+end;
			}
		}
		if(st == 'R' && end == 'R') {
			for(int i =0; i< inp.length(); i++) {
				ans = ans + "R";
				return ans+end;
			}
		}
		return ans+end;
	}
	
	
	public static void main(String[] args) {
		System.out.println(pushDominoes("RR.L"));
	}
}
