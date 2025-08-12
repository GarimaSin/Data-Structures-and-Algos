package SWC_Codes_Office.src.test.src.Advanced;

//Working
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RainWater {

	static int count = 0;
	static int temp = 0;
	static boolean found = false;
	static int height = 0;
	static int start = 0;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("RainWater.txt"));
        int T=sc.nextInt();
        for(int t=1;t<=T;t++) {
        	int size = sc.nextInt();
        	count = 0; start = 0; height = 0;
        	found = false;
        	int[] bars = new int[size];
        	bars[0] = sc.nextInt();
        	for(int i=1; i<size; i++){
        		bars[i] = sc.nextInt();
        		if(found == false && bars[0] <= bars[i]) {
        			found = true;
        			count = i;
        			temp = i;
        		} 
        	}
        	if(found == false){
        		for(int j=1; j<size; j++) {
        			temp++;
        			if(bars[j] != 0){
        				start = j;
        				count = j;
        				height = height + (bars[j]*(temp-1));
        				temp = 0;
        				calculateArea(bars, bars[j], size);
        				break;
        			}
        		}
        		
        	}
//        	System.out.println("Count = "+count+"  Size = "+size);
        	evaluateHeight(bars, size);
//        	System.out.println(height);
        	int h1 = 0;
        	while (count < (size-1)) {
        		found = false;
        		start = count;
        		temp = 0;
        		h1 = bars[count];
        		calculateArea(bars, h1, size);
        	}
        	System.out.println("Case #"+t);
        	System.out.println(height);
        }
	}

	private static void evaluateHeight(int[] bars, int size) {
		if(found){
			height = height + (bars[start]*(temp-1));
    		for(int i=start+1; i<count; i++){
    			if(bars[i] != 0){
    				height = height - bars[i];
    			}
    		}
    		found = false;
    	} else {
    		temp = 0;
    		for(int j=start+1; j<size; j++) {
    			temp++;
    			if(bars[j] != 0){
    				count = j;
    				height = height + (bars[j]*(temp-1));
    				temp = 0;
    				break;
    			}
    		}
    	}
	}

	private static void calculateArea(int[] bars, int h1, int size) {
		for(int i=start+1; i<size; i++){
    		if(bars[i] >= h1){
    			temp = i - start;
    			start = count;
    			count = i;
    			found = true;
    			evaluateHeight(bars, size);
    			return;
    		}
    	} 
		if(found == false)
			evaluateHeight(bars, size);
	}

}
