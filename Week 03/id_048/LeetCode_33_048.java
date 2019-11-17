package com.leetcode.week03;

/**
 * Created by tim on 2019/11/2.
 *假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

 你可以假设数组中不存在重复的元素。

 你的算法时间复杂度必须是 O(log n) 级别。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_33_048 {
    public static void main(String[] args) {
        LeetCode_33_048 leetCode_33_048 = new LeetCode_33_048();
        int[] nums = {6,7,8,0,1,2,3,4,5};
        int target = 6;
        int index = leetCode_33_048.search(nums,target);
        System.out.println("index: " + index);
    }

    int [] nums;
    int target;

    /**
     * 寻找最小值索引下标
     * @param left
     * @param right
     * @return
     */
    public int find_rotate_index(int left, int right) {
        if (nums[left] < nums[right]) {
            return 0;
        }
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1]) //如果中间值大于右边相邻的值，就返回右边相邻的下标,这个下标就是最小值的下标。
                return pivot + 1;
            else {
                if (nums[pivot] < nums[left]) {  // [5,6,0,1,2,3,4]  如果中间值小于左边界
                    right = pivot - 1;// 右边界等于中间值左边相邻的值，就变成 [5,6,0]，排查掉右边所有的。
                } else {                         // 否则
                    left = pivot + 1;           // 左边界等于中间值右边相邻的值。
                }
            }
        }
        return 0;
    }

    /**
     * Binary search,单调二分查找
     * @param left
     * @param right
     * @return
     */
    public int search(int left, int right) {
        while (left <= right) {
            int pivot = (left + right) / 2;    //计算中间下标值
            if (nums[pivot] == target) {       // 条件，如果满足条件就返回目标下标值
                return pivot;
            } else {
                if (target < nums[pivot]) {     // 如果目标值在中间值的左边，就把右边界移到中间值下标的左边相邻位置。
                    right = pivot - 1;
                } else {                         //否则，就把左边界移到中间值下标的右边相邻位置。
                    left = pivot + 1;
                }
            }
        }
        return -1;
    }


    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        int n = nums.length;

        if (n == 0)
            return -1;
        if (n == 1)
            return this.nums[0] == target ? 0 : -1;

        int rotate_index = find_rotate_index(0, n - 1);

        // if target is the smallest element
        if (nums[rotate_index] == target) {
            return rotate_index;
        }
        // if array is not rotated, search in the entire array
        if (rotate_index == 0) {  //如果最小值的下标是0,就用search进行二分查找
            return search(0, n - 1);
        }
        if (target < nums[0]) {     // 如果进行了旋转，则左边界为最小值的下标。用search进行查找。
            // search in the right side
            return search(rotate_index, n - 1);
        }
        // search in the left side  // 否则，则右边界为最小值的下标。用search进行查找。
        return search(0, rotate_index);
    }
}
