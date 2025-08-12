package Problem_Solving.SlidingWindow;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeElemOfWindowOfSizeK {


	//Working for only few TCs.
	public static long[] printFirstNegativeInteger(long A[], int N, int K) {
		Queue<Integer> que = new LinkedList<>();
		long[] ans = new long[A.length];
		int counter = 0;

		for (int i = 0; i < K; i++) {
			if(A[i] < 0 )
				que.add(i);
			counter = printAns(que, ans, counter, A);
		}


		for (int i=K; i<N; i++) {
			while ((!que.isEmpty()) && que.peek() < (i - K + 1))
				que.remove();

			if(A[i] < 0 )
				que.add(i);
			counter = printAns(que, ans, counter, A);
		}

		//for last window
		//        counter = printAns(que, ans, counter, A);
		return ans;
	}

	static int printAns(Queue<Integer> que, long[] ans, int counter, long A[]) {
		if(que.size() > 0) {
			ans[counter] = A[que.peek()];
			counter++;
		} else {
			ans[counter] = 0;
			counter++;
		}
		return counter;
	}

	//Working
	public static long[] printFirstNegativeInteger1(long A[], int N, int K) {
		Queue<Integer> que = new LinkedList<>();
		long[] ans = new long[A.length-K+1];
		int counter = 0;
		int end = 0, start = 0;

		while(end < N) {
			if(A[end] < 0 )
				que.add(end);

			if(end >= K-1) {
				if(que.size() > 0) 
					ans[counter] = A[que.peek()];
				else 
					ans[counter] = 0;

				while ((!que.isEmpty()) && que.peek() <= start)
					que.remove();

				start++;
				counter++;
			}
			end++;
		}
		return ans;
	}

	public static void main(String[] args) {
		long arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
		int k = 3;
		long[] ans = printFirstNegativeInteger1(arr, arr.length, k);
		for(long l : ans)
			System.out.println(l);
	}
}
