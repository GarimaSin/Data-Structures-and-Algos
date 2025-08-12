package Problem_Solving.Leetcode.Iterative;

import java.util.LinkedList;

public class MergeSortedLists {
	public static void main(String[] args) {
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l1.add(1);
		l1.add(2);
		l1.add(4);
		l2.add(1);
		l2.add(3);
		l2.add(4);
		LinkedList<Integer> l3 = new LinkedList<Integer>();
		int i=0, j=0;
		while (i<l1.size() && j < l2.size()) {
			if(l1.get(i) < l2.get(j)) {
				l3.add(l1.get(i));
				i++;
			}
			else if(l1.get(i) == l2.get(j)) {
				l3.add(l1.get(i));
				l3.add(l2.get(j));
				i++; j++;
			} else {
				l3.add(l2.get(j));
				j++;
			}
			
			// add the case where elements in either of the list remains
		}
		for(int k=0;k<l3.size(); k++)
			System.out.print(l3.get(k));
	}
}
