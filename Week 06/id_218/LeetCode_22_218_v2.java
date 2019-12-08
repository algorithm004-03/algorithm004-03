package leetcode.week6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eason.feng at 2019/11/25/0025 14:54
 **/
public class LeetCode_22_218_v2 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; c++) {
                for (String left: generateParenthesis(c)) {
                    for (String right: generateParenthesis(n-1-c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode_22_218_v2 leetCode_22_218_v2 = new LeetCode_22_218_v2();
        List<String> res = leetCode_22_218_v2.generateParenthesis(3);
        System.out.println(res);
    }
}
