package Problem_Solving.Recursion.Pepcoding;

public class TeamFormationHackerrank {

	public static void main(String[] args) {
		int skills[] = {4, 8, 7, 5};
		int minTeamSize = 1;
		int minSkillLevel = 5;
		int maxSkillLevel = 7;
		countTeams(skills, minTeamSize, minSkillLevel, maxSkillLevel);
	}

	private static void countTeams(int[] skills, int minTeamSize, int minSkillLevel, int maxSkillLevel) {
//		findCount(skills, minTeamSize, minSkillLevel, maxSkillLevel, 0, 0, new boolean[skills.length], "");
		findCount2(skills, minTeamSize, minSkillLevel, maxSkillLevel, 0, 0, "");
	}

	static int ans = 0;
	
	//Not working - check reason
	private static void findCount(int[] skills, int minTeamSize, int minSkillLevel, int maxSkillLevel, int index, int count,
			boolean[] vis, String a) {

		if(count >= minTeamSize) {
			ans++;
			System.out.println( a);
			System.out.println(ans + "...." + count);
			System.out.println("--------------");
		}
		
		if(index > skills.length-1)
			return;

		for (int i = index; i < skills.length; i++) {
			if(!vis[i]) {
				if(minSkillLevel <= skills[i] && skills[i] <= maxSkillLevel) {
					vis[i] = true;
					findCount(skills, minTeamSize, minSkillLevel, maxSkillLevel, index+1, count+1, vis, a+" "+skills[i]);
					vis[i] = false;
				}
			}
		}
	}


	private static void findCount2(int[] skills, int minTeamSize, int minSkillLevel, int maxSkillLevel, int idx, int count,
			String a) {

		if(count >= minTeamSize) {
			ans++;
			System.out.println( a);
			System.out.println(ans + "...." + count);
			System.out.println("--------------");
		}
		
		if(idx > skills.length-1)
			return;

		if(minSkillLevel <= skills[idx] && skills[idx] <= maxSkillLevel) {
			findCount2(skills, minTeamSize, minSkillLevel, maxSkillLevel, idx+1, count+1, a+" "+skills[idx]);
		}
		findCount2(skills, minTeamSize, minSkillLevel, maxSkillLevel, idx+1, count, a);
	}
}

