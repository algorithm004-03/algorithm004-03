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

package com.modds.alltest.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_22_443_GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new LeetCode_22_443_GenerateParentheses().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            generate(list, new StringBuilder(), n, n);
            return list;

        }

        private void generate(List<String> list, StringBuilder sb, int nl, int nr) {
            if (nl == 0 && nr == 0) {
                list.add(sb.toString());
                return;
            }
            if (nl > 0) {
                generate(list, new StringBuilder(sb).append("("), nl - 1, nr);
            }
            if (nr > nl) {
                generate(list, new StringBuilder(sb).append(")"), nl, nr - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}