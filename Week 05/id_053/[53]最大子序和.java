//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {

        //MaxTotal(n)表示前n个数的最大子序列和，假设 MaxTotal(n-1)为负数，则MaxTotal(n) 就是它的第n个数
        //反过来，加入MaxTotal(n-1)大于零，则MaxTotal(n) = MaxTotal(n - 1) +n;
        //递推公式 MaxTotal(n) = max(MaxTotal(n-1),MaxTotal(n - 1) +n);
        if(nums == null || nums.length == 0) throw new RuntimeException("参数错误");
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] =nums[0];//这一步很重要，否则数组中都是负数时不可能得到准确答案，因为dp[0]会默认初始化为零
        int max = dp[0];
        //优化后
        for(int i = 1;i <nums.length;i++) {
            dp[i] = Math.max(dp[i-1],0) + nums[i];
            if (dp[i] > max) max = dp[i];
        }
        //循环可以放在一起，优化前
        /*int max = Integer.MIN_VALUE;
        for (int i = 0;i < dp.length;i++) {
            if (dp[i] > max) max = dp[i];
        }*/
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
