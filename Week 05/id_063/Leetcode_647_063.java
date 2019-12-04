/*

思路
动态规划递推

dp[i][j] 表示i开始j结尾的字符串是不是回文

递推关系如下

j == i+1:
    dp[i][j] = s[i] == s[j] ? true : false

j < i
    dp[i][j] = false

j > i+1 :
    dp[i][j] = s[i] == s[j] ? dp[i+1][j-1] : false


 */



class Solution {
    public int countSubstrings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int len = s.length();

        boolean[] dp_old = new boolean[len];
        boolean[] dp_new = new boolean[len];

        //i = s.length() - 1 时候初始化dp数值
        dp_old[len-1] = true;

        int cnt = 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i ; j < len; j++) {
                if (j == i) {
                    dp_new[j] = true;
                } else if (j == i+1) {
                    dp_new[j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp_new[j] = (s.charAt(i) == s.charAt(j)) && dp_old[j-1];
                }

                if (dp_new[j]) {
                    cnt++;
                }
            }

            boolean[] tmp = dp_old; dp_old = dp_new; dp_new = tmp;
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSubstrings("aaa"));
    }
}