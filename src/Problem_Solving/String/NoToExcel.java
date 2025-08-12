package Problem_Solving.String;

/**
 * 
 * convert given number into an excel column
 *
 */
public class NoToExcel {
	
    public static String getColumnName(int n) {
        StringBuilder res = new StringBuilder();
 
        while (n > 0) {
            // find index of next letter and concatenate the letter to the solution
            // Here index 0 corresponds to 'A' and 25 corresponds to 'Z'
            int index = (n - 1) % 26;
            res.append((char)(index + 'A'));
            n = (n - 1) / 26;
        }
 
        return res.reverse().toString();
    }
 
    public static void main(String[] args) {
//        for (int i = 1; i <= 10; i++) {
            int r = 679;
            System.out.println(r + " - " + getColumnName(r));
//        }
    }
}


