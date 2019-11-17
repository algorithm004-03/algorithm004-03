package com.luxuedong.BinarySearchPractice;

/**
 * describe:
 * creator: luxuedong
 * date: 2019/10/31 17:01
 */
public class LeetCode_69_mySqrt {

    public int mySqrt1(int x) {
        if (x <= 1) return x;
        long min = 1;
        long max = x;
        while (min < max) {
            long mid = min + (max - min + 1) / 2;//避免 max+min 溢出
            if (mid * mid > x)
                max = mid - 1;
            else
                min = mid;
        }
        return (int) min;
    }

    /**
     * 二分查找
     *
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        long min = 0;
        long max = x / 2 + 1;
        while (min < max) {
            long mid = (min + max + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                max = mid - 1;
            } else {
                min = mid;
            }
        }
        return (int) min;
    }

    /**
     * 牛顿迭代法
     *
     * @param x
     * @return
     */
    public int mySqrt3(int x) {
        if (x <= 1) return x;
        long r = x;
        while (r * r > x)
            r = (r + x / r) >> 1;
        return (int) r;
    }

    public static void main(String[] args) {
        LeetCode_69_mySqrt mySqrt = new LeetCode_69_mySqrt();
        int i = mySqrt.mySqrt1(2147395600);
        System.out.println(i);
    }
}
