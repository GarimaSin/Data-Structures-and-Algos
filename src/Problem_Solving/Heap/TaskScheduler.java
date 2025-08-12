package Problem_Solving.Heap;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

	//Working
	public static int leastInterval(char[] tasks, int n) {
		PriorityQueue<key> pq = new PriorityQueue<>();
		Queue<key> q = new LinkedList<>();
		int[] frq = new int[26];
		for (int i = 0; i < tasks.length; i++) 
			frq[tasks[i] - 'A']++; 

		for (char c = 'A'; c <= 'Z'; c++) { 
			int val = c - 'A'; 
			if (frq[val] > 0) 
				pq.add(new key(c, frq[val], n)); 
		} 
		int currTime = 0;
		while(pq.size() > 0 || q.size() > 0) {
			while(!q.isEmpty() && q.peek().time <= currTime) {
				pq.add(q.remove());
			}
			if(!pq.isEmpty()) {
			key k = pq.remove();
				k.time = currTime+n+1;		// mind the +1
				k.freq = k.freq-1;
				if(k.freq > 0)
					q.add(k);
			}
			currTime++;
		}
		return currTime;
	}
	
	 public static void main(String[] args) {
			char tasks[] = {'A','A','A','A','A','A','B','C','D','E','F','G'};
			int n = 2;
			int ans = leastInterval(tasks, n);
			System.out.println(ans);
		}

	static class key implements Comparable<key>{
		char c;
		Integer freq;
		int time;

		key(char c, int freq, int time) {
			this.c = c;
			this.freq = freq;
			this.time = time;
		}

		@Override
		public int compareTo(key o) {
			return o.freq.compareTo(this.freq);
		}
	}
}