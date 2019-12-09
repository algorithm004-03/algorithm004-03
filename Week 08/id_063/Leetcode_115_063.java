/*
动态规划解决
dp(i, j) 表示t[0:j] 在 s[0:i] 中出现的次数

若s[i] != t[j]
    dp(i, j) = dp(i-1, j)
s[i] == t[j]
    dp(i, j) = dp(i-1, j-1) + dp(i-1, j)
 */


public class Solution {
    public int numDistinct(String s, String t) {
        if (s.length() == 0) {
            return t.length() == 0 ? 1 : 0;
        }

        if (t.length() == 0) {
            return 0;
        }

        int[][] dp = new int[s.length()][t.length()];

        dp[0][0] = s.charAt(0) == t.charAt(0) ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            dp[i][0] = s.charAt(i) == t.charAt(0) ? dp[i-1][0] + 1 : dp[i-1][0];

            for (int j = 1; j <= i && j < t.length(); j++) {
                if (t.charAt(j) != s.charAt(i)) {
                    dp[i][j] = j <= i-1 ? dp[i-1][j] : 0;
                } else {
                    dp[i][j] += (j-1 <= i-1 && j-1 >= 0) ? dp[i-1][j-1] : 0;
                    dp[i][j] += (j <= i-1) ? dp[i-1][j] : 0;
                }
            }
        }

        return dp[s.length()-1][t.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDistinct("babgbag", "bag"));
    }
}