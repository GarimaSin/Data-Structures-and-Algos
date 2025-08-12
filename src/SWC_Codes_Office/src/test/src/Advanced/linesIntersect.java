package SWC_Codes_Office.src.test.src.Advanced;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


// Check whether 2 lines intersect each other

public class linesIntersect {
	static int Ax1, Ax2, Ay1, Ay2, Bx1, Bx2, By1, By2, Cx1, Cx2, Cy1, Cy2;
	public static void main (String args[]) throws FileNotFoundException{
		Scanner sc = new Scanner(new FileInputStream("intersect.txt"));
		int T=sc.nextInt();
		for(int t=1;t<=2;t++) {
			Ax1 = sc.nextInt();
			Ay1 = sc.nextInt();
			Ax2 = sc.nextInt();
			Ay2 = sc.nextInt();
			Bx1 = sc.nextInt();
			By1 = sc.nextInt();
			Bx2 = sc.nextInt();
			By2 = sc.nextInt();
			Cx1 = sc.nextInt();
			Cy1 = sc.nextInt();
			Cx2 = sc.nextInt();
			Cy2 = sc.nextInt();
			
			boolean ab = checkIntersection(Ax1, Ay1, Ax2, Ay2, Bx1, By1, Bx2, By2);
			boolean bc = checkIntersection(Cx1, Cy1, Cx2, Cy2, Bx1, By1, Bx2, By2);
			boolean ac = checkIntersection(Ax1, Ay1, Ax2, Ay2, Cx1, Cy1, Cx2, Cy2);
			
			System.out.println("Case #"+ t);
			if(ab == true)
				System.out.println("AB");
			else if(bc == true)
				System.out.println("BC");
			else if (ac == true)
				System.out.println("AC");
			else if (ab == true && bc == true && ac == true)
				System.out.println("ABC");
			else
				System.out.println("X");
		}
	}
	
	public static boolean checkIntersection(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        return ((checkCoordinates(x1, y1, x2, y2, x3, y3) *
                 checkCoordinates(x1, y1, x2, y2, x4, y4) <= 0)
                && (checkCoordinates(x3, y3, x4, y4, x1, y1) *
                    checkCoordinates(x3, y3, x4, y4, x2, y2) <= 0));
    }
	 
	 
	 public static int checkCoordinates(double x1, double y1, double x2, double y2, double px, double py) {
        x2 -= x1;
        y2 -= y1;
        px -= x1;
        py -= y1;
        double ccw = px * y2 - py * x2;
        if (ccw == 0.0) {
            ccw = px * x2 + py * y2;
            if (ccw > 0.0) {
                px -= x2;
                py -= y2;
                ccw = px * x2 + py * y2;
                if (ccw < 0.0) {
                    ccw = 0.0;
                }
            }
        }
        return (ccw < 0.0) ? -1 : ((ccw > 0.0) ? 1 : 0);
	 }
        
}