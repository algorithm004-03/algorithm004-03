package com.company.leetcode.editor.cn;
//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
//
//
//
//
//
//
// 示例 1：
//
// 输入："ab-cd"
//输出："dc-ba"
//
//
// 示例 2：
//
// 输入："a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
//
//
// 示例 3：
//
// 输入："Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
//
//
//
//
// 提示：
//
//
// S.length <= 100
// 33 <= S[i].ASCIIcode <= 122
// S 中不包含 \ or "
//
// Related Topics 字符串


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_917 {
    public String reverseOnlyLetters(String S) {
        if (S == null || S.equals("")) {
            return "";
        }

        if (S.length() == 1) {
            return S;
        }

        char[] cs = S.toCharArray();
        int i = 0;
        int j = cs.length - 1;
        while (i < j) {
            //sweep
            if (isAlpha(S.charAt(i)) && isAlpha(S.charAt(j))) {
                char tmp = cs[i];
                cs[i++] = cs[j];
                cs[j--] = tmp;
            }
            while (i < j && !isAlpha(S.charAt(i))) {
                i++;
            }
            while (i < j && !isAlpha(S.charAt(j))) {
                j--;
            }
        }

        return new String(cs);
    }

    private boolean isAlpha(char c) {
        return  (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        //Wrong Answer: input:"a-bC-dEf-ghIj" Output:"jIhg-fEd-Cb-a" Expected:"j-Ih-gfE-dCba"
//        System.out.println(s.reverseOnlyLetters("a-bC-dEf-ghIj"));
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
