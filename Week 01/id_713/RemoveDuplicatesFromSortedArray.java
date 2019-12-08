package id_713;

/**
 * 26. 删除排序数组中的重复项
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicatesFromSortedArray {

    /*
    读题:
    1. 返回值是新数组长度
    2. 原数组需要变换
    思路:
    1. 记录重复度的次数
    2. 需要把后面的值往前覆盖, 索引即是 当前 i - 重复的次数
    3. 数组长度 - 重复的次数 = 要返回的值
     */

    public int removeDuplicates(int[] nums) {
        int max = Integer.MIN_VALUE, mod = 0; // 定义当前最大值, 和重复次数(某种程度的模数)

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == max) { // 出现重复, 记录重复的次数
                mod++;
            } else {
                nums[i - mod] = nums[i]; // 把当前值 赋值给 从当前到最近重复的索引, 因为一定是 mod <= i
                max = (max > nums[i] ? max : nums[i]);
            }
        }
        return nums.length - mod;
    }

    /**
     * 66. 加一
     * <p>
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * <p>
     * 示例 1:
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * <p>
     * 示例 2:
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     */
    public static class PlusOne {

        public int[] plusOne(int[] digits) {

            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i]++;
                digits[i] = digits[i] % 10; // 为了不超过2位数, 保留个位数

                // 只增加一次且不进位的话, 或者一直加到不进位时, 直接退出
                if (digits[i] != 0) {
                    return digits;
                }
            }

            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        }

    }
}