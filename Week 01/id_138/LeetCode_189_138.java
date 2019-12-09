/**
 * 旋转数组
 * @author Lukas
 * @since 2019/10/19 0:29
 **/
public class LeetCode_189_138 {
    /**
     * 将数组向右移动k位
     * 暴力法:每个元素移动k次
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int tail ,temp;
        for (int i = 0; i < k; i++) {//1 2 3 4 5 -> 5 1 2 3 4  -> 4 5 1 2 3 ->3 4 5 1 2
            tail = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = tail;
                tail = temp;
            }
        }
    }

    /**
     * 反转数组：先反转所有元素，类似倒序；然后将前k个元素和剩余的n-k个元素倒排
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        if (nums==null || nums.length==0)
            return ;
        int len = nums.length;
        k = k%len;
        reverseArray(nums, 0, len-1);
        reverseArray(nums, 0,k-1);
        reverseArray(nums,k,len-1);
    }

    public void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
