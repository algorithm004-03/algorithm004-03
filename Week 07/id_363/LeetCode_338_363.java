package com.test.leetcode.week07;

import org.junit.Test;

import java.util.Arrays;


public class SolutionCountBit338 {


    @Test
    public void test1() {
        System.out.println(Arrays.toString(countBits(5)));
        System.out.println(Arrays.toString(countBits2(5)));
        System.out.println(Arrays.toString(countBits3(5)));
    }


    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i ++) {
            if ((i & 1) == 1) {
                res[i] = res[i - 1] + 1;// 奇数
            } else {
                res[i] = res[i >> 1];
            }
        }
        return res;
    }

    // 清除最后一个1 然后加1
    public int[] countBits2(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i ++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

    // num/2 + i & 1
    public int[] countBits3(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i ++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }



}
