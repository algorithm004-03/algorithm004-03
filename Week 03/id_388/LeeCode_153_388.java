package com.company.leetcode.editor.cn;
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
// 请找出其中最小的元素。
//
// 你可以假设数组中不存在重复元素。
//
// 示例 1:
//
// 输入: [3,4,5,1,2]
//输出: 1
//
// 示例 2:
//
// 输入: [4,5,6,7,0,1,2]
//输出: 0
// Related Topics 数组 二分查找



//leetcode submit region begin(Prohibit modification and deletion)
class Solution_153 {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        //2个
        if (nums.length == 2) {
            return Math.min(nums[0],nums[1]);
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //是否是临界点
            boolean isPoint = this.checkPoint(mid,nums);
            if (isPoint) {
                return nums[mid];
            }
            //0到mid有序
            if (nums[0] <= nums[mid] && nums[right] < nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nums[left];

    }

    private boolean checkPoint(int midIndex,int[] num) {

        int leftIndex = -1;
        int rightIndex = -1;
        //两边判断
        int len = num.length;

        leftIndex = midIndex - 1;
        if (leftIndex < 0) {
            leftIndex = len - 1;
        }
        rightIndex = midIndex + 1;
        if (rightIndex > len - 1) {
            rightIndex = 0;
        }
        int target = num[midIndex];
        if (target < num[leftIndex] && target < num[rightIndex]) {
            return true;
        }
        return false;
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int[] nums = new int[]{3,1};
//        int min = s.findMin(nums);
//        System.out.println(min);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
