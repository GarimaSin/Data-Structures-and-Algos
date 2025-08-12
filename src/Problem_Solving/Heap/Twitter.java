package Problem_Solving.Heap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Twitter {

	//Working
	HashMap<Integer, HashSet<Integer>> followers;
	HashMap<Integer, LinkedList<Tweet>> tweets;
	int time = 0;
	
    public Twitter() {
    	followers = new HashMap<>();
    	tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
    	LinkedList<Tweet> list = null;
    	if(tweets.containsKey(userId)) {
    		list = tweets.get(userId);
    	} else 
    		list = new LinkedList<>(); 
    	list.addFirst(new Tweet(tweetId, time));
    	tweets.put(userId, list);
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
    	PriorityQueue<Tweet> pq = new PriorityQueue<>();
        HashSet<Integer> followingSet = followers.get(userId);
        if(followingSet == null) 
        	followingSet = new HashSet<>();

        followingSet.add(userId);
        
        for(int uid: followingSet) {
        	LinkedList<Tweet> list = tweets.get(uid);
        	if(list == null)
        		continue;
        	for (int i = 0; i < list.size(); i++) {
        		pq.add(list.get(i));			//cannot do list.remove coz that will affect the tweets map also
			}
        }
        
        List<Integer> ans = new LinkedList<>();
        int count = 0;
        while(!pq.isEmpty() && count < 10) {
			ans.add(pq.remove().tid);
            count++;
		}
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> user = followers.getOrDefault(followerId, new HashSet<Integer>());
        user.add(followeeId);
        followers.put(followerId, user);
    }
    
    public void unfollow(int followerId, int followeeId) {
    	if(followers.containsKey(followerId)) {
    		followers.get(followerId).remove(followeeId);
    	}
    }
    
    public static void main(String[] args) {
    	Twitter twitter = new Twitter();
    	twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
    	twitter.postTweet(1, 3);
    	twitter.postTweet(1, 101);
    	twitter.postTweet(1, 13);
    	twitter.postTweet(1, 10);
    	twitter.postTweet(1, 2);
    	twitter.postTweet(1, 94);
    	twitter.postTweet(1, 505);
    	twitter.postTweet(1, 333);
    	twitter.postTweet(1, 22);
    	twitter.postTweet(1, 11);
    	twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
//    	twitter.follow(1, 2);    // User 1 follows user 2.
//    	twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
//    	twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
//    	twitter.unfollow(1, 2);  // User 1 unfollows user 2.
//    	twitter.getNewsFeed(1);  // User 1's news feed should return a 
	}
    
    static class Tweet implements Comparable<Tweet>{
    	int tid;
    	int time;
    	
    	Tweet(int tid, int time) {
    		this.tid = tid;
    		this.time = time;
    	}
    	
    	public int compareTo(Tweet o2) {
			return Integer.compare(o2.time, this.time);
		}
    }
}