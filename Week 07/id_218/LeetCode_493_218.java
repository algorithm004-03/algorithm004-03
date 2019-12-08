package leetcode.week7;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/reverse-pairs/
 *
 * @author eason.feng at 2019/12/1/0001 18:13
 **/
public class LeetCode_493_218 {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int s, int e) {
        if (s >= e) {
            return 0;
        }
        int mid = (s + e) >>> 1;
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid + 1, e);
        for (int i = s, j = mid + 1; i <= mid; i++) {
            while (j <= e && nums[i] / 2.0 > nums[j]) {
                j++;
            }
            cnt += j - (mid + 1);
        }
        Arrays.sort(nums, s, e + 1);
        return cnt;
    }
}
