package Problem_Solving.DP.PartitioningProbs;

import java.util.ArrayList;
import java.util.List;

public class FrontPartition {

	public static void main(String[] args) {
//		int inp[] = {1,2,3,4};
		List<List<String>> answer = partition("1234");
		System.out.println(answer.toString());
	}

	public static List<List<String>> partition(String s) {
		List<List<String>> partitions = new ArrayList<>();
		createPartitions(0, s, "", new ArrayList<>(), partitions);
		return partitions;
	}

	private static void createPartitions(int start, String input, String ans, List<String> partialPartition, 
			List<List<String>> partitions) {

		if (start == input.length()) {							
//			System.out.println(ans);
			partitions.add(new ArrayList<>(partialPartition));
			return;
		}

		for (int i=start; i<input.length(); i++) {
			String palindromicSnippet = input.substring(start, i+1);			
			partialPartition.add(palindromicSnippet);					// Store ans in list
			createPartitions(i+1, input, ans+palindromicSnippet+"  ", partialPartition, partitions);
			partialPartition.remove(partialPartition.size() - 1);
		}
	}
}
