package leetcode.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author eason.feng at 2019/10/27/0027 15:12
 **/
public class LeetCode_17_218 {

    public static void main(String[] args) {
        LeetCode_17_218 leetCode_17_218 = new LeetCode_17_218();
        List<String> list = leetCode_17_218.letterCombinations("23");
        System.out.println(list);
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        Map<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        search("", digits, 0, res, map);
        return res;
    }

    private void search(String s, String digits, int level, List<String> res, Map<Character, String> map) {
        //terminator
        if (level == digits.length()) {
            res.add(s);
            return;
        }
        //process
        String letters = map.get(digits.charAt(level));
        for (int i = 0; i < letters.length(); i++) {
            //drill down
            search(s + letters.charAt(i), digits, level + 1, res, map);
        }
        //reverse state
    }

}
