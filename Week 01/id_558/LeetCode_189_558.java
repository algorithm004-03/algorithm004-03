/**
 * @see <a href="189">https://leetcode-cn.com/problems/rotate-array/</a>
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class LeetCode_189_558 {
    /**
     * 步骤：
     * 1、处理边界条件
     * 2、最后k个元素拷贝到一个临时数组
     * 3、原数组向整体向右移动k个位置
     * 4、把临时数组拷贝到原数组前k个位置
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int arr[] = new int[k];
        for (int i = nums.length - k; i < nums.length; i++) {
            arr[i - (nums.length - k)] = nums[i];
        }
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(arr, 0, nums, 0, k);
    }

    /**
     * 优化解法：
     * 1、整体旋转数组
     * 2、旋转数组前k个元素
     * 3、旋转数组后len - k个元素
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */

    public void optRotate(int[] nums, int k) {
        k = k % nums.length;
        reverseArr(nums, 0, nums.length);
        reverseArr(nums, 0, k);
        reverseArr(nums, k, nums.length);
    }

    public void reverseArr(int[] nums, int start, int end) {
        for (int i = start; i < start + (end - start + 1) / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[end - 1 - i + start];
            nums[end - 1 - i + start] = temp;
        }
    }
}
