package leetcode.week8;

/**
 * @author eason.feng at 2019/12/7/0007 13:33
 **/
public class LeetCode_8_218 {

    public static void main(String[] args) {
        LeetCode_8_218 leetCode_8_218 = new LeetCode_8_218();
        System.out.println(leetCode_8_218.myAtoi("42"));
    }

    public int myAtoi(String str) {
        int res = 0;
        if (str == null || "".equals(str.trim())) {
            return res;
        }
        str = str.trim();
        int sign = 1;
        int index = 0;
        if ('+' == str.charAt(index)) {
            sign = 1;
            index++;
        } else if ('-' == str.charAt(index)) {
            sign = -1;
            index++;
        }
        while (index < str.length()) {
            int digest = str.charAt(index) - '0';
            if (digest > 9 || digest < 0) {
                break;
            }
            if (Integer.MAX_VALUE / 10 < res || (Integer.MAX_VALUE / 10 == res && Integer.MAX_VALUE % 10 < digest)) {
                return (sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE);
            }
            res = 10 * res + digest;
            index++;
        }
        return res * sign;
    }

}
