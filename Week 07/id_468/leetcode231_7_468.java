package week7;

/**
 * @program: leetcode
 * @description:
 * @author: 王瑞全
 * @create: 2019-12-0121:31
 **/


public class leetcode231_7_468 {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        }
        while((n & 1) != 1) {
            n = n >> 1;
        }
        return n == 1;
    }
}
