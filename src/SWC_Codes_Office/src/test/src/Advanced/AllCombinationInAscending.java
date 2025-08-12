package test.src.Advanced;

//Working

import java.io.FileInputStream;
import java.util.Scanner;

public class AllCombinationInAscending {
    static int Answer;
    static int length;
    static int Adj[];

    public static void main(String args[]) throws Exception    {
       
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("AllCombinationsInAsc.txt"));
        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {

            length = sc.nextInt();
            Adj = new int[length];
            for(int i =0 ; i<length ; i++) {
                    Adj[i] = sc.nextInt();
            }
            System.out.println("Case #"+(test_case+1));
            printCombination(Adj, length);
        }
    }

    private static void printCombination(int[] arr, int N ) {
                int data[]=new int[6];
                combinationUtil(arr, data, 0, N-1, 0);
    }

    private static void combinationUtil(int arr[], int data[], int start, int end, int index) {
       
        if (index == 6) {
            for (int j=0; j<6; j++)
                System.out.print(data[j]+" ");
            System.out.println("");
            return;
        }
		
        for (int i=start; i<=end && end-i+1 >= 6-index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1);
        }
    }
}
