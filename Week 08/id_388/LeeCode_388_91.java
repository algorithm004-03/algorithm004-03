package com.company.leetcode.editor.cn;
//一条包含字母 A-Z 的消息通过以下方式进行了编码：
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。
//
// 示例 1:
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
//
//
// 示例 2:
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
//
// Related Topics 字符串 动态规划


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        if (s.charAt(0) == '0') {
            return 0;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i <= s.length(); i++) {
            char c = s.charAt(i - 1);
            char pre = s.charAt( i - 2);
            if (c == '0') {
                //处理 10，20
                if (pre == '1' || pre == '2') {
                    dp[i] = dp[i - 2];
                    continue;
                }
                return 0;
            }


            if ((pre == '1') || (pre == '2' && (c >= '1' && c <= '6'))) { //1*  2*
                dp[i] = dp[i - 1] + dp[i - 2];
                continue;
            }
            dp[i] = dp[i - 1];
        }
        return dp[s.length()];
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        System.out.println(s.numDecodings("100"));
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
