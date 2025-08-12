package Problem_Solving.Array.Pepcoding;

import java.util.Arrays;

public class BoatsToSavePeople {
	public static int numRescueBoats(int[] people, int limit) {
		int ans = 0;
		int i = 0;
		int j = people.length - 1;

		Arrays.sort(people);

		while (i <= j) {
			if (people[i] + people[j] > limit) {
				j--;
				ans++;
			} else if(people[i] + people[j] <= limit){
				ans++;
				i++;
				j--;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] people = {3,2,2,1};
		int limit = 3;
		int boats = numRescueBoats(people, limit);
		System.out.println(boats);
	}
}
