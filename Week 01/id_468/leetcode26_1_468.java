import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode
 * @description: Remove Duplicates from Sorted Array
 * @author: 王瑞全
 * @create: 2019-10-2019:54
 **/


public class leetcode26_1_468 {
    public int removeDuplicates1(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        return set.size();
    }
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int index=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[index]){
                nums[++index]=nums[j];
            }
        }
        return index+1;
    }
}
