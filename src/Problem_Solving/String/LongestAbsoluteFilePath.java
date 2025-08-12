package Problem_Solving.String;

import java.util.Stack;

public class LongestAbsoluteFilePath {

	public static int lengthLongestPath(String input) {
		int idx = 0;
        int length = input.length();
        int max = 0;
        int pathLength = 0;
        int level=0;
        Stack<String> stack = new Stack<>();
        while(idx < length) {
            
            if(input.charAt(idx) == '\n'){
                idx++;
                continue;
            }
            
            if (input.charAt(idx) == '\t'){
                level++;
                idx++;
                continue;
            }
            
            StringBuilder buffer = new StringBuilder();
            while (idx < length && !(input.charAt(idx) == '\n' || input.charAt(idx) == '\t')){
                buffer.append(input.charAt(idx));
                idx++;
            }
            
            while(level < stack.size()){				//to remove prev level data
                String goBack = stack.pop();
                pathLength = pathLength - goBack.length();
            }
            
            if (buffer.indexOf(".") != -1){     
                //this is a file
                max = Math.max(max, pathLength+buffer.length());
            }else{
                //this is a directory
                buffer.append("/");
                stack.add(buffer.toString());
                pathLength+=buffer.length();
            }
            level = 0;    	        	//coz v r updating level wid every /t in the i/p string
        }
        return max;
    }
	
	public static void main(String[] args) {
		String path = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		lengthLongestPath(path);
	}
}
