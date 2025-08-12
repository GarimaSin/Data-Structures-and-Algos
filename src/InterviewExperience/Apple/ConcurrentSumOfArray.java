package InterviewExperience.Apple;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


//Ques: given a 2D array, print the sum of the elements in the array concurrently.
public class ConcurrentSumOfArray {

	int rowCount  = 0;
	int colCount = 0;
	int answer = 0;
	int row;
	
	public int sum(int[][] arr) throws InterruptedException, ExecutionException {
		rowCount = arr.length;
		colCount = arr[0].length;
		ExecutorService s = Executors.newFixedThreadPool(rowCount);
		for(int i=0; i<rowCount; i++) {
			row = i;
			Future<Integer> f = (Future<Integer>) s.submit(new Sumtask(colCount, i, arr));
			answer = answer+f.get();
		}
		return answer;
	}
	
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		int[][] arr = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
		ConcurrentSumOfArray obj = new ConcurrentSumOfArray(); 
		int ans = obj.sum(arr);
		System.out.println(ans);
	}
	
	
	//CountDown Latch can only be used when we dont want to return any value from call.
	//Coz o/w we have to call future.get, which itself will remain blocked until we get the value in it, which means we dont need countDown
	public void sumUsingLatch(int[][] a) throws InterruptedException, ExecutionException {
		rowCount = a.length;
		colCount = a[0].length;
		ExecutorService pool = Executors.newFixedThreadPool(rowCount);
		CountDownLatch latch = new CountDownLatch(a.length);
		int sum = 0;

	    for ( int i=0; i<a.length; i++ ) {
	        pool.submit(new Sumtasks(latch, rowCount, i, a) );
	    }
	    latch.await();
	}
	
}

class Sumtasks implements Callable<Integer> {
	int rowCount;
	int colCount;
	int arr[][];
	CountDownLatch latch;
	
	Sumtasks(CountDownLatch latch, int r, int c, int arr[][]) {
		this.colCount = c;
		this.rowCount = r;
		this.arr = arr;
		this.latch = latch;
	}
	
	@Override
	public Integer call() {
		Integer tmp = 0;
		for(int i =0 ; i<colCount; i++) {
			tmp += arr[rowCount][i];
		}
		latch.countDown();
		return tmp;
	}
}

class Sumtask implements Callable<Integer> {
	int rowCount;
	int colCount;
	int arr[][];
	
	Sumtask(int c, int r, int arr[][]) {
		this.colCount = c;
		this.rowCount = r;
		this.arr = arr;
	}
	
	@Override
	public Integer call() throws Exception {
		Integer tmp = 0;
		for(int i =0 ; i<colCount; i++) {
			tmp += arr[rowCount][i];
		}
		return tmp;
	}
}