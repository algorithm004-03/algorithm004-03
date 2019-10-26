/**
 *
 * @Author Lukas
 * @Description 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * @Date 14:06 2019/10/14
 * @Param
 * @return
 **/
public class LeetCode_283_138 {

    public void moveZeroes(int[] nums) {
        if (nums != null || nums.length == 0) {
            return ;
        }
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {//交换条件1 记录非0元素个数
                if (i != k) {//交换条件2
                    nums[k] = nums[i];
                    nums[i] = 0;
                }
                k++;
            }
        }
    }
}
