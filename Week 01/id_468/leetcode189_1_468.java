/**
 * @program: leetcode
 * @description: Rotate Array
 * @author: 王瑞全
 * @create: 2019-10-2019:36
 **/


public class leetcode189_1_468 {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        reserve(nums, 0, nums.length - 1);
        reserve(nums, 0, k - 1);
        reserve(nums, k, nums.length - 1);    }

    private void reserve(int[] nums, int begin, int end) {
        if (begin < end) {
            int node = nums[begin];
            nums[begin++]=nums[end];
            nums[end--]=node;
        }
    }
}
