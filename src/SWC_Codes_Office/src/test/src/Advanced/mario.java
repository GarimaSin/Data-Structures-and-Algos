package SWC_Codes_Office.src.test.src.Advanced;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class mario {
	
	static int isG = 0;
	static int petals = 0; 
	static int coins = 0;
	static int bombs = 0;
	static int totBomb =0, totCoins=0;
//	static int bom[] = new int[];
	public static void main(String args[]) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("mario.txt"));
		int T=sc.nextInt();
		for(int t=0;t<1;t++) {
//			for(int i=0;i<4;i++){
				isG = sc.nextInt();
				petals = sc.nextInt();
				coins = sc.nextInt();
				bombs = sc.nextInt();
				if(isG>0 && petals>0){
					if(petals<=totCoins){
						totCoins=totCoins-petals;
						totCoins=totCoins+coins;
						totBomb=totBomb+bombs;
					} else if(totBomb>0) {
						totBomb=0;
						totCoins=totCoins+coins;
						totBomb=totBomb+bombs;
					}
				} else{
					totCoins=totCoins+coins;
					totBomb=totBomb+bombs;
				}
//			}
			
		}
	}

}
