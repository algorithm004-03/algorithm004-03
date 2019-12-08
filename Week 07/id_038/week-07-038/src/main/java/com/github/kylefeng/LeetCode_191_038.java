package com.github.kylefeng;

/**
 * @author kylefeng
 * @time 2019/12/1 15:15
 */
public class LeetCode_191_038 {

    public static int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            result++;
            n -= (n & -n);
        }
        return result;
    }

}
