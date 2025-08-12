package Problem_Solving.Array.Pepcoding;

public class ProductOfArrayExceptItselfWithoutDivOperator {
	public static int[] productExceptSelf(int[] arr) {
		int[] left = new int[arr.length];

		int mul = 1;
		for(int i = 0; i < left.length; i++) {
			mul *= arr[i];
			left[i] = mul;
		}

		int[] res = new int[arr.length];
		int[] right = new int[arr.length];
		mul = 1;
		for(int i = arr.length - 1; i >= 0; i--) {
			mul *= arr[i];
			right[i] = mul;
		}

		res[0] = right[0];
		res[arr.length-1] = left[arr.length-2];

		for(int i = 1; i < left.length-1; i++)
			res[i] = left[i - 1] * right[i+1];
		return res;
	}

	//~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		int[] res = productExceptSelf(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
