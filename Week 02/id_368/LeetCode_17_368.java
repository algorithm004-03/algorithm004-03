import java.util.*;

public class LeetCode_17_368 {

    /*给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/*/

    public static void main(String[] args) {

    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        StringBuilder s = new StringBuilder();
        List<String> res = new ArrayList<String>();
        combine(map, digits, 0, res, "");
        return res;
    }

    public void combine (Map<Character, String> map, String digits, int index, List<String> res, String str) {
        // terminator
        if (index == digits.length()) {
            res.add(str);
            return;
        }

        // process current logic
        String letters = map.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            // drill down
            combine(map, digits, index + 1, res, str + letters.charAt(i));
        }
    }

    public List<String> letterCombinationsIterater(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) return new ArrayList();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        while (res.peek().length() != digits.length()) {
            String str = res.remove();
            String mapper = mapping[digits.charAt(str.length()) - '0'];
            for (char c : mapper.toCharArray()) {
                res.add(str + c);
            }
        }
        return res;
    }
}
