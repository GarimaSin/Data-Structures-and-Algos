package Coding;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VotingApp {

	//vote - 3 - personVotedFor, int prefernce 
	// p1 = c1, p2 = c1, p3 = c3
	// c1 =2, c3 =1
	// f -1, s-2, t-3 --> 
	List<String> findWinners(List<Vote> votes) {
		HashMap<String, Integer> winner = new HashMap<>();
		for(Vote v: votes) {
			for(Rank r: v.votes) {
				String key = r.getCandidate();
				if(winner.get(key) == 0)
					winner.put(key, r.prefernce);
				else
					winner.put(key, winner.get(key)+r.prefernce);
			}
		}
		LinkedHashMap<String, Integer> result = sortByValue(winner);
		return result.get();
	}

	public static LinkedHashMap<String, Integer>
	sortByValue(HashMap<String, Integer> hm)
	{
		// Create a list from elements of HashMap
		List<Map.Entry<String, Integer>> list 	= new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

		// Sort the list using lambda expression
		Collections.sort(list, (i1,i2) -> i1.getValue().compareTo(i2.getValue()));

		// put data from sorted list to hashmap
		LinkedHashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}
}

class Rank implements Comparator<Rank> {
	String candidate;
	Integer prefernce;

	void putVote(String candidate, int pref) {
		this.candidate = candidate;
		if(pref == 1)
			this.prefernce = 3;
		else if(pref == 2)
			this.prefernce = 2;
		else
			this.prefernce = 1;
	}

	@Override
	public int compare(Rank r1, Rank r2) {
		return r1.prefernce.compareTo(r2.prefernce);
	}

	String getCandidate() {
		return this.candidate;
	}
} 

class Vote {
	List<Rank> votes = new LinkedList<Rank>();		// 3 votes by a single person
	
	List<Rank> getVotesByAPerson() {
		Collections.sort(votes);
	}
}

