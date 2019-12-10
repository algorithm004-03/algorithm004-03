package id_693;

/**
 * @Author 李雷（KyLin）
 * @Desc 344. 反转字符串	https://leetcode-cn.com/problems/reverse-string/
 * @Date 2019/12/04
 */
public class LeetCode_344_693 {
    /**
     * 没啥说的。直接替换就好了。
     */
    class Solution {
        public void reverseString(char[] s) {
            int i = 0;
            int j = s.length - 1;
            while (i < j) {
                s[i] ^= s[j];
                s[j] ^= s[i];
                s[i++] ^= s[j--];
            }
        }
    }
}
