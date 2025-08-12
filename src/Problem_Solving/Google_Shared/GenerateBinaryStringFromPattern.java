package Problem_Solving.Google_Shared;

import java.util.Stack;

public class GenerateBinaryStringFromPattern {

    // Find all binary strings that can be formed from given wildcard pattern
    public static void printAllCombinations(String pattern) {
        // create an empty stack (we can also use set, queue, vector
        // or any other container)
        Stack<String> stack = new Stack();
        stack.push(pattern);        // push the pattern into the stack

        int index;

        // do till stack is not empty
        while (!stack.empty())  {
            // pop string from stack and process it
            String curr = stack.pop();

            // index stores position of first occurrence of wildcard pattern in curr
            if ((index = curr.indexOf('?')) != -1) {
                // replace '?' with 0 and 1 and push it to the stack
                for (char ch = '0'; ch <= '1'; ch++) {
                    curr = curr.substring(0, index) + ch + 
							curr.substring(index + 1);
                    stack.push(curr);
                }
            }

            // If no wildcard pattern is found, print the string
            else
                System.out.println(curr);
        }
    }

    public static void main(String[] args)  {
        String str = "1?11?00?1?";
        printAllCombinations(str);
    }
}
