package com.hand.week7;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/12/1
 */
public class LeetCode_191_578 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
