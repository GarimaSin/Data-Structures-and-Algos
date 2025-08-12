package PracticeProb.src.Coby;

//Working

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LaughingBombWithoutRec {

	static int Answer;
	static int M, N;
	static int bom[][];
	static int[][] ar = new int[3][4];
	static boolean disconnect = true;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("Laughingbomb.txt"));
		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			N =sc.nextInt();
			M =sc.nextInt();
			bom = new int[M][N];
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					bom[i][j]=sc.nextInt();
				}
			}
			int Y=sc.nextInt();
			int X=sc.nextInt();
			Y--;
			X--;
			get_max_time_for_contaminated(X, Y);
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer-1);
		}
	}


	static void update_connecting_pos(int ii, int jj) {

		if (isSafe(ii+1,jj) && bom[ii+1][jj] == 1) {
			bom[ii+1][jj] = Answer+1;
			disconnect = false;
		}
		if (isSafe(ii,jj+1) && bom[ii][jj+1] == 1) {
			bom[ii][jj+1] = Answer+1;
			disconnect = false;
		}
		if (isSafe(ii-1,jj) && bom[ii-1][jj] == 1) {
			bom[ii-1][jj] = Answer+1;
			disconnect = false;
		}
		if (isSafe(ii,jj-1) && bom[ii][jj-1] == 1) {
			bom[ii][jj-1] = Answer+1;
			disconnect = false;
		}
	}

	static void get_max_time_for_contaminated(int X, int Y) {
		Answer = 2;
		bom[X][Y] = Answer;
		while (true) {
			disconnect = true;
			for (int ii = 0; ii < M; ii++) {
				for (int jj = 0; jj < N; jj++) {
					if (bom[ii][jj] == Answer) {
						update_connecting_pos(ii, jj);
					}
				}
			}
			if (disconnect) {
				break;
			}
			Answer++;
		}
	}
	
	static boolean isSafe(int x, int y) {
		if(x>=0 && x<M && y>=0 && y<N){
			return true;
		}
		return false;
	}
}