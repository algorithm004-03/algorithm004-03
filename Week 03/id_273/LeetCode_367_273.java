//367. 有效的完全平方数

//解法1：二分法
//思路：
//时间复杂度：O(logN)
//空间复杂度：O(1)
class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;

        while (left <= right) {
            long mid = (left + right)/2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}