//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法

package com.modds.alltest.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_17_443_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LeetCode_17_443_LetterCombinationsOfAPhoneNumber().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<String> list = new ArrayList<>();
        private Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) return list;
            sub("", digits.toCharArray(), 0);
            return list;
        }

        private void sub(String sb, char[] cs, int index) {
            if (index >= cs.length) {
                list.add(sb);
                return;
            }

            char c = cs[index];
            String re = map.get(c);

            for (int i = 0; i < re.length(); i++) {
                char sc = re.charAt(i);
                sub(sb + sc, cs, index + 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}