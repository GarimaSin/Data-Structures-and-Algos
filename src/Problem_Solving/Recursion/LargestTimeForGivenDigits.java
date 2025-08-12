package Problem_Solving.Recursion;

public class LargestTimeForGivenDigits {

	public static void main(String[] args) {
		int arr[] = {0,0,1,0};
		largestTimeFromDigits(arr);
		if(maxH.equals("") || maxM.equals(""))
			System.out.println("---");
		else {
			if(maxH.length() ==1)
				maxH = "0"+maxH;
			if(maxM.length() ==1)
				maxM = "0"+maxM;
			System.out.println(maxH+":"+maxM);
		}
	}

	public static void largestTimeFromDigits(int[] arr) {
		permute(arr, "", new boolean[arr.length]);
	}

	static String maxH = "";
	static String maxM = "";
	
	private static void permute(int[] arr, String ans, boolean vis[]) {
		
		if(ans.length() >= 2) {				//Check the optimization part
			int h = Integer.parseInt(ans.substring(0,2));
			if(h >23)
				return;
		}
		
		if(ans.length() == arr.length) {
			System.out.println(ans);
			calculateMaxTime(ans);
			return;
		}
		
		for (int j = 0; j < arr.length; j++) {
			if(!vis[j]) {
				vis[j] = true;
				permute(arr, ans+arr[j], vis);
				vis[j] = false;
			}
		}
	}

	private static void calculateMaxTime(String ans) {
		String hr = ans.substring(0, 2);
		String min = ans.substring(2, 4);
		if(hr.compareTo("24") < 0 && min.compareTo("60") < 0) {
			if(maxH.compareTo(hr) < 0 || (maxM.compareTo(min) <0 && maxH.compareTo(hr) == 0)) {
				maxH = hr;
				maxM = min;
			}
		}
	}
}
