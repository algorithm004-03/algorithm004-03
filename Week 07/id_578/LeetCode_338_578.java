package com.hand.week7;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/12/1
 */
public class LeetCode_338_578 {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i = 0; i <= num; ++i) {
            if ((i & 1) == 1) result[i] = result[i - 1] + 1;
            else result[i] = result[i >> 1];
        }
        return result;
    }
}
