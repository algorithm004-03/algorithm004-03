package id_693;

import org.junit.Assert;

/**
 * @Desc 32. 最长有效括号  	https://leetcode-cn.com/problems/longest-valid-parentheses/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/16
 */
public class LeetCode_32_693 {
    //dp解法：下面是个人看的，别人看了会绕。勿看
    /*
        当   s[i] 为 (,   dp[i] 必然等于 0，因为不可能组成有效的括号；
        那么 s[i] 为 )
            2.1 当 s[i-1] 为 (，那么 dp[i] = dp[i-2] + 2；那么DP方程为：dp[i] = dp[i - 2] + 2;
            2.2 当 s[i-1] 为 ) 并且 s[i-dp[i-1] - 1] 为 (，那么DP方程为 dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2]；
     */
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        Assert.assertEquals(2, new LeetCode_32_693().longestValidParentheses("()(()"));
        Assert.assertEquals(4, new LeetCode_32_693().longestValidParentheses(")()())"));
        Assert.assertEquals(2, new LeetCode_32_693().longestValidParentheses("())"));
        Assert.assertEquals(2, new LeetCode_32_693().longestValidParentheses("(()"));
    }
}
