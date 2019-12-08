package id_713;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LeetCode_17_LetterCombinationsOfAPhoneNumber {


    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();


    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return output;

        backtrack("", digits);

        return output;
    }


    public void backtrack(String combination, String next_digits) {
        // 当没有数字可用的时候, 添加结果
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        } else {
            // 获取当前第一个数字
            String digit = next_digits.substring(0, 1);
            // 获取当前第一个数字对应的字母
            String letters = phone.get(digit);
            // 遍历字母, 也就是可能的值
            for (int i = 0; i < letters.length(); i++) {
                // 截取第i个字母
                String letter = phone.get(digit).substring(i, i + 1);
                // 追加到合并值里, 然后下探
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }


}
