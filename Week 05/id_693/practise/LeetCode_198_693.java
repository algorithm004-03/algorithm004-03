package id_693.practise;

/**
 * @Desc 198. 打家劫舍 	https://leetcode-cn.com/problems/house-robber/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/14
 */
public class LeetCode_198_693 {
    //dp：就是偷和不偷，那么定义一个一维数组存钱，再加1维确定偷和不偷
    /*
        1、分解子问题 a[i] : 0 .... i 能偷到 max value ; a[i -1]
        2、定义状态数组 a[i][0,1] :0 偷，1不偷
        3、DP方程
              a[i][0]  = Math.max(a[i - 1][0],a[i - 1][1])
              a[i][1]  = a[i - 1][1] + nums[i];
     */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = dp[i - 1][1] + nums[i];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);//如果不偷，那么可以直接取前一天的最大值，
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    //去二维变1维，因为偷和不偷是恒定。
    public int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
//        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);//反正最后的就是最大值了
        return dp[nums.length - 1];
    }

    //去1维
    public int rob3(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int num : nums) {
            int temp = currMax;
            currMax = Math.max(currMax, prevMax + num);
            prevMax = temp;
        }
        return currMax;
    }

    public static void main(String[] args) {
        new LeetCode_198_693().rob2(new int[]{2, 1, 1, 2});
        assert new LeetCode_198_693().rob2(new int[]{2, 1, 1, 2}) == 4;
    }
}
