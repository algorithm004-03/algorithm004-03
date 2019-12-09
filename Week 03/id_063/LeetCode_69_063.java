/*
先用二分法缩小数值范围，然后再进行小范围搜索
 */

class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 1;
        int right = x;
        int mid = 1;

        while (left < right) {
            mid = (left + right) >> 1;

            if (x / mid == mid) {
                return mid;
            }


            if (x / mid < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (x / mid > mid) {
            while (true) {
                if ((x / mid >= mid) && (x / (mid+1) < (mid+1))) {
                    break;
                }

                mid++;
            }
        } else {
            while (true) {
                if ((x / mid >= mid) && (x / (mid+1) < (mid+1))) {
                    break;
                }

                mid--;
            }
        }

        return mid;
    }
}