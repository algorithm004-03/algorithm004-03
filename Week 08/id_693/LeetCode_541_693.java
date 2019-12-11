package id_693;

/**
 * @Author 李雷（KyLin）
 * @Desc 541. 反转字符串 II	https://leetcode-cn.com/problems/reverse-string-ii/
 * @Date 2019/12/05
 */
public class LeetCode_541_693 {
    /**
     * 直接利用reverse，然后结合规则的每2 * k 个字符前面的k个字符旋转即可（注意k需要- 1,索引问题）
     */
    class Solution {
        public String reverseStr(String s,int k) {
            char[] str = s.toCharArray();
            int len = str.length;
            for (int i = 0; i < len; i += 2 * k) {
                int j = i + k - 1 < len ? i + k - 1 : len - 1;
                //int j = Math.min(i + k - 1, len - 1);
                reverse(str,i,j);
            }
            return String.valueOf(str);
        }

        private void reverse(char[] str,int i,int j) {
            while (i < j) {
                str[i] ^= str[j];
                str[j] ^= str[i];
                str[i++] ^= str[j--];
            }
        }
    }
}
