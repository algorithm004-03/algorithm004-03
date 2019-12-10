package id_693;

import org.junit.jupiter.api.Test;

/**
 * @Author 李雷（KyLin）
 * @Desc 58. 最后一个单词的长度	https://leetcode-cn.com/problems/length-of-last-word/
 * @Date 2019/12/04
 */
public class LeetCode_58_693 {
    class Solution {
        public int lengthOfLastWord(String s) {
            char[] chars = s.toCharArray();
            int res = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (res != 0 && chars[i] == ' ') {
                    break;
                } else if (chars[i] != ' ') {
                    res++;
                }
            }
            return res;
        }
    }

    @Test
    public void test() {
        System.out.println(new Solution().lengthOfLastWord(" "));
        System.out.println(new Solution().lengthOfLastWord("a "));
        System.out.println(new Solution().lengthOfLastWord("  a "));
        System.out.println(new Solution().lengthOfLastWord(" Hello   "));
        System.out.println(new Solution().lengthOfLastWord("Hellollll Hello   "));
    }
}
