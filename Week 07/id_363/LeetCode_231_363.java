package com.test.leetcode.week07;

import org.junit.Test;


public class SolutionPowerOfTwo231 {


    @Test
    public void test1() {
        System.out.println(isPowerOfTwo(8));
    }

    /**
     * 如果二进制中只有一位，那么是2的次幂
     * n > 0 && n & (n - 1) == 0;
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }





}
