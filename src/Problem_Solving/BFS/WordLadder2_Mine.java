package Problem_Solving.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class WordLadder2_Mine {

	static HashSet<String> dictonary = new HashSet<>();
	static HashSet<String> used = new HashSet<>();

	private static void findLadders(String start, String target, List<String> wordList) {
		if(start.length() != target.length())
			return;

		for(String word:wordList) 
			dictonary.add(word);

		char[] inp = new char[start.length()];
		for (int i = 0; i < start.length(); i++) {
			inp[i] = start.charAt(i);
		}
		LinkedList<String> ans =new LinkedList<String>();
		List<LinkedList<String>> res = new LinkedList<LinkedList<String>>();
		List<List<String>> result = new LinkedList<>();
		ans.add(start);
		//		helperMine(start, target, inp, ans, res);
		for(List<String> l: res) {
			if(l.size() == min) {
				result.add(new LinkedList<String>(l));
				System.out.println(l);
			}
		}
		helperQueue(start, target);
	}


	/*****************       TLE    *****************/
	static int min = Integer.MAX_VALUE;
	private static void helperMine(String start, String target, char[] inp, LinkedList<String> ans, List<LinkedList<String>> res) {
		if(start.equals(target)) {
			res.add(new LinkedList<String>(ans));
			min = Math.min(min, ans.size());
			//			System.out.println(ans);
			return;
		}

		if(ans.size() > min)
			return;

		for (int i = 0; i < inp.length; i++) {
			char c = inp[i];
			for(int j='a'; j<='z'; j++) {
				inp[i] = (char) j;
				String s = String.valueOf(inp);
				if(!used.contains(s) && dictonary.contains(s))	{
					ans.add(s);
					used.add(s);
					helperMine(s, target, inp, ans, res);
					ans.removeLast();
					used.remove(s);
				}
			}
			inp[i] = c;
		}
	}


	// BFS + DFS, https://youtu.be/mIZJIuMpI2M
	static HashMap<String, Integer> vis = new HashMap<String, Integer>();
	private static void helperQueue(String start, String target) {
		HashMap<String, LinkedList<String>> adj = new HashMap<String, LinkedList<String>>();
		Queue<String> q = new LinkedList<String>();
		int level = 1;
		q.offer(start);
		vis.put(start, level);
		while(!q.isEmpty()) {
			String curr = q.poll();
			if(curr.equals("log")) {
				System.out.println();
			}
			char[] inp = curr.toCharArray();
			
			for (int i = 0; i < inp.length; i++) {
				char c = inp[i];
				for(int j='a'; j<='z'; j++) {
					inp[i] = (char) j;
					String tmp = String.valueOf(inp);
					if(tmp.equals(curr))
						continue;
					
					if(dictonary.contains(tmp)) {
						if(vis.get(tmp) == null) {
							vis.put(tmp, vis.get(curr)+1);
							q.offer(tmp);
							if(adj.get(curr) != null) {
								LinkedList<String> l = adj.get(curr);
								l.add(tmp);
								adj.put(curr, l);
							} else {
								LinkedList<String> l = new LinkedList<String>();
								l.add(tmp);
								adj.put(curr, l);
							} 
						} else if(vis.get(tmp) == vis.get(curr)+1) {		// skipping this will not add log --> cog list.  
							//(If tmp is parent of curr then don't add (o/w will form loop), o/w add it in the list)
							if(adj.get(curr) != null) {
								LinkedList<String> l = adj.get(curr);
								l.add(tmp);
								adj.put(curr, l);
							} else {
								LinkedList<String> l = new LinkedList<String>();
								l.add(tmp);
								adj.put(curr, l);
							} 
						}
					}
				}
				inp[i] = c;
			}
		}
		DFS(start, target, adj, new LinkedList<String>(), new LinkedList<List<String>>());
	}

	static void DFS(String word, String endWord, HashMap<String, LinkedList<String>> children, List<String> curPath, List<List<String>> ans) {
		if (word.equals(endWord)) {
			ans.add(new ArrayList<String>(curPath));
			System.out.println(curPath);
			return;
		}

		List<String> childList = children.get(word);
		if (childList == null)
			return;
		for (String child : childList) {
			curPath.add(child);
			DFS(child, endWord, children, curPath, ans);
			curPath.remove(curPath.size() - 1);
		}
	}


	public static void main(String[] args) {
		List<String> D = new LinkedList<String>();
		D.add("hot");
		D.add("dot");
		D.add("dog");
		D.add("lot");
		D.add("log");
		D.add("cog");
		String start = "hit";
		String target = "cog";
		findLadders(start, target, D);
		System.out.println("Length of shortest chain is: " + min);
	}
}