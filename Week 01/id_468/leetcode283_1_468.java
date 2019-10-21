/**
 * @program: leetcode
 * @description: MoveZero
 * @author: 王瑞全
 * @create: 2019-10-1923:41
 **/


public class leetcode283_1_468 {
    public void moveZeroes(int[] nums) {
        if (nums.length==0){
            return ;
        }
         int end=0;
         for(int i:nums){
            if(i!=0){
               nums[end++]=i;
            }
         }
         while(end<nums.length){
             nums[end++]=0;
         }

    }

}
