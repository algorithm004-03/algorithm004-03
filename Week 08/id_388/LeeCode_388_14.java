package com.company.leetcode.editor.cn;
//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
// 示例 1:
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
//
//
// 示例 2:
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//
//
// 说明:
//
// 所有输入只包含小写字母 a-z 。
// Related Topics 字符串



//leetcode submit region begin(Prohibit modification and deletion)
class Solution_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        char[] com = strs[0].toCharArray();
        int resLen = com.length;
        for (int i = 1; i < strs.length; i++) {
            String tmp = strs[i];
            resLen = Math.min(tmp.length(),resLen);
            for (int j = 0; j < resLen; j++) {
                if (tmp.charAt(j) != com[j]) {
                    resLen = j;
                    break;
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resLen; i++) {
            sb.append(com[i]);
        }
        return sb.toString();
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        String[] strs = new String[]{"aa","a"};
//        System.out.println(s.longestCommonPrefix(strs));
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
