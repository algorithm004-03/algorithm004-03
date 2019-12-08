/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        //分治s(1~n) = s(1~n-1)+s(1-n-2)
        //状态数组dp[i],代表 s(i~n)的解法
        //状态方程dp[i] = dp[i+1] + dp[i+2]

        int dp[] = new int[s.length()+1];
        dp[s.length()] = 1;
        if( s.charAt(s.length()-1) !='0'){
            dp[s.length()-1] = 1;
        }else{
            dp[s.length()-1] = 0;
        }
        for(int i = s.length()-2 ;i>=0;i--){
            if(s.charAt(i) == '0'){
                continue;
            }
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if (ten + one <= 26) {
                dp[i] = dp[i+1]+dp[i + 2];
            }else{
                dp[i] = dp[i+1];
            }
        }

        return dp[0];

    }
}
// @lc code=end

