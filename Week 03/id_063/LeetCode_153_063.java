/*
思路
广义的二分查找

其实就是查找发生了降序的那个特殊的点在哪
 */

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;

            if (right - left < 3) {
                // 缩小到一定范围就进行顺序搜索
                for (int i = left; i <= right; i++) {
                    if (i > 0 && nums[i] < nums[i-1]) {
                        return nums[i];
                    }
                }

                // 如果旋转点找不到，说明整个序列是单调递增的，直接返回第一个元素
                return nums[0];
            }

            // 判定是不是特殊点
            if (mid > 0 && nums[mid] < nums[mid-1]) {
                return nums[mid];
            }

            if (nums[left] <= nums[mid]) {
                // 左边是严格升序的，旋转点不可能在左边
                left = mid;
            } else {
                // 右半部分升序, 旋转点不可能在右边
                right = mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int ret = new Solution().findMin(new int[] {3,4,5,1,2});
        System.out.println(ret);
    }
}