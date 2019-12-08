package week4;

/**
 * @program: leetcode
 * @description: 打家劫舍 II
 * @author: 王瑞全
 * @create: 2019-11-1723:56
 **/


public class leetcode213_5_468 {
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }

        return Math.max(find(nums,0,nums.length-1),find(nums,1,nums.length));
    }
    public int find(int[] nums,int begin,int end){
        int prevMax = 0;
        int currMax = 0;
        for(int i=begin;i<end;i++) {
            int temp = currMax;
            currMax = Math.max(prevMax + nums[i], currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
