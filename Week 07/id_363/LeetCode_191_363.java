package com.test.leetcode.week07;

import org.junit.Test;



public class SolutionNumOfBit191 {

    @Test
    public void test1() {
        System.out.println(hammingWeight(8));
        System.out.println(hammingWeight(5));

        System.out.println(hammingWeight2(8));
        System.out.println(hammingWeight2(5));
    }

    /**
     * 输入的是一个无符号整数，返回其二进制表达式中1的个数
     * 1.for循环 ： 1.判断最后一位是否是1  然后向右移动一位
     *
     * 2.位运算 x = x & (x - 1) 清零最后一位的1
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            int b = n & 1;
            if(b == 1) {
                count ++;
            }
            n = n >>> 1;
        }
        return count;
    }


    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1); // 清零最后一位1
            count ++;
        }
        return count;
    }


}
