package com.company.leetcode.editor.cn;
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
// count = 2
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution_5 {

    public String longestPalindrome(String s) {

        if (s == null || s.length() < 1) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int start = 0;
        int end = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {

            int len1 = expand(s,i,i);
            int len2 = expand(s,i,i+1);
            int len = Math.max(len1,len2);
            if (len > maxLen) {
                start = i - (len - 1)/2;
                end = i + len/2;
                maxLen = len;
            }

        }

        return s.substring(start,end + 1);
    }

    private int expand(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left -1;
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        System.out.println(s.longestPalindrome("cbbd"));
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
