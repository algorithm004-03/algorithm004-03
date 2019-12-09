class Solution {
    public int longestValidParentheses(String s) {
        int dp[] = new int[s.length()];
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    dp[i] = (i>=2 ? dp[i-2] : 0) + 2;
                }else if (i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '(') {
                    dp[i] = dp[i-1] + (i-dp[i-1]-1 >=2 ? dp[i-dp[i-1]-2] : 0) + 2;
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
     }
}