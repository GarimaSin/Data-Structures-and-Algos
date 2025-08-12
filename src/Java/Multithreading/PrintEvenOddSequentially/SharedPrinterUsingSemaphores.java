package Java.Multithreading.PrintEvenOddSequentially;

import java.util.concurrent.Semaphore;

public class SharedPrinterUsingSemaphores {

	private Semaphore semEven = new Semaphore(0);
	private Semaphore semOdd = new Semaphore(1);

	void printEvenNum(int num) {
		try {
			semEven.acquire();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println(Thread.currentThread().getName() + num);
		semOdd.release();
	}

	void printOddNum(int num) {
		try {
			semOdd.acquire();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println(Thread.currentThread().getName() + num);
		semEven.release();
	}
	
	public static void main(String[] args) {
		SharedPrinterUsingSemaphores sp = new SharedPrinterUsingSemaphores();
	    Thread odd = new Thread(new Odd(10, sp),"Odd");
	    Thread even = new Thread(new Even(10, sp),"Even");
	    odd.start();
	    even.start();
	}
}


class Even implements Runnable {
    private SharedPrinterUsingSemaphores sp;
    private int max;

    Even(int max, SharedPrinterUsingSemaphores sp) {
    	this.max = max;
    	this.sp = sp;
    }

    @Override
    public void run() {
        for (int i = 2; i <= max; i = i + 2) {
            sp.printEvenNum(i);
        }
    }
}

class Odd implements Runnable {
    private SharedPrinterUsingSemaphores sp;
    private int max;

    Odd(int max, SharedPrinterUsingSemaphores sp) {
    	this.max = max;
    	this.sp = sp;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= max; i = i + 2) {
            sp.printOddNum(i);
        }
    }
}
