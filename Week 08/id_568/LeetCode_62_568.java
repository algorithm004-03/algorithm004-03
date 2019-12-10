import java.util.Arrays;

public class LeetCode_62_568 {
	public static int uniquePaths(int m, int n) {
		if (m <= 0 && m > 100 || n < 0 && n > 100) {
			return 0;
		}
		int less = Math.min(m, n);
		int more = Math.max(m, n);
		int[] dp = new int[less];
		Arrays.fill(dp, 1);
		for (int i = 1; i < more; i++) {
			for (int j = 1; j < less; j++) {
				dp[j] = dp[j - 1] + dp[j];
			}
		}
		return dp[less-1];

	}
}
