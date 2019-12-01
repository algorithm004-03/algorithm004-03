/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * @author gning (id=698)
 */

 public class LeetCode_32_698 {

    public int longestValidParentheses(String s) {
        char[] ss = s.toCharArray();
        int[] dp = new int[ss.length];

        int maxlen = 0;

        for(int i=1; i<ss.length; i++) {
            if (ss[i] == ')') {
                if(ss[i-1] == '(') {
                    dp[i] = ( i>=2 ? dp[i-2] : 0) + 2;
                }else if(i - dp[i-1]>0 && ss[i - dp[i-1] - 1] == '(' ) {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }

                maxlen = Math.max(maxlen,dp[i]);

            }
        }

        return maxlen;
    }

 }