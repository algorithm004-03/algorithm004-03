/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;

        // 提取s的长度
        int n = s.length();

        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = (s.charAt(n - 1) == '0' ? 0 : 1);

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }

            if ((s.charAt(i) - '0' * 10 + s.charAt(i + 1) - '0') <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }

        return dp[0];
    }

    public int numDecodingsPlus(String s) {
        if (s == null || s.length() == 0) return 0;

        // 提取s的长度
        int len = s.length();

        int help = 1; // 相当于 初始化 dp[len + 1[ = 1 的意思
        int res = (s.charAt(len - 1) != '0' ? 1 : 0); // 倒数第2个值, 也就是是

        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                help = res;
                res = 0;
                continue;
            }

            if ((s.charAt(i - '0') * 10 + s.charAt(i + 1 - '0')) <= 26) {
                res += help;
                help = res - help; // help用于存储res之前的值
            } else {
                help = res;
            }
        }

        return res;
    }
}
// @lc code=end

