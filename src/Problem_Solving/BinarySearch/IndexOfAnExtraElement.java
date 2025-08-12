package Problem_Solving.BinarySearch;

public class IndexOfAnExtraElement {
	public static void main(String[] args) {
		int a[] = {1, 2, 3, 4};
		int b[] = {1, 3, 4};
		int ans = findExtra(a, b, 0);
		System.out.println(ans);
	}

	public static int findExtra(int a[], int b[], int n) {
		int ans = -1;
		if(a.length > b.length) {
			ans = findIndex(a, b, n);		//bigger array is sent first
		} else {
			ans = findIndex(b, a, n);
		}
		return ans;
	}

	//Working
	static int findIndex(int[] a1, int[] a2, int n) {
		int start = 0;
		int end = a1.length -1;	//BS is done on bigger array
		int mid = 0;
		int answer = -1;
		while(start <= end) {
			mid = start + (end - start)/2;
			if(mid > a2.length-1)
				return mid;
			if(a1[mid] == a2[mid]) {
				start = mid+1;
			} else  {
				answer = mid;
				end = mid-1;
			}
		}
		return answer;
	}
}
