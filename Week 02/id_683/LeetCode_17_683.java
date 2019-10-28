import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

class Solution {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        List<String> result = new LinkedList<>();
        combinations(digits, 0, map, result, "");
        return result;
    }

    private void combinations(String digits, int i, HashMap<Character, String> map, List<String> result, String s) {
        if (s.length() == digits.length()) {
            result.add(s);
            return;
        }

        String letters = map.get(digits.charAt(i));
        for (int j = 0; j < letters.length(); ++j) {
            combinations(digits, i + 1, map, result, s + letters.charAt(j));
        }

    }
}