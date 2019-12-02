package com.company.leetcode.editor.cn;
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_77 {
    private int n;
    private int k;
    List<List<Integer>> res = new ArrayList();
    //暴力解法
    public List<List<Integer>> combine(int n, int k) {

        this.n = n;
        this.k = k;
        LinkedList<Integer> curr = new LinkedList();
        helper(1,curr);
        return res;
    }

    private void helper(int first,LinkedList<Integer> curr) {
        if (curr.size() == k) {
            res.add(new LinkedList<>(curr));
        }
        for (int i = first; i < n + 1; i++) {
            curr.add(i);
            helper(i + 1,curr);
            curr.removeLast();//回溯
        }

    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        List list = s.combine(2,1);
//        System.out.println(list.toString());
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
