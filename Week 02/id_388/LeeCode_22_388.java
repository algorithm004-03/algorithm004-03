package com.company.leetcode.editor.cn;
//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
//
// 例如，给出 n = 3，生成结果为：
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
//
// Related Topics 字符串 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_22 {
    private List res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList();
        helper(0,0,n,"");

        return res;
    }

    private void helper(int left,int right,int n,String s) {
        if (left == n && right == n) {
            res.add(s);
            return;
        }

        if (left < n) {
            helper(left + 1,right,n,s + "(");
        }
        if (right < left) {
            helper(left,right + 1,n,s + ")");
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
