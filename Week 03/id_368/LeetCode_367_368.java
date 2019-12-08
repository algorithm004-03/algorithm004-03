public class LeetCode_367_368 {

    /*给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
    说明：不要使用任何内置的库函数，如  sqrt。
    链接：https://leetcode-cn.com/problems/valid-perfect-square*/

    public static void main(String[] args) {

    }

    public boolean isPerfectSquare(int num) {
        long left = 0;
        long right = num;
        while (left < right) {
            long mid = left + (right - left + 1) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return false;
    }
}
