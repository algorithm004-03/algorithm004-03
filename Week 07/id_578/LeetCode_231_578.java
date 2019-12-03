package com.hand.week7;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/12/1
 */
public class LeetCode_231_578 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 & ((n & (n - 1)) == 0);
    }
}
