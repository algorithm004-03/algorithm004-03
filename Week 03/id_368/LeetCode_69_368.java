public class LeetCode_69_368 {

    /*实现 int sqrt(int x) 函数。
    计算并返回 x 的平方根，其中 x 是非负整数。
    由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
    链接：https://leetcode-cn.com/problems/sqrtx*/

    public static void main(String[] args) {

    }

    public int mySqrt(int x) {
        if (x == 0) {
            return x;
        }
        long left = 1;
        long right = x;
        while (left < right) {
            long mid = left + (right - left + 1) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int)left;
    }

    public int mySqrt02(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int)r;
    }
}
