package week4;

import sun.nio.cs.ext.MacThai;

/**
 * @program: leetcode
 * @description: 打家劫舍
 * @author: 王瑞全
 * @create: 2019-11-1723:32
 **/


public class leetcode198_5_468 {

    /**
     * dp方程 MAX(dp[n-1],dp[n-2]+num)
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
         if(nums.length==0){
             return 0;
         }
        if(nums.length==1){
            return nums[0];
        }
         int[] dp=new int[nums.length];
         dp[0]=nums[0];
         dp[1]=Math.max(dp[0],nums[1]);
         for(int i=2;i<nums.length;i++){
             dp[i]= Math.max(dp[i-2]+nums[i],dp[i-1]);
         }
         return dp[nums.length-1];
    }
    /**
     * dp方程 MAX(dp[n-1],dp[n-2]+num)
     * @param
     * @return
     */
    public int rob1(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }

}
