/**
 * 删除排序数组中的重复项
 * @author Lukas
 * @since 2019/10/18 23:38
 **/
public class LeetCode_26_138 {
    /**
     * 双指针法：时间复杂度O(n),空间复杂度:O(1)
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int L = 0;
        int R = 1;
        while (R < nums.length) {
            if (nums[L] != nums[R]) {
                nums[++L] = nums[R];
            }
            R++;
        }
        return L+1;
    }
}
