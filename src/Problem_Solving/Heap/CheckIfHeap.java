package Problem_Solving.Heap;

class CheckIfHeap {

	static boolean isHeap(int arr[],	int i, int n)	{
		// If a leaf node, since In heap of size = n, after index = floor(n/2), all nodes are leaves.
		if (i >= (n - 2) / 2)
			return true;

		// If an internal node and is greater than its children
		// and same is recursively true for the children
		if (arr[i] >= arr[2 * i + 1] && arr[i] >= arr[2 * i + 2]
						&& isHeap(arr, 2 * i + 1, n)							//recursively check for left child
						&& isHeap(arr, 2 * i + 2, n))	{						//recursively check for right child
			return true;
		}
		return false;
	}

	public static void main(String[] args)	{
		int arr[] = { 90, 15, 10, 7, 12, 2, 7, 3 };
		int n = arr.length - 1;
		if (isHeap(arr, 0, n)) {
			System.out.println("Yes");
		}
		else 
			System.out.println("No");
	}
}
