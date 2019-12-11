package id_693;

/**
 * @Author 李雷（KyLin）
 * @Desc 557. 反转字符串中的单词 III	https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * @Date 2019/12/05
 */
public class LeetCode_557_693 {
    /**
     * 结合之前的反转思想
     */
    class Solution {
        public String reverseWords(String s) {
            String[] strs = s.split(" ");
            StringBuilder result = new StringBuilder(s.length());
            for (String str : strs) {
                char[] chars = str.toCharArray();
                int i = 0;
                int j = chars.length - 1;
                while (i < j) {
                    chars[i] ^= chars[j];
                    chars[j] ^= chars[i];
                    chars[i++] ^= chars[j--];
                }
                result.append(String.valueOf(chars)).append(" ");
            }
            if (result.length() > 0) {
                result.deleteCharAt(result.length() - 1);
            }
            return result.toString();
        }
    }

    /**
     * 效率高于上一个解法，直接用一个chars数组，然后用双指针 一直招" " 循环修改。
     */
    class Solution2 {
        public String reverseWords(String s) {
            char[] chars = s.toCharArray();
            int i = 0;
            int len = s.length();
            while (i < len) {
                int j = s.indexOf(" ",i + 1);
                if (j < 0) {
                    j = len;
                }
                reverse(chars,i,j - 1);
                i = j + 1;
            }
            return String.valueOf(chars);
        }

        private void reverse(char[] chars,int i,int j) {
            while (i < j) {
                chars[i] ^= chars[j];
                chars[j] ^= chars[i];
                chars[i++] ^= chars[j--];
            }
        }
    }
}
