package week7;

/**
 * @program: leetcode
 * @description:
 * @author: 王瑞全
 * @create: 2019-12-0122:11
 **/


public class leetcode190_7_468 {
    public int reverseBits(int n) {
        int num = 0;
        int mask = 1;
        for (int i = 0 ; i < 32; i++) {
            num |= (mask & n);
            n >>= 1;
            if (i < 31) {
                num <<= 1;
            }
        }

        return num;
    }
}
