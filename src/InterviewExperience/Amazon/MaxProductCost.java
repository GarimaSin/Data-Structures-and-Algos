package InterviewExperience.Amazon;

import java.util.List;

public class MaxProductCost {

	public static int findMaxProducts(List<Integer> products) {
		int max = 0;
		int i = products.size()-1;
		int j = i;
		while(j >= 0) {
			int start = products.get(i); 
			int sum = start;
			if(i-1 >=0) {
				int top = products.get(i-1);
				int tmp = start;
				while(tmp >= 1 &&  i>=0) {
					top = products.get(i-1);
					if(top > tmp) {
						sum = sum + tmp-1;
						tmp = tmp - 1;
					} else {
						if(top == tmp)
							top = top -1;
						sum = sum + top;
						tmp = top;
					}
				}
			}
			max = Math.max(max, sum);
			j = j-1;
			i = j;
		}
		return max;
	}
}
