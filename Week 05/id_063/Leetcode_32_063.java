/*

思路
动态规划求解
合法子串有一个性质，就是多个合法子串连续穿起来也是合法子串，且每一个子串都以右括号结尾

dp[i]表示以i结尾的合法子串最长长度
看i和i前面字符，如果是()形式，i结尾的最长子字符串就是i-1结尾的最长子字符串加上后面两个字符
如果是))形式，如果i结尾的合法子串存在，i就必须找一个左括号来匹配，这个匹配位置肯定在一个i-1位置
结尾的合法子串的前面，但是如果这个i-i结尾的子串不是最长的，那它前面肯定还有一个合法子串紧跟在它前面
所以它前面一个字符一定是右括号，所以要找这个匹配位置，只可能在i-i结尾的最长子串的前面才可能找到

所以可以总结递推关系如下
最后两个字符是()形式
    dp[i] = dp[i-2] + 2
最后两个字符是))形式
    i-1 - dp[i-1] 位置是左括号
        dp[i] = dp[i-1] + 2 + dp[i-2 - dp[i-1]];


其他
    dp[i] = 0


 */

class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return 0;
        }

        int[] dp = new int[s.length()];

        dp[0] = 0; dp[1] = (s.charAt(0) == '(' && s.charAt(1) == ')') ? 2 : 0;
        int max = Math.max(dp[0], dp[1]);
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) != ')') {
                dp[i] = 0;
                continue;
            }

            if (s.charAt(i-1) == '(') {
                dp[i] = dp[i-2] + 2;
            } else {
                if (i-1-dp[i-1] >= 0 && s.charAt(i-1-dp[i-1]) == '(') {
                    dp[i] = dp[i-1] + 2;
                    if (i-2-dp[i-1] >= 0) {
                        // 还要加上前面的一串
                        dp[i] += dp[i-2-dp[i-1]];
                    }
                } else {
                    dp[i] = 0;
                }
            }

            max = Math.max(dp[i], max);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses("()(())"));
    }
}