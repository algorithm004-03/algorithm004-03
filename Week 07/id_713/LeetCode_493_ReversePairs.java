package id_713;

import java.util.Arrays;

/**
 * 493. 翻转对
 */
public class LeetCode_493_ReversePairs {
    /*
    给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。

    你需要返回给定数组中的重要翻转对的数量。

    示例 1:

    输入: [1,3,2,3,1]
    输出: 2

    示例 2:

    输入: [2,4,3,5,1]
    输出: 3

    注意:

        给定数组的长度不会超过50000。
        输入数组中的所有数字都在32位整数的表示范围内。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/reverse-pairs
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) return 0;

        int mid = start + (end - start) >> 1;

        int cnt = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);

        for (int i = 0, j = mid + 1; i <= mid; i++) {
            while (j <= end && nums[i] / 2.0 > nums[j]) j++;
            cnt += j - (mid + 1);
        }

        Arrays.sort(nums, start, end + 1);
        return cnt;
    }
}
