package Problem_Solving.BinarySearch;

public class AllocateMinNoOfPages {
	
	public static void main(String[] args) {
		int A[] = {2, 5, 6, 15, 19, 25, 43, 49, 60, 64, 70, 80, 83, 90, 90, 97};
		int N = 16;
		int M = 14;
		int ans = findPages(A, N, M);
		System.out.println(ans);
	}

	//Working
	public static int findPages(int[]A,int N,int M) {
        int sum = 0;
        int max = -1;
        if(N < M)
            return -1;
        for(int i=0; i<A.length; i++) {
            sum = sum+A[i];
            max = Math.max(max, A[i]);
        }
        
        int start = 0;
        int end = sum;
        int ans = -1;
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(isValid(A, M, mid)) {
                ans = mid;
                end = mid-1;
            } else
                start = mid+1;
        }
        return ans;
    }
    
    public static boolean isValid(int[]A, int M, int max) {
        int student = 1;
        int sum = 0;
        for(int i=0; i<A.length; i++) {
            sum = sum + A[i];
            if(sum > max) {
                student++;
                sum = A[i];
            }
            if(student > M || A[i] > max) {
                return false;
            }
        }
        if(sum > max) {
            student++;
            if(student > M) 
                return false;
        }
        return true;
    }
}
