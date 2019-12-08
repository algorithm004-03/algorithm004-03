/*
跟逆序对的思路一样，用归并排序的思想解决
 */

import java.util.Arrays;

class Solution {
    private int mergeSort(int[] nums, int start, int end) {
        if (start == end) {
            return 0;
        }

        int mid = start + (end - start) / 2;
        int lcnt = mergeSort(nums, start, mid);
        int rcnt = mergeSort(nums, mid+1, end);

        int sum = lcnt + rcnt;

        // 累加本次归并过程中的反转对数量, dp解决, i, j都只可能往右边移动
        int i, j = mid + 1, cnt = 0;
        for (i = start; i <= mid; i++) {
            while (j <= end && nums[j] < ((nums[i]>>1) + (nums[i]&1)) ) {
                cnt++; j++;
            }

            sum += cnt;
        }

        // 偷懒直接用库函数排序，代码简洁，浪费一点计算量
        Arrays.sort(nums, start, end+1);
        return sum;
    }

    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        System.out.println( new Solution().reversePairs(new int[] {2,4,3,5,1}) );
    }
}