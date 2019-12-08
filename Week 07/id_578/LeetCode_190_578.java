package com.hand.week7;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/12/1
 */
public class LeetCode_190_578 {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 1; i <= 32; ++i) {
            int tmp = n >> i;
            tmp = tmp & 1;
            tmp = tmp << (31 - i);
            result |= tmp;
        }
        return result;
    }
}
