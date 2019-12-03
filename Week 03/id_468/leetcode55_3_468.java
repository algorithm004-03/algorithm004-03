package week3;

/**
 * @program: leetcode
 * @description: 跳跃游戏
 * @author: 王瑞全
 * @create: 2019-11-0322:22
 **/


public class leetcode55_3_468 {
    public boolean canJump(int[] nums) {
      int max=0;
      for(int i=0;i<nums.length;i++){
          if(i>max) return false;
          max=Math.max(nums[i]+i,max);
      }
      return true;
    }
}
