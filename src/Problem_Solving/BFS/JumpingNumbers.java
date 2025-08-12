package Problem_Solving.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class JumpingNumbers {

	public static void bfs(int target, int num) {
        // Create a queue and enqueue 'i' to it
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(num);
  
        // Do BFS starting from i
        while (!q.isEmpty()) {
            num = q.peek();
            q.poll();
            if (num <= target) {
                System.out.print(num + " ");
                int last_digit = num % 10;
  
                // If last digit is 0, append next digit only
                if (last_digit == 0) {
                    q.add((num * 10) + (last_digit + 1));
                }
                // If last digit is 9, append previous digit only
                else if (last_digit == 9) {
                    q.add((num * 10) + (last_digit - 1));
                }
                // If last digit is neither 0 nor 9, append both 
                //previous and next digits
                else {
                    q.add((num * 10) + (last_digit - 1));
                    q.add((num * 10) + (last_digit + 1));
                }
            }
        }
    }
  
    // Prints all jumping numbers smaller than or equal to a positive number x
    public static void printJumping(int x)  {
        System.out.print("0 ");
        for (int i = 1; i <= 9 && i <= x; i++) {
            bfs(x, i);
        }
    }
  
    public static void main(String[] args)  {
        int x = 40;
        printJumping(x);
    }
}
