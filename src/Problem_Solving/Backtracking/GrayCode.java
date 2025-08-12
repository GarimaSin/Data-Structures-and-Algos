package Problem_Solving.Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.

	Given a non-negative integer n representing the total number of bits in the code, 
	print the sequence of gray code. A gray code sequence must begin with 0.
	
	Better Sol: check grayCode2(). Explanation in Amazon's Interview Ques.
 *
 */
public class GrayCode {
	public static void main(String[] args) {
		GrayCode gc = new GrayCode();
		int n = 3;
		//		int size = 2^n;
//		List<Integer> ans = gc.grayCode(n);
		List<String> ans1 = gc.grayCode2(n);
		//		System.out.println(Integer.valueOf("01", 10));
		for (int i = 0; i < ans1.size(); ++i) {
			System.out.print(ans1.get(i) +" ");
		}
		System.out.println();
	}

	public List<Integer> grayCode(int n) {
		List<Integer> result = new LinkedList<>();
		for (int i = 0; i < 1<<n; i++) 
			result.add(i ^ i>>1);
		return result;
	}


	//Working
	public List<Integer> grayCode1(int n) {
		List<Integer> rs=new ArrayList<Integer>();
		rs.add(0);
		for(int i=0;i<n;i++){
			int size=rs.size();
			for(int k=size-1;k>=0;k--)
				rs.add(rs.get(k) | 1<<i);
		}
		return rs;
	}


	//Working:  https://www.youtube.com/watch?v=KOD2BFauQbA
	public List<String> grayCode2(int n) {
		if(n == 1) {
			List<String> rs=new ArrayList<String>();
			rs.add("0");
			rs.add("1");
			return rs;
		}
		List<String> rrs = grayCode2(n-1);
		List<String> ans = new ArrayList<String>();
		
		for(int i=0; i<rrs.size(); i++){
			String rstr = rrs.get(i);
			ans.add("0"+rstr);
		}
		
		for(int i=rrs.size()-1; i>=0; i--){
			String rstr = rrs.get(i);
			ans.add("1"+rstr);
		}
		return ans;
	}

	private List<Integer> permute(String s, int n, int count, ArrayList<Integer> list, ArrayList<Integer> ans) {
		if(count == n) {
			ans.add(Integer.valueOf(s, 10));
			//            	System.out.print(list.get(i));
			return ans;
		} 
		if(count > n)
			return ans;

		for(int i=0; i<n; i++) {
			//			list.add(i);
			permute(s+i,n, count+1, list, ans);
			//			list.remove(list.size()-1);
		}

		return ans;
	}
}
