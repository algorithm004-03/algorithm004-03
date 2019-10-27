package com.company.leetcode.editor.cn;
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
class Solution_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res,new ArrayList<>(),0,nums);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> curr, int index, int[] nums) {

        //t
        if (index == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        helper(res,curr,index + 1,nums);
        curr.add(nums[index]);
        helper(res,curr,index + 1,nums);
        curr.remove(curr.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
