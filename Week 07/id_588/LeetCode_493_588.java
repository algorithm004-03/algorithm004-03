import java.util.Arrays;

/**
 * 逆序对
 * https://leetcode-cn.com/problems/reverse-pairs/
 */
public class LeetCode_493_588 {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int s, int e) {
        if (s >= e) {
            return 0;
        }
        int mid = s + (e - s) / 2;
        int count = mergeSort(nums, s, mid) + mergeSort(nums, mid + 1, e);
        for (int i = s, j = mid + 1; i <= mid; i ++) {
            while (j <= e && ((long)nums[i] > (long)nums[j] * 2)) {
                j ++;
            }
            count += j - (mid + 1);
        }
        Arrays.sort(nums, s, e + 1);
        return count;
    }
}
