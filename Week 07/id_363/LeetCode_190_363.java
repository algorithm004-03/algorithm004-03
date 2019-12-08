package com.test.leetcode.week07;

import org.junit.Test;


public class SolutionReverseBit190 {


    @Test
    public void test1() {
        int n = Integer.parseUnsignedInt("43261596");
        System.out.println(reverseBits(n));
    }



    /**
     * n 是无符号整数，表示n的最高为不是符号
     * 从0循环到31  0 和 第31位交换
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int res = 0;
        if (n == 0) {
            return res;
        }
        for (int i = 0; i < 32; i ++) {
            // 获取第i位  获取第31-i位  交换复制给n
            res <<= 1;
            res += n & 1;
            n >>>= 1;
        }
        return res;

    }


}
