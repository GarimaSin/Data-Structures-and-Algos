package Problem_Solving.Backtracking;

import java.util.TreeSet;


//Running fine but giving error for "12:00" string
// LC - 401. Binary Watch
public class BinaryWatch {

	public static void main(String[] args) {
		int num = 2;
		int leds[] = {8,4,2,1,32,16,8,4,2,1};
		int hour = 0;
		int min  = 0;
		boolean vis[] = new boolean[leds.length];
		TreeSet<String> unique = new TreeSet<String>();
		findTime(hour, min, leds, num, 0, vis, unique);
		System.out.println(unique);
	}

	static void findTime(int hour, int min, int[] leds, int num, int idx, boolean[] vis, TreeSet<String> unique) {
		if(hour > 12 || min > 59)
			return;

		if(num == 0) {
			if(min == 60)	{
				hour = hour+1;
				min = 0;
			}
			if(hour > 12 || min > 59)
				return;
			if(min < 10) {
				String tmp = hour+":0"+min;
				if(!unique.contains(tmp)) {
//					System.out.println(tmp);
					unique.add(tmp);
				}
			} else  {
				String tmp = hour+":"+min;
				if(!unique.contains(tmp)) {
//					System.out.println(tmp);
					unique.add(tmp);
				}
			}
			return;
		}


		for(int i=0; i<leds.length; i++) {
			if(!vis[i]) {
				vis[i] = true;
				if(i<4)
					findTime(hour+leds[i], min, leds, num-1, idx+1, vis, unique);
				else
					findTime(hour, min+leds[i], leds, num-1, idx+1, vis, unique);
				vis[i] = false;
			}
		}
	}

}
