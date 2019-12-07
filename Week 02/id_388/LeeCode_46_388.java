package com.company.leetcode.editor.cn;//给定一个没有重复数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_46 {
    List<List<Integer>> outPut = new LinkedList();
    private int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        LinkedList curr = new LinkedList();
        LinkedList left = new LinkedList();
        for (int i = 0; i < nums.length; i++) {
            left.add(nums[i]);
        }

        helper(curr,left);
        return outPut;
    }

    private void helper(LinkedList curr,LinkedList left) {
        if (curr.size() == nums.length) {
            LinkedList tmp1 = new LinkedList();
            for (int i = 0; i < curr.size(); i++) {
                tmp1.add(curr.get(i));
            }
            outPut.add(tmp1);
            return;
        }

        for (int j = 0; j < left.size(); j++) {
            int value = (int) left.get(j);
            curr.add(value);
            LinkedList tmp = new LinkedList();
            for (int i = 0; i < left.size(); i++) {
                tmp.add(left.get(i));
            }
            tmp.remove(j);
            helper(curr,tmp);
            curr.removeLast();
        }

    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        List res = s.permute(new int[]{1,2,3,4});
//        System.out.println(res.toString());
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
