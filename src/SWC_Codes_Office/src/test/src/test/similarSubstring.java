package SWC_Codes_Office.src.test.src.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class similarSubstring {
	static int count = 0;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("day5.txt"));
		for(int test_case = 1; test_case <= 30; test_case++) {
			count = 0;
			String input = sc.next();
			char first = input.charAt(0);
	        String temp = first+"";
	        if(input.length() > 1){
		        for(int i=1; i<input.length(); i++){
		            if(temp.charAt(0)== input.charAt(i)){
		                temp = temp + input.charAt(i);
		            } else {
		                generateSequence(0, 1, temp);
		                temp = "";
		                temp = temp + input.charAt(i);
		            }
		            if(i == input.length()-1)
		                generateSequence(0, 1, temp);
		        }
		        System.out.println("#"+test_case+" "+count);
	        } else if(input.length() == 0)
	        	 System.out.println("#"+test_case+" "+0);
	        else
	        	 System.out.println("#"+test_case+" "+1);
		}
	}
	
	private static void generateSequence(int start, int end, String in) {
        if(start >= in.length() || (start == in.length() && end == in.length())){
        	return;
        } else {
        	if(end == in.length()+1)
        		generateSequence(start+1, start+2, in);
        	else{
//        		System.out.println(in.substring(start, end));
        		count = count + 1;
        		generateSequence(start, end+1, in);
        	}
        }
    }

//	private static void generateSequence(int start, int end, String in) {
//        if(start == in.length() && end == in.length()){
//            return;
//        }else{
//            if(end == in.length()+1){
//                generateSequence(start + 1, start + 1, in);
//            }else{
//                if(start != end) {
//                    System.out.println(in.substring(start, end));
//                    count = count + 1;
//                }
//                generateSequence(start, end+1,in);
//            }
//        }
//    }
}

