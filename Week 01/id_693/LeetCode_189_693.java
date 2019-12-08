package id_693;

/**
 * @Desc 189. 旋转数组   :https://leetcode-cn.com/problems/rotate-array/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/14
 */
public class LeetCode_189_693 {
    public void rotate(int[] nums,int k) {
        int count = k % nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,count - 1);
        reverse(nums,count,nums.length - 1);
    }

    private void reverse(int[] nums,int left,int right) {
        int temp;
        while (left < right) {
            temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }

    public static void main(String[] args) {
        new LeetCode_189_693().rotate(new int[]{1,2,3,4,5,6,7},3);
    }
}
