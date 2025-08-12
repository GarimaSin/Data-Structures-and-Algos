package Java.Multithreading.PrintEvenOddSequentially;

public class PrinterUsingWaitAndNotify {
	private volatile boolean isOdd;

	synchronized void printEven(int number) {
		while (!isOdd) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		System.out.println(Thread.currentThread().getName() + ":" + number);
		isOdd = false;
		notify();
	}

	synchronized void printOdd(int number) {
		while (isOdd) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		System.out.println(Thread.currentThread().getName() + ":" + number);
		isOdd = true;
		notify();
	}

	public static void main(String... args) {
		PrinterUsingWaitAndNotify print = new PrinterUsingWaitAndNotify();
		Thread t1 = new Thread(new TaskEvenOdd(10, print, false),"Odd");
		Thread t2 = new Thread(new TaskEvenOdd(10, print, true),"Even");
		t1.start();
		t2.start();
	}
}


class TaskEvenOdd implements Runnable {
	private int max;
	private PrinterUsingWaitAndNotify print;
	private boolean isEvenNumber;

	TaskEvenOdd(int max, PrinterUsingWaitAndNotify print, boolean isEvenNumber) {
		this.isEvenNumber = isEvenNumber;
		this.max = max;
		this.print = print;
	}

	@Override
	public void run() {
		int number = isEvenNumber ? 2 : 1;
		while (number <= max) {
			if (isEvenNumber) {
				print.printEven(number);
			} else {
				print.printOdd(number);
			}
			number += 2;
		}
	}
}