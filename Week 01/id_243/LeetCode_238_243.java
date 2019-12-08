/**
 * @author eazonshaw
 * @date 2019/10/20  11:54
 *
 * [238-移动零](https://leetcode-cn.com/problems/move-zeroes/)
 * > 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * > 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * > 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数
 */
public class LeetCode_238_243 {
    /**
     * 冒泡解法
     */
    public void moveZeroes1(int[] nums) {
        int len = nums.length;
        for(int i=0;i<len;i++){
            //若为零，则往后找到最近的一个不为零的数字进行替换
            if(nums[i]==0){
                for(int j=i;j<len;j++){
                    if(nums[j]!=0){
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }

    /**
     * 双指针
     */
    public void moveZeroes2(int[] nums) {
        //非零指针
        int i = 0;
        //零指针
        int j = 0;
        int len = nums.length;
        for(;i<len;++i){
            if(nums[i]!=0){
                nums[j] = nums[i];
                if(i!=j){
                    nums[i] = 0;
                }
                j++;
            }
        }
    }


}
