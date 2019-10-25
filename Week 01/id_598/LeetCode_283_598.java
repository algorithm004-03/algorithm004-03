/**
 * LeetCode 283题
 *  https://leetcode-cn.com/problems/move-zeroes/
 * @author northleaf
 * @create 2019年10月18日
 */
public class LeetCode_283_598 {


    /**
     * 复杂度O(n)
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        //记录非零的位置
        int j = 0 ;
        for(int i = 0;i<nums.length;i++){
            //如果元素为0 ，则直接赋值给非零指针所在的元素，同时索引+1
            if(nums[i]!= 0 ){
                nums[j]=nums[i];
                j++;
            }
        }
        //将非零指针之后的元素全部设置为0
        for(;j<nums.length;j++){
            nums[j] =0;
        }
    }

}
