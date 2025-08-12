package Problem_Solving.Leetcode.Backtracking;

public class MinNoofWorkSessionsToFinishTasks {

	//Not Working for i/p [5,7,5] , 7
	public static int minSessions(int[] tasks, int sessionTime) {
		findMinTime(tasks, sessionTime, 0, 0, "", 1, new boolean[tasks.length]);
		System.out.println(res);
		res = Integer.MAX_VALUE;
		findMinTime1(tasks, sessionTime, 0, 0, "", 1);
		System.out.println(res);
		return res;
	}


	static int res = Integer.MAX_VALUE;
	private static void findMinTime(int[] tasks, int sessionTime, int idx, int time, String ans, int totSessions, boolean[] vis) {
		if(idx == tasks.length) {
			if(totSessions < res && totSessions != 0) {
				res = totSessions;
			}
			return;
		}

		for (int i = 0; i < tasks.length; i++) {
			if(!vis[i]) {
				if(time+tasks[i] > sessionTime) {
					totSessions = totSessions+1;
					int tmp = time;
					time = 0;
					vis[i] = true;
					findMinTime(tasks, sessionTime, idx+1, time, ans+tasks[i], totSessions, vis);
					time = tmp;
					totSessions = totSessions-1;
					vis[i] = false;
				} else {
					vis[i] = true;
					findMinTime(tasks, sessionTime, idx+1, time+tasks[i], ans+tasks[i], totSessions, vis);
					vis[i] = false;
				}
			}
		}
	}

	//Time is not calculated correctly
	private static void findMinTime1(int[] tasks, int sessionTime, int i, int time, String ans, int totSessions) {
		if(i >= tasks.length) {
			if(totSessions < res && totSessions != 0) {
				res = totSessions;
				System.out.println(res + "...........");
			}
			return;
		}

		if(time+tasks[i] > sessionTime) {
			int tmp = time;
			time = 0;
			findMinTime1(tasks, sessionTime, i+1, time+tasks[i], ans+tasks[i], totSessions+1);
			time = tmp;
		} else {
			findMinTime1(tasks, sessionTime, i+1, time+tasks[i], ans+tasks[i], totSessions);
		}
		findMinTime1(tasks, sessionTime, i+1, time, ans, totSessions);
	}


	public static void main(String[] args) {
		int[] tasks = {5,7,5};
		int sessionTime = 7;
		minSessions(tasks, sessionTime);
	}
}