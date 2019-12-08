package com.ljg.leetcode.week07.a02;

import java.util.ArrayList;
import java.util.List;

/**
 * PowerOfTwo
 */
public class PowerOfTwo {

    public static void main(String[] args) {
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(16);
        list.add(218);
        list.add(-2147483648);
        list.add(-16);
        for (int n : list) {
            boolean bln = powerOfTwo.isPowerOfTwo(n);
            System.out.println("n=" + n + ", bln=" + bln);
        }

    }

    public boolean isPowerOfTwo(int n) {
        if (n > 0) {
            n &= n - 1;
            return n == 0;
        } else {
            return false;
        }
    }

    public boolean isPowerOfTwo2(int n) {
        if (n >= 0) {
            int num = hammingWeight(n);
            return num == 1;
        } else {
            return false;
        }

    }

    private int hammingWeight(int n) {
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