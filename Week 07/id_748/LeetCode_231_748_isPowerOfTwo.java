package com.code.week5;


/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */


public class LeetCode_191_748_hammingWeight {


    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
