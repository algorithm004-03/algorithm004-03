package leetcode.week6;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 *
 * @author eason.feng at 2019/11/25/0025 14:11
 **/
public class LeetCode_22_218 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        this.generate(0, 0, "", list, n);
        System.out.println(list);
        return list;
    }

    private void generate(int left, int right, String s, List<String> list, int n) {
        //terminator
        if (left == n && right == n) {
            list.add(s);
            return;
        }
        //process
        //drill down
        if (left < n) {
            this.generate(left + 1, right, s + "(", list, n);
        }
        if (right < left) {
            this.generate(left, right + 1, s + ")", list, n);
        }
        //reverse state
    }


}
