class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        // 状态转移方程
        /**
         * case 右括号 ）结尾为合法字符
         * 右括号前面为（ 那么 dp[i] = dp[i-1]+2
         * 右括号前面一个为 ）
         * 那么要判断出前一个有效顺序的长度，以及有效长度前面一个是否为（ 这样才满足合法条件
         * 这样case 情况下 dp[i] = dp[i-1]+(i-d(i-1)-1>0?:dp[i-d(i-1)-2]:0)+2;
         * 依次递推
         */
        for (int i = 1; i < dp.length; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2 + (i - 2 > 0 ? dp[i - 2] : 0);
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 > 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}