//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		if (nums == null) {
			return new ArrayList<>();
		}
		List<List<Integer>> result = new ArrayList<>();
		recursiveProcess(result, nums, new ArrayList<Integer>(), 0);
		return result;
	}

	public void recursiveProcess(List<List<Integer>> result, int[] nums, List<Integer> middle, int index) {
		//terminator
		if (index == nums.length) {
			result.add(new ArrayList<>(middle));
			return;
		}
		//process current logic
		//不处理这个元素
		recursiveProcess(result, nums, middle, index + 1);
		//处理这个元素
		middle.add(nums[index]);
		recursiveProcess(result, nums, middle, index + 1);
		//drill down
		//reverse status if need
		middle.remove(middle.size() - 1);
	}

}
//leetcode submit region end(Prohibit modification and deletion)
