package udemy.Recursion.DivideAndConquer.Mine;

public class fibonacci_1 {
	public static int getFibonacci(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 1;
		}
		return getFibonacci(n - 1) + getFibonacci(n - 2);
	}
	
	public static void main(String[] args) {
//		getFibonacci(4);
		Object[] array = new Object[Integer.MAX_VALUE - 200];
	}
}