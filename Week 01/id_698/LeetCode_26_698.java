/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * @author gning
 */

public class LeetCode_26_698 {

    /**
     * 暴力解法。自己想的
     */
    public int removeDulicates(int[] nums) {
        int len = nums.length;
        for (int i=0; i < len-1;) {            
                if (nums[i] == nums[i+1]) {                    
                    for(int k=i+1; k < len - 1; k++) {
                        nums[k] = nums[k+1];                        
                    }
                    len--;
                    i=0;
                } else {
                    i++;
                }
            
        }
        
        return len;
    }

    /**
     * 默写官方解法
     */
    public int removeDulicates2(int[] nums) {
        if (nums.length==0)
            return 0;
        
        int i=0;
        for(int j=1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }


}
