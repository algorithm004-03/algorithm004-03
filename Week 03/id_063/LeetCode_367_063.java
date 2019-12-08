
/*
朴素的二分查找
 */


class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;
        long mid;

        while (left <= right) {
            mid = (left + right) >> 1;

            if (mid * mid == num) {
                return true;
            }

            if (mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPerfectSquare(104976));
    }
}