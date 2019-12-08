/**
 * LeetCode_26_153
 * 
 * @desc LeetCode 26 题
 *       https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class LeetCode_26_153 {

  /**
   * 注意审题，给定排序数组，删除重复元素 根据题意最后输出数组，可知不是真的删除元素， 而是将不同元素移到数组前面，返回有个多少个元素即可
   * 
   * 解法：快慢指针，将第一个元素与后面的元素比较，如果不同，将元素迁移，
   * 同时指针指向这个元素，然后再开始往后面比较，依次类推，这样就把所有不同元素都挪到前边了
   * 
   * @param nums
   * @return
   */
  public int removeDuplicates(int[] nums) {
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[j] != nums[i]) {
        i++;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }
}