package com.ljg.leetcode.week07.a01;

/**
 * NumberOfOneBits
 */
public class NumberOfOneBits {

    public static void main(String[] args) {
        NumberOfOneBits numberOfOneBits = new NumberOfOneBits();
        int n = 3;
        int num = numberOfOneBits.hammingWeight(n);
        System.out.println("num:" + num);
    }

    /**
     * 只支持正整数
     * 
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int num = 0;
        while (n > 0) {
            num++;
            n &= (n - 1);
        }
        return num;
    }

    /**
     * 支持正数和负数
     */
    public int hammingWeight2(int n) {
        int num = 0;
        int temp;
        for (int i = 0; i < 32; i++) {
            temp = n >> i;
            if ((temp & 1) == 1) {
                num++;
            }
        }
        return num;
    }
}