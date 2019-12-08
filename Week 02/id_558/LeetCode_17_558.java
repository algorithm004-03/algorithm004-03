package Week02;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Date 2019/10/27.
 * @see <a href="17">https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/</a>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 */

public class LeetCode_17_558 {
    /**
     * 思想：只关注当前层级不要人肉递归
     * 步骤拆解：
     * 1、选择合适的容器，存储数据
     * 2、模型转换（左右括号问题）
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }
        HashMap<Character, String> letterMap = new HashMap<Character, String>();
        letterMap.put('2', "abc");
        letterMap.put('3', "def");
        letterMap.put('4', "ghi");
        letterMap.put('5', "jkl");
        letterMap.put('6', "mno");
        letterMap.put('7', "pqrs");
        letterMap.put('8', "tuv");
        letterMap.put('9', "wxyz");

        char[] chars = digits.toCharArray();
        List<String> list = new ArrayList<String>();
        genLetterCombinations(list, letterMap, chars, "", 0);
        return list;
    }

    public void genLetterCombinations(List<String> list, HashMap<Character, String> letterMap, char[] chars, String s, int level) {
        if (level == chars.length) {
            list.add(s);
            return;
        }
        String currentLetter = letterMap.get(chars[level]);
        for (int j = 0; j < currentLetter.length(); j++) {
            genLetterCombinations(list, letterMap, chars, s + currentLetter.charAt(j), level + 1);

        }
    }
}
