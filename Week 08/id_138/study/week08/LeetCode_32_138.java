package study.week08;

/**
 * 最长有效括号
 * @author Lukas
 * @since 2019/12/8 18:45
 **/
public class LeetCode_32_138 {

    public int longestValidParentheses(String s) {
        int max = 0;
        int len = s.length();
        int dp[] = new int[s.length()];//数组初始值全部为0,
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2?dp[i-2]:0)+2;//动态方程1
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i-1]+((i-dp[i-1])>=2?dp[i-dp[i-1]-2]:0) +2;//动态方程2
                }
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }

}
