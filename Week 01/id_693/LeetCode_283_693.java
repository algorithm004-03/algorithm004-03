package id_693;

/**
 * @Desc 283. 移动零 https://leetcode-cn.com/problems/move-zeroes/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/14
 */
public class LeetCode_283_693 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        int temp = 0;
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (nums[i] != 0) {
                temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }
    }

    public void moveZeroes_2(int[] nums) {
        int len = nums.length;
        for (int i = 0, j = 0; i < len; ++i) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (j != i) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }


}
