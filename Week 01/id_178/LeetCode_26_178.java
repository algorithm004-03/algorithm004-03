package org.geektime.weak01;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_26_178 {
    public static void main(String[] args) {
        int nums[]= {0,0,1,1,2,21,31,41,41};
    LeetCode_26_178 instance = new LeetCode_26_178();
    instance.removeDuplicates1(nums);
    }

    /**
     * 双指针法
     * 算法
     *
     * 数组完成排序后，我们可以放置两个指针 i 和 j，其中 i 是慢指针，而 j 是快指针。
     *    只要 nums[i] = nums[j] 我们就增加 j 以跳过重复项。
     *
     * 当我们遇到 nums[j] <> nums[i]时，
     *    跳过重复项的运行已经结束，因此我们必须把它（nums[j]）的值复制到 nums[i + 1]。
     *    然后递增 i，接着我们将再次重复相同的过程，直到 j 到达数组的末尾为止。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-xiang-by-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int removeDuplicates1(int[] nums) {
        if (nums.length == 0) return 0;
        int i =0;
        for (int j = 1;j < nums.length;j++){
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                if(q - p > 1){
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }


    public int removeDuplicates3(int[] nums) {
        int i = nums.length > 0 ?  1 : 0;
        for (int n:nums)
            if (n>nums[i-1])
                nums[i++] = n;
        return i;
    }


}

