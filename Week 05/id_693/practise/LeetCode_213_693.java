package id_693.practise;

/**
 * @Desc 213. 打家劫舍 II	https://leetcode-cn.com/problems/house-robber-ii/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/14
 */
public class LeetCode_213_693 {
    //dp 和之前的 一样：区别就是 开始偷，那么最后不偷，只需要控制好范围就好了
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return  Math.max(helper(nums,0,nums.length - 2),helper(nums,1,nums.length -1));
    }
    private int helper(int [] nums,int lo ,int len) {
        int prevMax = 0;
        int currMax = 0;
        for (int i = lo; i <= len; i++) {
            int temp = currMax;
            currMax = Math.max(currMax,prevMax + nums[i]);
            prevMax = temp;
        }
        return currMax;
    }
}
