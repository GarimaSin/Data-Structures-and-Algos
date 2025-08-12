package PracticeProb.src.Coby;

//Working

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ColorGraph {

	static int[][] tree;
	static int[] col;
	static int size;
	static int ans = 0;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("ColorGraph.txt"));	
		int T = sc.nextInt();
		for(int t=0; t<T; t++){
			size = sc.nextInt();
			ans=0;
			tree = new int[size][size];
			col = new int[size];
			for(int i=0; i<size; i++){
				for(int j=0; j<size; j++){
					int num = sc.nextInt();
					tree[i][j] = num;
				}
			}
			int v = 0;
			fillColor(v);
			System.out.println(ans);
		}

	}
	private static void fillColor(int v) {
		if(v == size) {
			ans++;
			return;
		}
		for(int color=1; color<=4; color++){
			if(valid(v, color)) {
				col[v] = color;
				fillColor(v+1);
				col[v]=0;
			}
		}
	}
	private static boolean valid(int v, int color) {
		for(int i=0; i<size; i++){
			if(tree[v][i] != 0){
				if(col[i] == color){
					return false;
				}
			}
		}
		return true;
	}
}
