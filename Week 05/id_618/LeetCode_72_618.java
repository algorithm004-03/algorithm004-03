class Solution {
	public int minDistance(String word1, String word2) {
		int n = word1 != null ? word1.length() : 0;
		int m = word2 != null ? word2.length() : 0;

		if (n == 0) {
			return m;
		}

		if (m == 0) {
			return n;
		}

		int[][] d = new int[n + 1][m + 1];

		for (int i = 1; i < n + 1; i++) {
			d[i][0] = i;
		}

		for (int j = 1; j < m + 1; j++) {
			d[0][j] = j;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				int left = d[i - 1][j] + 1;
				int down = d[i][j - 1] + 1;
				int leftDown = d[i - 1][j - 1] + 1;

				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					leftDown--;
				}

				d[i][j] = Math.min(left, Math.min(down, leftDown));

			}
		}

		return d[n][m];
	}
}