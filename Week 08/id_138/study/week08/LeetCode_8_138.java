package study.week08;

/**
 * 字符串转为数字
 * @author Lukas
 * @since 2019/12/8 20:24
 **/
public class LeetCode_8_138 {
    public int myAtoi(String str) {
        int index = 0;
        int sign = 1;
        int total = 0;

        if (str.length() == 0 || str.equals(" ") || str.trim().length()==0)
            return 0;
        while (str.charAt(index) == ' ' && index < str.length()) {
            index++;
        }
        if (str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index)=='+'?1:-1;
            index++;
        }
        while (index < str.length()) {
            int digit = str.charAt(index)-'0';
            if (digit<0 || digit>9)
                break;
            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total
                    && Integer.MAX_VALUE % 10 < digit) {
                return sign == 1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            total = 10*total+digit;
            index++;
        }
        return total*sign;
    }

}
