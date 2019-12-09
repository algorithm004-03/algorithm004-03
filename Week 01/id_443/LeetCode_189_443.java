//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组

package com.modds.alltest.leetcode.editor.cn;

public class LeetCode_189_443_RotateArray {
    public static void main(String[] args) {
        Solution solution = new LeetCode_189_443_RotateArray().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {
            if (nums.length <= 1) return;
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;

                start++;
                end--;
            }
        }


        public void rotate2(int[] nums, int k) {
            int[] a = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                a[(i + k) % nums.length] = nums[i];
            }
            System.arraycopy(a, 0, nums, 0, nums.length);
        }

        public void rotate1(int[] nums, int k) {

            if (nums.length <= 1) return;
            for (int j = 0; j < k; j++) {
                int tmp = nums[0];
                for (int i = 0; i < nums.length; i++) {
                    int ni = (i + 1) % nums.length;
                    int tmp2 = nums[ni];
                    nums[ni] = tmp;
                    tmp = tmp2;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}