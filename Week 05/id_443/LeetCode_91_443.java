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

package com.modds.alltest.leetcode.editor.cn;

public class LeetCode_91_443_DecodeWays {
    public static void main(String[] args) {
        Solution solution = new LeetCode_91_443_DecodeWays().new Solution();
        System.out.println(solution.numDecodings("1010"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 不能逆序　： 1010 ， 010  无法通过
         * 重复子问题：  a[i] = v(i,1)?a[i-1]:0 + v(i-1,2)?a[i-2]:0
         *
         * @param s
         * @return
         */
        public int numDecodings(String s) {
            if (s.length() == 1) {
                return valid(s, s.length() - 1, 1) ? 1 : 0;
            }

            int x = valid(s, 0, 1) ? 1 : 0;
            int y = (valid(s, 1, 1) ? x : 0)
                    + (valid(s, 0, 2) ? 1 : 0);

            for (int i = 2; i < s.length(); i++) {
                int one = valid(s, i, 1) ? y : 0;
                int two = valid(s, i - 1, 2) ? x : 0;
                if (one == two && one == 0) {
                    return 0;
                }
                x = y;
                y = one + two;
            }
            return y;
        }

        private boolean valid(String s, int start, int n) {
            int m1 = s.charAt(start) - '0';
            if (m1 > 0 && n == 2) {
                int num = m1 * 10 + s.charAt(start + 1) - '0';
                return num < 27;
            } else {
                return m1 > 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}