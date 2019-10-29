/**
 * @author eazonshaw
 * @date 2019/10/20  12:00
 *
 * 题目：26. 删除排序数组中的重复项
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 描述：
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 */
public class LeetCode_26_243 {

    /**
     * 1.暴力法 遍历
     * 当前元素与前面的元素相等，则删除（全部元素左移）
     */
    public int removeDuplicates1(int[] nums) {
        int count = nums.length;
        for(int i=1;i<count;){
            if(nums[i]==nums[i-1]){
                //删除
                del(nums,i);
                --count;
            }else{
                ++i;
            }
        }
        return count;
    }
    private void del(int[] nums,int i){
        for(int k = i;k<nums.length-1;++k){
            nums[k] = nums[k+1];
        }
    }

    /**
     * 2.双指针解法  快指针遍历，慢指针记录非重复值
     */
    public int removeDuplicates2(int[] nums) {
        int slow = 0;
        for(int fast = 1;fast<nums.length;++fast){
            //不相等则移动慢指针
            if(nums[fast] != nums[slow]){
                nums[++slow] = nums[fast];
            }
        }
        return slow+1;
    }

}
