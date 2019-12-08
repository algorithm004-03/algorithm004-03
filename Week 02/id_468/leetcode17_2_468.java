package week2;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 17. Letter Combinations of a Phone Number
 * @author: 王瑞全
 * @create: 2019-10-2819:56
 **/


public class leetcode17_2_468 {
    String[][] refer = {{}, {}, {"a", "c", "b"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};

    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        if (!digits.equals("")) {
            solve(digits,answer,"");
        }
        return answer;
    }

    public void solve(String digits, List<String> anwser, String item) {
        if (digits.length() == 0) {
            anwser.add(item);
            return;
        }
        int idx = Integer.parseInt(digits.substring(0, 1));
        for (String k : refer[idx]) {
            solve(digits.substring(1, digits.length()), anwser,item + k);
        }
        return;
    }
}
