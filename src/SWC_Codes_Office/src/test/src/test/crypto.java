package test.src.test;

import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class crypto {

	@SuppressWarnings({ "rawtypes", "unused", "resource" })
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("crypto.txt"));
		int originalLen = sc.nextInt();
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=0; i<originalLen; i++){
			int t = sc.nextInt();
			list.add(t);
		}
		int commands = sc.nextInt();
		for(int i=0; i<commands; i++){
			String s = sc.next();
			int before = sc.nextInt();
			int count = sc.nextInt();
			LinkedList<Integer> temp = new LinkedList<Integer>();
			for(int j=0; j<count; j++){
				temp.add(sc.nextInt());
			}
			list.addAll(before, temp);
		}
		List l = (List) list.subList(0, 10);
		System.out.println("#"+1+" "+l);
	}
}