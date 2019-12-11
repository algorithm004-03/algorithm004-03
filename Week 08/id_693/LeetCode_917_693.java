package id_693;

/**
 * @Author 李雷（KyLin）
 * @Desc 917. 仅仅反转字母	https://leetcode-cn.com/problems/reverse-only-letters/
 * @Date 2019/12/05
 */
public class LeetCode_917_693 {
    /**
     * 直接转会为char数组，然后双指针跑路
     */
    class Solution {
        public String reverseOnlyLetters(String s) {
            char[] chars = s.toCharArray();
            int i = 0;
            int j = chars.length - 1;
            while (i < j) {
                while (i < j && !Character.isLowerCase(chars[i]) && !Character.isUpperCase(chars[i])) i++;
                while (i < j && !Character.isLowerCase(chars[j]) && !Character.isUpperCase(chars[j])) j--;
                if (i < j) {
                    chars[i] ^= chars[j];
                    chars[j] ^= chars[i];
                    chars[i++] ^= chars[j--];
                }
            }
            return String.valueOf(chars);
        }
    }


    public static void main(String[] args) {
        new LeetCode_917_693().new Solution().reverseOnlyLetters("a-bC-dEf-ghIj");
    }
}
