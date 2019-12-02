package com.ning.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 出口条件
 * 逻辑处理
 * drill down
 * 状态保存
 *
 * @author shaoyu
 * @create 2019-11-03 下午11:01
 */
public class LeetCode_17_148 {
    private Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    private List<String> output = new ArrayList<String>();

    public void recursion(String combination, String next_digits) {
        if (next_digits.length() == 0) {
            output.add(combination);
        } else {
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                recursion(combination + letter, next_digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            recursion("", digits);
        return output;
    }
}
