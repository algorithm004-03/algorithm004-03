class Solution {
    public void rotate(int[] nums, int k) {
        int newK = k % nums.length;
        System.out.println(newK);
        if (0 != newK) {
            int[] temp = new int[newK];
            System.arraycopy(nums, nums.length - newK, temp, 0, newK);
            for (int i = nums.length - newK - 1; i >= 0; --i) {
                nums[i + newK] = nums[i];
            }
            System.arraycopy(temp, 0, nums, 0, newK);
        }
        return;
    }
}

public class LeetCode_189_663 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = new int[]{1,2};
        s.rotate(a, 3);
    }
}
