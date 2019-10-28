package com.company.leetcode.editor.cn;
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


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_51 {
    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();

        if (digits.length() == 0) {
            return res;
        }

        Map<Character,String> numsMap = new HashMap<>();
        numsMap.put('2',"abc");
        numsMap.put('3',"def");
        numsMap.put('4',"ghi");
        numsMap.put('5',"jkl");
        numsMap.put('6',"mno");
        numsMap.put('7',"pqrs");
        numsMap.put('8',"tuv");
        numsMap.put('9',"wxyz");

        helper(digits,res,numsMap, 0,"");
        return res;
    }

    private void helper(String digits, List<String> res, Map<Character, String> numsMap,int index,String s ) {

        if (index == digits.length()) {
            res.add(s);
            return;
        }
        String letters = numsMap.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            helper(digits,res,numsMap,index + 1,s + letters.charAt(i));
        }

    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        List res = s.letterCombinations("23");
//        System.out.println(res.toString());
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
