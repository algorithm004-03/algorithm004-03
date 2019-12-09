package id_693;

/**
 * @Author 李雷（KyLin）
 * @Desc 680. 验证回文字符串 Ⅱ	https://leetcode-cn.com/problems/valid-palindrome-ii/
 * @Date 2019/12/05
 */
public class LeetCode_680_693 {
    /**
     * 双指针解法，AC
     */
    class Solution {
        public boolean validPalindrome(String s) {
            char[] chars = s.toCharArray();
            int i = 0;
            int j = chars.length - 1;
            //双指针循环找出不等于的字符索引
            while (i < j && chars[i] == chars[j]) {
                i++;
                j--;
            }
            //如果还有字符串，则删除左边循环判断
            if (isValid(chars,i + 1,j)) return true;
            //如果还有字符串，则删除右边循环判断
            if (isValid(chars,i,j - 1)) return true;
            //如果上面都是false，那么结果肯定是false
            return false;
        }

        //验证是否是回文
        private boolean isValid(char[] chars,int i,int j) {
            while (i < j) {
                if (chars[i++] != chars[j--]) {
                    return false;
                }
            }
            return true;
        }
    }
}
