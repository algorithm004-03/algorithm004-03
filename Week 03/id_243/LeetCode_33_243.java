/**
 * @author eazonshaw
 * @date 2019/11/3  22:52
 * 题目：33. 搜索旋转排序数组
 *
 * 描述：假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 例子：
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class LeetCode_33_243 {

    //思路：硬上二分查找的模板
    public int search(int[] nums, int target) {
        //左边界
        int left = 0;
        //右边界
        int right = nums.length-1;

        while (left<right){
            int mid = left + ((right - left) >> 1);
            //如果[0,mid]为有序，向右规约
            if(nums[0]<=nums[mid] && (target>nums[mid] || target<nums[0])){
                left = mid+1;
            }
            //如果[0,mid]为反转，向右规约
            else if(target>nums[mid] && target<nums[0]){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return left==right && nums[left] == target?left:-1;
    }

}
