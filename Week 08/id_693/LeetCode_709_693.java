package id_693;

import org.junit.jupiter.api.Test;

/**
 * @Author 李雷（KyLin）
 * @Desc 709. 转换成小写字母	https://leetcode-cn.com/problems/to-lower-case/
 * @Date 2019/12/04
 */
public class LeetCode_709_693 {
    /**
     * 直接判断是否是大写字符，是就直接加32
     */
    class Solution {
        public String toLowerCase(String str) {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= 65 && chars[i] <= 90) {
                    chars[i] += 32;
                }
            }
            return String.valueOf(chars);
        }
    }

    @Test
    public void test() {
        System.out.println(Integer.valueOf('A'));
        System.out.println(Integer.valueOf('Z'));
        System.out.println(Integer.valueOf('a'));
        System.out.println(Integer.valueOf('z'));
    }
}
