package SWC_Codes_Office.src.test.src.Advanced;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Point {
	 public double x, y;
	 public Point(double x, double y) {
	  super();
	  this.x = x;
	  this.y = y;
	 }
	}


class Segment {
	 
	 public final Point start, end;
	 public final boolean isVertical; 
	 public final double slope, intercept; 
	  
	 public Segment(Point start, Point end) {
	  this.start = start;
	  this.end = end;
	  if (start.x == end.x)
	   isVertical = true;
	  else
	   isVertical = false;
	   
	  //set slope and intercept
	  if (!isVertical){
	   slope = (start.y - end.y) / (start.x - end.x);
	   intercept = (end.x * start.y - start.x * end.y ) /(start.x - end.x); 
	  }
	  else {
	   slope = Double.MAX_VALUE;
	   intercept = - Double.MAX_VALUE;
	  }
	 }
	}


public class IntersectionCheceker {
	 
	 public final Segment segment1, segment2;
	 private Boolean hasIntersection;
	 static int Ax1, Ax2, Ay1, Ay2, Bx1, Bx2, By1, By2, Cx1, Cx2, Cy1, Cy2;
	  
	 public IntersectionCheceker(Segment segment1, Segment segment2){
	  this.segment1 = segment1;
	  this.segment2 = segment2;
	 }
	  
	 public IntersectionCheceker(double x1, double y1, double x2, double y2,
	  double x3, double y3, double x4, double y4){
	  Point start1 = new Point(x1, y1);
	  Point end1 = new Point(x2, y2);
	  Point start2 = new Point(x3, y3);
	  Point end2 = new Point(x4, y4);
	  this.segment1 = new Segment(start1, end1);
	  this.segment2 = new Segment(start2, end2);
	 }
	  
	 public boolean hasIntersection(){
	  if (hasIntersection != null)
	   return hasIntersection;
	   
	  if (segment1.isVertical){
	   if ( (segment2.start.x - segment1.start.x)*(segment2.end.x - segment1.start.x) > 0 )
	    hasIntersection = false;
	   else {
	    double fx_at_segment1startx = segment1.slope * segment1.start.x + segment1.intercept;
	    double smaller, larger;
	    if (segment1.start.x < segment1.end.x ){
	     smaller = segment1.start.x;larger = segment1.end.x; 
	    }
	    else {
	     larger = segment1.start.x;smaller = segment1.end.x;
	    }
	    if (smaller <= fx_at_segment1startx && fx_at_segment1startx <= larger)
	     hasIntersection = true;
	    else
	     hasIntersection = false;
	   }
	  }
	  else if (segment2.isVertical){
	   hasIntersection = new IntersectionCheceker(segment2, segment1).hasIntersection();
	  }
	  else { //both segment1 and segment2 are not vertical 
	   if (segment1.slope == segment2.slope)
	    hasIntersection = false;
	   else {
	    double x1 = segment1.start.x;
	    double y1 = segment1.start.y;
	    double x2 = segment1.end.x;
	    double y2 = segment1.end.y;
	    double x3 = segment2.start.x;
	    double y3 = segment2.start.y;
	    double x4 = segment2.end.x;
	    double y4 = segment2.end.y;
	    double x = ((x4*y3-y4*x3)/(x4-x3) - (x2*y1-y2*x1)/(x2-x1))
	      /( (y2-y1)/(x2-x1) - (y4-y3)/(x4-x3));
	     
	    double smaller, larger;
	    if (x1 < x2){
	     smaller = x1; larger = x2;
	    }
	    else {
	     smaller = x2; larger = x1;
	    }
	    if (smaller <= x && x <= larger)
	     hasIntersection = true;
	    else
	     hasIntersection = false; 
	   } 
	  }
	  return hasIntersection;
	 }
	   
	  
	 @SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws FileNotFoundException {
	   
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
			
			IntersectionCheceker checker1 = new IntersectionCheceker(Ax1, Ay1, Ax2, Ay2, Bx1, By1, Bx2, By2);
			boolean ab = checker1.hasIntersection();
			IntersectionCheceker checker2 = new IntersectionCheceker(Cx1, Cy1, Cx2, Cy2, Bx1, By1, Bx2, By2);
			boolean bc = checker2.hasIntersection();
			IntersectionCheceker checker3 = new IntersectionCheceker(Ax1, Ay1, Ax2, Ay2, Cx1, Cy1, Cx2, Cy2);
			boolean ac = checker3.hasIntersection();
			
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
	}