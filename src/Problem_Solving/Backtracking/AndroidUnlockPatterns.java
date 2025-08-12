package Problem_Solving.Leetcode.Backtracking;

public class AndroidUnlockPatterns {


	static int DOTS = 10;
	static int totalPatternFromCur(boolean visit[], int jump[][], int cur, int toTouch) {
		if (toTouch <= 0)	{
			// if last cell then return 1 way
			return (toTouch == 0) ? 1 : 0;
		}

		int ways = 0;

		// make this cell visited before going to next call
		visit[cur] = true;

		for (int i = 1; i < DOTS; i++)	{

			/* if this cell is not visit AND either i and cur are adjacent (then jump[i][cur] = 0) or between cell 
			 * must be visit already (then visit[jump[i][cur]] = 1) */
			if (!visit[i] && (jump[i][cur] == 0 || visit[jump[i][cur]]))
				ways += totalPatternFromCur(visit, jump, i, toTouch - 1);
		}

		// make this cell not visited after returning from call
		visit[cur] = false;
		return ways;
	}

	//method returns no. of pattern with min m connection and max n connection
	static int waysOfConnection(int m, int n) {
		int [][]jump = new int[DOTS][DOTS];

		// 2 lies between 1 and 3
		jump[1][3] = jump[3][1] = 2;

		// 8 lies between 7 and 9
		jump[7][9] = jump[9][7] = 8;

		// 4 lies between 1 and 7
		jump[1][7] = jump[7][1] = 4;

		// 6 lies between 3 and 9
		jump[3][9] = jump[9][3] = 6;

		// 5 lies between 1, 9 2, 8 3, 7 and 4, 6
		jump[1][9] = jump[9][1] = jump[2][8] =
				jump[8][2] = jump[3][7] =
				jump[7][3] = jump[4][6] =
				jump[6][4] = 5;

		boolean []visit = new boolean[DOTS];
		int ways = 0;
		for (int i = m; i <= n; i++)	{
			// 1, 3, 7, 9 are symmetric so multiplying by 4
			ways += 4 * totalPatternFromCur(visit, 	jump, 1, i - 1);

			// 2, 4, 6, 8 are symmetric so multiplying by 4
			ways += 4 * totalPatternFromCur(visit, 	jump, 2, i - 1);

			ways += totalPatternFromCur(visit,	jump, 5, i - 1);
		}
		return ways;
	}

	public static void main(String[] args)	{
		int minConnect = 4;
		int maxConnect = 6;

		System.out.println(waysOfConnection(minConnect,
				maxConnect));
	}
}
