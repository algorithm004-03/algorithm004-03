/**
 * @author: liuyanhui@daojia-inc.com
 * @date: 2019/10/22
 */
public class LeetCode_26_368 {

    /*给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
    链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array*/

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        // 因为数组已经排序，所以采用双指针从头至尾分别记录已去重位置和遍历位置
        if (nums == null || nums.length <= 0 ) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                if (i != j) {
                    nums[j] = nums[i];
                }
            }
        }
        return j+1;
    }
}
