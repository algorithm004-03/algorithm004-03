package com.ljg.leetcode.week07.a03;

/**
 * ReverseBit
 */
public class ReverseBits {

    public static void main(String[] args) {
        int n = -3;

        ReverseBits reverseBits = new ReverseBits();
        int n2 = reverseBits.reverseBits(n);

        System.out.println("n2=" + n2);
    }

    public int reverseBits(int n) {
        int n2 = 0;
        int temp;
        for (int i = 0; i < 32; i++) {
            temp = (n >> i) & 1;
            if (temp == 1) {
                n2 ^= (temp << (31-i));
            }
        }
        return n2;
    }
}