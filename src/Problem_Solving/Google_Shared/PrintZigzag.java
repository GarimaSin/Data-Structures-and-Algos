package Problem_Solving.Google_Shared;


public class PrintZigzag {
	// Function that takes string and zigzag offset 
	static void fun(String s, int n) { 

		if (n == 1)   { 
			System.out.print(s);              
			return; 
		} 

		int len = s.length();  

		// Create a 2d character array 
		char [][]a = new char[len][len]; 
		char []c = s.toCharArray(); 

		// for counting the rows of the ZigZag 
		int row = 0;          
		boolean down = true; 

		for (int i = 0; i < len; i++) { 
			// put characters in the matrix 
			a[row][i] = c[i];  

			// You have reached the bottom 
			if (row == n - 1) 
				down = false;      
			else if (row == 0) 
				down = true;  

			if(down) 
				row++; 
			else
				row--; 
		} 

		// Print the Zig-Zag String 
		for (int i = 0; i < n; i++)  {  
			for (int j = 0; j < len; j++) 
				System.out.print(a[i][j] + " "); 
			System.out.println(); 
		} 
	} 

	// Driver Code 
	public static void main(String[] args) { 
		String s = "GeeksforGeeks"; 
		int n = 3; 
		fun(s, n); 
	} 
} 

