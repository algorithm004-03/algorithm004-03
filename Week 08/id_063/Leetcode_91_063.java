/*

DP 算法求解
dp[i]表示i位置结尾的字符串的编码方式个数
显然最后一个字符i要么最为一个两位数的最后一位，要么自己作为一个一位数
num = (s[i-1]-'0')*10 + (i-'0') 在1到26之间，就可以组成两位数
    dp[i] = dp[i-2] + dp[i-1]
其他
    dp[i] = dp[i-1]


 */

class Solution {
    private int char2num(char ch1, char ch2) {
        return (ch1 - '0') * 10 + (ch2 - '0');
    }

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int[] dp = new int[s.length()];

        dp[0] = (s.charAt(0) >='1' && s.charAt(0) <='9') ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            dp[i] = (s.charAt(i) >= '1' && s.charAt(i) <= '9') ? dp[i-1] : 0;

            if (s.charAt(i-1) != '0') {
                int num = char2num(s.charAt(i - 1), s.charAt(i));
                if ((num >= 1) && (num <= 26)) {
                    if (i >= 2) {
                        dp[i] += dp[i - 2];
                    } else {
                        dp[i] += 1;
                    }
                }
            }

        }

        return dp[s.length()-1];
    }
}
