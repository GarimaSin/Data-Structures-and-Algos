package Java.Multithreading.PrintSequenceUsingThreeThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Using Executor Service
public class PrintThreadsSequentiallyMain2 {
	public static void main(String[] args) {

		PrintSequenceRunnable runnable1 = new PrintSequenceRunnable(1);
		PrintSequenceRunnable runnable2 = new PrintSequenceRunnable(2);
		PrintSequenceRunnable runnable3 = new PrintSequenceRunnable(0);

		ExecutorService pool = Executors.newFixedThreadPool(3);
		pool.submit(runnable1, "T1");
		pool.submit(runnable2,"T2");
		pool.submit(runnable3,"T3");
	}
}