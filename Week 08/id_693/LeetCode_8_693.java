package id_693;

/**
 * @Author 李雷（KyLin）
 * @Desc 8. 字符串转换整数 (atoi)	https://leetcode-cn.com/problems/string-to-integer-atoi/
 * @Date 2019/12/04
 */
public class LeetCode_8_693 {
    class Solution {
        public int myAtoi(String str) {
            int len = str.length();
            if (len == 0) return 0;
            int sign = 1;
            int index = 0;
            int total = 0;
            //寻找第一个空格
            while (index < len && str.charAt(index) == ' ') {
                index++;
            }
            //确定正负数
            if (index < len && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
                sign = str.charAt(index) == '+' ? 1 : -1;
                index++;
            }
            //转换数字，并且防止溢出
            while (index < len) {
                int digit = str.charAt(index) - '0';
                if (digit < 0 || digit > 9) {
                    break;
                }
                //最大值/10 小于total那么下次* 10 就会溢出，或者 等于，那么就看digit 是否大于最大值%10 的结果 ，
                // 所以这里专门处理 会溢出的数
                if (Integer.MAX_VALUE / 10 < total ||
                        (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                total = total * 10 + digit;
                index++;
            }
            return sign * total;
        }
    }
}

