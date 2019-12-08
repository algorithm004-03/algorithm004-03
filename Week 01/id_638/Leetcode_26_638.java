package test1;

/**
 * Created by Administrator on 2019/10/20.
 */
public class Leetcode_26_638 {

    /**
     * 删除排序数组中的重复项
     * 地址：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i=0;i < nums.length-1;i++){
            if (nums[i] == nums[i+1]){
                j++;
            }else{
                nums[i+1-j] = nums[i+1];
            }
        }
        return (nums.length-j);
    }
}
