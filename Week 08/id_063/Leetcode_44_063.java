/*

动态规划

dp(i, j) 表示s[0:i] 和 p[0:j]能不能匹配

p[j]是*情况下，*有两种处理，一种是匹配空串，直接把*消耗掉，一种是*消耗掉s[i], 然后留给s[0:i-1]消耗，
留下去消耗不会带来更差结果，因为* 是可以匹配空串的，*不想要的时候可以随时舍弃
此时 dp(i, j) = dp(i-1, j) | dp(i, j-1)

p[j]是？情况下 dp(i, j) = dp(i-1, j-1)

p[j]是其他字符情况下 dp(i, j) = s[i] == p[j] ? dp(i-1, j-1) : false


 */


class Solution {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0) {
            // s为空，只有可能p全部为*或者p为空串才可能
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) != '*')
                    return false;
            }

            return true;
        }

        if (p.length() == 0) {
            return false;
        }

        boolean[][] dp = new boolean[s.length()][p.length()];

        // i = 0 时候边界初始化
        boolean flag = true;
        boolean allStar = true;     // 目前是不是所有都是*
        for (int j = 0; j < p.length(); j++) {
            if (allStar) {
                if (p.charAt(j) == '*') {
                    dp[0][j] = true;
                } else if (p.charAt(j) == '?') {
                    dp[0][j] = true; allStar = false;
                } else {
                    dp[0][j] = p.charAt(j) == s.charAt(0); allStar = false;
                    flag = p.charAt(j) == s.charAt(0);
                }
            } else {
                if (!flag) {
                    dp[0][j] = false;
                } else {
                    if (p.charAt(j) == '*') {
                        dp[0][j] = true;
                    } else {
                        dp[0][j] = false; flag = false;
                    }
                }
            }
        }

        for (int i = 1; i < s.length(); i++) {
            dp[i][0] = p.charAt(0) == '*';

            for (int j = 1; j < p.length(); j++) {
                if (p.charAt(j) == '*') {
                    dp[i][j] = dp[i][j-1] | dp[i-1][j];
                } else if (p.charAt(j) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = s.charAt(i) == p.charAt(j) ? dp[i-1][j-1] : false;
                }
            }
        }

        return dp[s.length()-1][p.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("adceb", "a*b"));
    }
}