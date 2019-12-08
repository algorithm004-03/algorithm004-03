/**
 * @author eazonshaw
 * @date 2019/11/15  16:52
 *
 * 题目：53. 最大子序和
 * 描述：给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class LeetCode_53_243 {

    //暴力法，冒泡双循环，找到最大值
    public int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;i++){
            int currSum = 0;
            for(int j = i;j < nums.length;j++){
                currSum = currSum + nums[j];
                max = Math.max(max,currSum);
            }
        }
        return max;
    }

    //动态规划
    public int maxSubArray2(int[] nums) {
        int currSum = nums[0];
        int max = currSum;
        for(int i = 1;i < nums.length;i++){
            currSum = Math.max(currSum + nums[i],nums[i]);
            max = Math.max(currSum,max);
        }
        return max;
    }

}
