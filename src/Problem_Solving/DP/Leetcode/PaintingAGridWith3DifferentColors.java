package Problem_Solving.DP.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaintingAGridWith3DifferentColors {
	
	
	public int colorTheGrid(int m, int n) {
		int[][] grid = new int[m][n];
		for (int[] row : grid)
			Arrays.fill(row, -1);

		Map<String, Integer> memo = new HashMap<>();
		return colorTheGrid(grid, 0, 0, memo);
	}

	// Working - TLE
	int colorTheGrid(int[][] grid, int i, int j, Map<String, Integer> memo) {
		int m = grid.length;
		int n = grid[0].length;

		if (i == m)
			return 1;

		if (j == n)
			return colorTheGrid(grid, i + 1, 0, memo);

		// Encode current state of grid as a key
		String key = encode(grid) + "," + i + "," + j;
		if (memo.containsKey(key))
			return memo.get(key);

		int ans = 0;

		for (int color=0; color<3; color++) {
			if (isSafe(grid, i, j, color)) {
				grid[i][j] = color;
				ans += colorTheGrid(grid, i, j + 1, memo);
				grid[i][j] = -1; // backtrack
			}
		}

		memo.put(key, ans);
		return ans;
	}

	// Encodes the entire grid into a string
	String encode(int[][] grid) {
		StringBuilder sb = new StringBuilder();
		for (int[] row : grid) {
			for (int cell : row) {
				sb.append(cell);
			}
			sb.append("|"); // separate rows
		}
		return sb.toString();
	}

	boolean isSafe(int[][] grid, int i, int j, int color) {
		if (i > 0 && grid[i - 1][j] == color)
			return false;
		if (j > 0 && grid[i][j - 1] == color)
			return false;
		return true;
	}
	
	
	// ==================================================================================
	
	
	// Working
	private static final int MOD = 1_000_000_007;

	static List<String> columnStates = new ArrayList<>();
	static int[][] memo;

	// Generate all valid column states of height 'rows'
	static void generateColumnStates(String currentColumn, int rowsRemaining, char prevColor) {
		if (rowsRemaining == 0) {
			columnStates.add(currentColumn);
			return;
		}

		// Try each color: 'R', 'G', 'B'
		for (char color : new char[]{'R', 'G', 'B'}) {
			if (color == prevColor) 
				continue;
			generateColumnStates(currentColumn + color, rowsRemaining-1, color);
		}
	}


	// Recursive DP function with memoization
	static int solve(int remainingCols, int prevColIdx, int m) {
		if (remainingCols == 0) 
			return 1;
		if (memo[remainingCols][prevColIdx] != -1) 
			return memo[remainingCols][prevColIdx];

		int totalWays = 0;
		String prevColumn = columnStates.get(prevColIdx);

		for (int colorIdx = 0; colorIdx < columnStates.size(); colorIdx++) {
			if(prevColIdx == colorIdx)		// color of cu. col cannot b = prev col's color
				continue;
			
			String nextColumn = columnStates.get(colorIdx);
			boolean isValid = true;

			// Check horizontal adjacency (same row, adjacent columns)
			for (int r = 0; r < m; r++) {
				if (prevColumn.charAt(r) == nextColumn.charAt(r)) {
					isValid = false;
					break;
				}
			}
			if (isValid) {
				totalWays = (totalWays + solve(remainingCols-1, colorIdx, m)) % MOD;
			}
		}
		return memo[remainingCols][prevColIdx] = totalWays;
	}

	public static int colorTheGrid1(int m, int n) {
		columnStates.clear();
		generateColumnStates("", m, '#'); // '#' means no previous color

		int numPatterns = columnStates.size();
		memo = new int[n][numPatterns];
		for (int[] row : memo) Arrays.fill(row, -1);

		int result = 0;
		for (int i = 0; i < numPatterns; i++) {
			result = (result + solve(n-1, i, m)) % MOD;
		}
		return result;
	}
}
