package id_693;

/**
 * @Desc 26. 删除排序数组中的重复项:https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/14
 */
public class LeetCode_26_693 {
    public int removeDuplicates(int[] nums) {

        int len = nums.length;
        if (len == 0) return len;
        int i = 0;
        for (int j = 1; j < len; ++j) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        new LeetCode_26_693().removeDuplicates(new int[0]);
        new LeetCode_26_693().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    }
}
