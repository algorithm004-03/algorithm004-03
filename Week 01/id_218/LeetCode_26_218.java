package leetcode;

/**
 * leetcode china address: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author eason.feng at 2019/10/20/0020 16:29
 **/
public class LeetCode_26_218 {

    public final int removeDuplicates(final int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
