package PracticeProb.src.ServerGoup;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class RoadToVictory {

	    public static void main(String args[]) throws Exception
	    {
	        Scanner sc = new Scanner(new FileInputStream("RoadToVictory.txt"));
	        int T;
	        T=sc.nextInt();
	        for (int test_case = 1; test_case <= T; test_case++) {
	            int arraySize = sc.nextInt();
	            int[][] values = new int[100][100];
	  
	            for (int rowIndex =0; rowIndex < arraySize; rowIndex++){             
	  
	                char[] lines = sc.next().toCharArray();//line.split("");
	                for (int colIndex=0;colIndex<arraySize;colIndex++) {
	                    values[rowIndex][colIndex] = Character.getNumericValue(lines[colIndex]);//Integer.parseInt(lines[colIndex]);
	                }
	            }
	            int[][] finalValues = new int[arraySize][arraySize];
	            for (int rowIndex =0; rowIndex < arraySize; rowIndex++){             
	                for (int colIndex=0;colIndex<arraySize;colIndex++) {
	                    finalValues[rowIndex][colIndex] = 100000;
	                }
	            }
	            finalValues[0][0] = 0;
	            for (int i =0; i< arraySize;i++) {
	                for (int rowIndex =0; rowIndex < arraySize; rowIndex++){
	                    for (int colIndex=0;colIndex<arraySize;colIndex++) {
	                        int x = values[rowIndex][colIndex];
	  
	                        if (rowIndex-1 >= 0) {
	                            if (finalValues[rowIndex-1][colIndex] > values[rowIndex-1][colIndex] + finalValues[rowIndex][colIndex]) {
	                                finalValues[rowIndex-1][colIndex] = values[rowIndex-1][colIndex] + finalValues[rowIndex][colIndex];
	                            }
	                        }
	                        if (rowIndex+1<arraySize) {
	                            if (finalValues[rowIndex+1][colIndex] > values[rowIndex+1][colIndex] + finalValues[rowIndex][colIndex]) {
	                                finalValues[rowIndex+1][colIndex] = values[rowIndex+1][colIndex] + finalValues[rowIndex][colIndex];
	                            }
	  
	                        }
	  
	                        if (colIndex-1 >= 0) {
	                            if (finalValues[rowIndex][colIndex-1] > values[rowIndex][colIndex-1] + finalValues[rowIndex][colIndex]) {
	                                finalValues[rowIndex][colIndex-1] = values[rowIndex][colIndex-1] + finalValues[rowIndex][colIndex];
	                            }
	  
	                        }
	                        if (colIndex+1 < arraySize) {
	                            if (finalValues[rowIndex][colIndex+1] > values[rowIndex][colIndex+1] + finalValues[rowIndex][colIndex]) {
	                                finalValues[rowIndex][colIndex+1] = values[rowIndex][colIndex+1] + finalValues[rowIndex][colIndex];
	                            }
	  
	                        }
	                    }
	                }
	            }
	            System.out.println("Case #"+test_case + " " + finalValues[arraySize-1][arraySize-1]);
	        }
	    }
	}

/*Case #1
3
Case #2
4 */