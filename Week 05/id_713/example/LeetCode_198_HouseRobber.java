package id_713.example;

/**
 * 198. 打家劫舍
 */
public class LeetCode_198_HouseRobber {

    /*
    你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

    给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

    示例 1:

    输入: [1,2,3,1]
    输出: 4
    解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
         偷窃到的最高金额 = 1 + 3 = 4 。

    示例 2:

    输入: [2,7,9,3,1]
    输出: 12
    解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
         偷窃到的最高金额 = 2 + 9 + 1 = 12 。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/house-robber
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



    思路:
    1. 二维DP

    一维记录数组中索引
    二维记录状态, 抢或不抢


    dp[i][0] = Math.max(dp[i - 1][0] + dp[i - 1][1]); // 不抢
    dp[i][1] = dp[i - 1][0] + nums[i]; // 抢

     */

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[][] dp = new int[nums.length][2];

        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]); // 不打劫只能找最大的
            dp[i][1] = dp[i - 1][0] + nums[i]; // 打劫才能累加, 而且是累加前一个没有打劫的(隔一个)
        }

        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][0]);

    }

    /*
    二维降低为一维
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[Integer.MAX_VALUE];
        dp[0] = nums[0];
        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    /*
    一维降低成 2个变量, 前值, 前前值
     */
    public int rob3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

//        int[] dp = new int[Integer.MAX_VALUE];
//        dp[0] = nums[0];
//        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];

        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        int res = second;

        for (int i = 2; i < nums.length; i++) {
            res = Math.max(second, first + nums[i]);

        }
        return res;
    }

}