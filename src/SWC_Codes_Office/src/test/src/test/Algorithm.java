package test.src.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Algorithm {

	static LinkedList<String> list1 = null;
	static LinkedList<String> list2 = null;
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("t.txt"));

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			String inp = sc.next();
			list1 = new LinkedList<String>();
			list2 = new LinkedList<String>();
			char val = 'X';
			for(int i=0;i<inp.length();i++){
				if(inp.charAt(i)=='('){
					pushs(new Character(inp.charAt(i)).toString(), list1);
				} else if(inp.charAt(i) == '['){
					pushs(new Character(inp.charAt(i)).toString(), list2);
				} else if(list1.size() !=0 && inp.charAt(i) == ')'){
					pop(list1);
				} else if (list2.size() !=0 && inp.charAt(i) == ']')
					pop(list2);
				else
					val = 'N';
			}
			if(list1.size()==0 && list2.size()==0 && val != 'N')
				val='Y';
			System.out.println("Case #"+(test_case+1)+" ");
			System.out.println(val);
		}
	}
	
	public static void pushs(String s, LinkedList<String> l){
		l.addLast(s);
	}
	
	public static void pop(LinkedList<String> l){
		l.removeLast();
	}
}

