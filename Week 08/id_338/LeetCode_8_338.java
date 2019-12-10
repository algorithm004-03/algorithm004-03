package id_338;

/**
 * @author Leesen
 * @date 2019/12/8 23:10
 */
public class LeetCode_8_338 {
    public int myAtoi(String str) {
        int len = str.length();
        int num = 0;
        for (int i=len-1; i>=0; i--) {
            num += (str.charAt(i) - '0') * Math.pow(10, len-i-1);  //ascii码相减后0就是0
            str = str.substring(0, i);
        }
        return num;
    }
}
