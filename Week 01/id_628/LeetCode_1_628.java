//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表



//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_1_628 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> cache=new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(cache.containsKey(target-nums[i])){
                return new int[] {cache.get(target-nums[i]),i};
            }
            cache.put(nums[i], i);
        }
        return new int[] {};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/****
 *  1.暴力法
 *  2.双指针
 *  3.缓存数据
 */
