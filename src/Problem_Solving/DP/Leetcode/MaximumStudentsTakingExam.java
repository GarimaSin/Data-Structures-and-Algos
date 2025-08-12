package Problem_Solving.DP.Leetcode;

import java.util.HashMap;
import java.util.Map;

class MaximumStudentsTakingExam {

	public static void main(String[] args) {
		char[][] seats = {{'#','.','#','#','.','#'},
				{'.','#','#','#','#','.'},
				{'#','.','#','#','.','#'}}; 
		System.out.println(maxStudents(seats));
	}

	// Logic not correct (coz skipping the seat logic not taken into account) - giving TLE.
	static int maxStudents(char[][] seats) {
		int r = seats.length+1;
		int c = seats[0].length;
		return getMaxStudents(seats, 0, 0, new boolean[r][c]);
	}

	static int getMaxStudents(char[][] seats, int r, int c, boolean[][] vis) {
		if(r >= seats.length)
			return 0;

		int max = 0;
		for(int i=c; i<seats[r].length; i++) {
			if(seats[r][i] == '#')
				continue;
			if(!vis[r][i]) {
				if(isSafe(r, i, seats, vis)) {
					vis[r][i] = true;
					int ans = 1 + getMaxStudents(seats, r, i+1, vis);
					vis[r][i] = false;
					max = Math.max(ans, max);
				}
			}
		}
		int ans = getMaxStudents(seats, r+1, 0, vis);		//next row
		max = Math.max(ans, max);
		return max;
	}

	static boolean isSafe(int i, int j, char[][] seats, boolean[][] vis) {
		if(i>=0 && j>=0 && i<seats.length && j<seats[0].length) {
			if((j-1 >= 0 && vis[i][j-1]) || (j+1<seats[0].length && vis[i][j+1]))
				return false;

			if(i-1 >= 0) {		//i+1,j-1    i+1,j+1
				if(j-1>=0 && vis[i-1][j-1])
					return false;

				if(j+1<seats[0].length && vis[i-1][j+1])
					return false;
			}	
		}
		return true;
	}

	// ==================================================================================
	
	
	// Working - 14%
	public int maxStudents1(char[][] seats) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(seats, 0, 0, 0, 0, memo);  // row, col, currRowMask, prevRowMask
    }

    int dfs(char[][] seats, int row, int col, int currRowMask, int prevRowMask, Map<String, Integer> memo) {
        int m = seats.length, n = seats[0].length;

        if (col == n)	// Move to next row
            return dfs(seats, row+1, 0, 0, currRowMask, memo);
       
        if (row == m) 
        	return 0;

        String key = row + "," + col + "," + currRowMask + "," + prevRowMask;
        if (memo.containsKey(key)) 
        	return memo.get(key);

        int max = 0;

        // Option 1: Skip this seat
        max = dfs(seats, row, col+1, currRowMask, prevRowMask, memo);

        // Option 2: Try placing a student
        if (seats[row][col] == '.') {
            if (isSafe(col, n, currRowMask, prevRowMask)) {
                int newCurrRowMask = currRowMask | (1 << col);
                int placed = 1 + dfs(seats, row, col+1, newCurrRowMask, prevRowMask, memo);
                max = Math.max(max, placed);
            }
        }
        memo.put(key, max);
        return max;
    }
    
    boolean isSafe(int col, int n, int currRowMask, int prevRowMask) {
    	if(!(col > 0 && ((currRowMask & (1 << (col-1))) != 0)))		// left
    		return false; 
    	if(!(col < n-1 && ((currRowMask & (1 << (col+1))) != 0)))	// right
    	   return false; 
        if(!(col > 0 && ((prevRowMask & (1 << (col-1))) != 0)))  	// diagLeft
        	return false;
        if(!(col < n-1 && ((prevRowMask & (1 << (col+1))) != 0)))  	// diagRight
        	return false;
        
        return true;
    }
	
	
	
	// ==================================================================================

	// Working - 57%
	static Integer[][] dp;
	// Converts char[][] to List<List<Character>> and calls recurse
	static int maxStudents2(char[][] seats) {
		int rows = seats.length;
		int cols = seats[0].length;

		dp = new Integer[rows][1 << cols];      // Maximum bitmask = 2^cols
		return recurse(0, 0, seats, cols);
	}

	static int recurse(int currRow, int prevMask, char[][] seats, int n) {
		if (currRow >= seats.length)
			return 0;

		if (dp[currRow][prevMask] != null)
			return dp[currRow][prevMask];

		int ans = 0;
		int totalConfigs = 1 << n;			// It is same as 2^n - 1

		for (int currMask = 0; currMask < totalConfigs; currMask++) {
			if (checkIfGood(currMask, prevMask, seats, currRow, n)) {
				ans = Math.max(ans, countBits(currMask, n) + recurse(currRow + 1, currMask, seats, n));
			}
		}
		return dp[currRow][prevMask] = ans;
	}

	// Count how many bits are set to 1 in a no. (no. of students seated in row)
	// Can be replaced with: Integer.bitCount(currMask)
	static int countBits(int x, int n) {
		int cnt = 0;
		for (int i=0; i<n; i++) {
			if (((x >> i) & 1) == 1) 
				cnt++;
		}
		return cnt;
	}

	// Check if the current bitmask configuration is valid for the current row
	static boolean checkIfGood(int currMask, int prevMask, char[][] seats, int currRow, int n) {
		int prevBit = 0;

		for (int i = 0; i < n; i++) {
			boolean set = ((currMask & (1 << i)) != 0);

			if (!set) {
				prevBit = 0;
				continue;
			}

			if (seats[currRow][i] == '#' || prevBit == 1)
				return false;

			// Check diagonal conflicts from previous row
			if (i > 0 && ((prevMask & (1 << (i - 1))) != 0)) 
				return false;
			if (i < n - 1 && ((prevMask & (1 << (i + 1))) != 0))
				return false;

			prevBit = 1;
		}  
		return true;
	}


	// ==================================================================================


	// Working - fastest - 97%
	int m, n;
	int[] valid;      // valid seats mask per row
	Integer[][] memo; // memo[currRowMask][rowIndex]

	int maxStudents3(char[][] seats) {
		m = seats.length;
		n = seats[0].length;
		valid = new int[m];
		// Build valid mask: 1=seat usable, 0=broken
		for (int i=0; i<m; i++) {
			int mask = 0;
			for (int j = 0; j < n; j++) {
				if (seats[i][j] == '.') mask |= (1 << j);
			}
			valid[i] = mask;
		}
		memo = new Integer[1 << n][m];
		// Start from row 0, with full valid mask
		return dfs(valid[0], 0);
	}

	
	int dfs(int currMask, int row) {
		if (row == m) 
			return 0;
		if (memo[currMask][row] != null) 
			return memo[currMask][row];

		int best = 0;
		// Enumerate all submasks s of currMask
		for (int s=currMask;    ; s = (s-1) & currMask) {
			// skip invalid patterns: adjacent seats
			if ((s & (s << 1)) == 0) {
				int cnt = Integer.bitCount(s);
				int nextMask = (row+1 < m ? valid[row+1] : 0);
				if (row+1 < m) {
					nextMask &= ~(s << 1);
					nextMask &= ~(s >> 1);
				}
				int ans = cnt + dfs(nextMask, row + 1);
				best = Math.max(best, ans);
			}
			if (s == 0) 
				break;
		}
		return memo[currMask][row] = best;
	}
}
