package Problem_Solving.Greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HandOfStraights {

	public boolean isNStraightHand(int[] hand, int groupSize) {
		if(hand.length % groupSize != 0) {
            return false;
        } else {
            Map<Integer,Integer> frq = new HashMap<>();
            for(int num: hand) {
                frq.put(num, frq.getOrDefault(num, 0) + 1);
            }
            Arrays.sort(hand);
            
            for(int num: hand) {
                if(frq.containsKey(num)) {
                    for(int j=0; j<groupSize; j++) {
                        if(frq.containsKey(num+j)) {
                            frq.put(num+j, frq.get(num+j)-1);
                            if(frq.get(num+j) == 0) {
                                frq.remove(num+j);
                            }
                        } else {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
	}
	
	//Easy to understand
	public boolean isNStraightHands(int[] hand, int groupSize) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i: hand)
            pq.add(i);
        
        while(!pq.isEmpty()) {
            int tmp = pq.poll();
            for(int i=1; i<groupSize; i++) {
                if(!pq.remove(tmp+i))
                    return false;
            }
        }
        return true;  
    }
}
