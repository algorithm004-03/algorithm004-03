package id_693;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author 李雷（KyLin）
 * @Desc 151. 翻转字符串里的单词	https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * @Date 2019/12/05
 */
public class LeetCode_151_693 {
    /**
     * 普通的单词转换
     */
    class Solution {
        public String reverseWords(String s) {
            String[] strs = s.trim().split(" +");
//            String[] strs = s.trim().split(" +");  使用" +" 会很影响性能，极大的影响，加了8秒 不加2秒，只是需要处理下""的情况
            int i = 0;
            int j = strs.length - 1;
            while (i < j) {
                String temp = strs[i];
                strs[i++] = strs[j];
                strs[j--] = temp;
            }
            StringBuilder str = new StringBuilder();
            for (String ss : strs) {
                if (ss.length() == 0 )continue;
                str.append(ss);
                str.append(" ");
            }
            return str.toString().trim();
        }
    }

    /**
     * 直接内置函数加身，复杂度同上，因为用的" +" 所以性能leetcode是8秒，其他处理了的只有2秒
     */
    class Solution2 {
        public String reverseWords(String s) {
            String[] strs = s.trim().split(" +");
            Collections.reverse(Arrays.asList(strs));
            return String.join(" ",strs);
        }
    }

    class Solution3 {
        public String reverseWords(String s) {
            String[] strs = s.trim().split(" +");
            StringBuilder stringBuilder = new StringBuilder(s.length());
            for (int i = strs.length - 1;i >= 0;i--) {
                if (strs[i].length() != 0) {
                    stringBuilder.append(strs[i]).append(" ");
                }
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            return stringBuilder.toString();
        }
    }
}
