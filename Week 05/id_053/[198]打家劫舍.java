//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 
//
// 示例 1: 
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2: 
//
// 输入: [2,7,9,3,1]
//输出: 12
//解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
// Related Topics 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        //动态规划三部曲
        //1、找重复子问题(分治)
        //2、定义状态数组
        //3、dp方程
        //max_stolen[i] 表示从0偷盗i-1家的最大金额数，递推方程 f(i) = f(i-1)+nums[i-1];此时的最大问题是
        //你没法确定f(i-1)是否包含了nums[i-2]这家，如果包含，则后面不能加nums[i-1],如不包含则要加入
        //此时考虑升维，多出一维来记录这家是否要偷
        //max_stolen[i][0,1]表示从0偷盗第i家的最大金额数，0表示不偷，1表示偷
        //1、假设第i家被偷；f(i) = f(i-2)+nums[i-1]
        //2、假设第i家不偷:f(i) = max(max_stolen[i-1][0],max_stolen[i-1][1])
        //第一版(时间复杂度O(n),空间复杂度O(2n))
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        /*int[][] max_stolen = new int[nums.length][2];
        max_stolen[0][0] = 0;
        max_stolen[0][1] = nums[0];
        for(int i = 1;i < nums.length;i++) {
            max_stolen[i][1] = max_stolen[i-1][0]+nums[i];
            max_stolen[i][0] = Math.max(max_stolen[i-1][0],max_stolen[i-1][1]);
        }
        return Math.max(max_stolen[nums.length-1][0],max_stolen[nums.length-1][1]);*/
        //第二版空间复杂度改成O(n) 用max_stolen[i]来记录从0到i家偷到的最大金额，且第i家必偷
        //DP方程 max_stolen[i] = max(nums[i] + max_stolen[i-2],max_stolen[i-1]);
        int[] max_stolen = new int[nums.length];
        max_stolen[0] = nums[0];
        max_stolen[1] = Math.max(nums[0],nums[1]);
        int max = Math.max(max_stolen[0],max_stolen[1]);
        for (int i = 2;i < nums.length;i++){
            max_stolen[i] = Math.max(nums[i] + max_stolen[i-2],max_stolen[i-1]);
            max = Math.max(max,max_stolen[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
