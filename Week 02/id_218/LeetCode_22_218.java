package leetcode.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 *
 * @author eason.feng at 2019/10/27/0027 12:03
 **/
public class LeetCode_22_218 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        generate(0, 0, n, "", list);
        return list;
    }

    private void generate(int left, int right, int n, String s, List<String> list) {
        // terminator
        if (left == n && right == n) {
            list.add(s);
            return;
        }
        // process

        // drill down
        if (left < n) {
            generate(left + 1, right, n, s + "(", list);
        }
        if (left > right) {
            generate(left, right + 1, n, s + ")", list);
        }

        // reverse states
    }

    public static void main(String[] args) {
        LeetCode_22_218 leetCode_22_218 = new LeetCode_22_218();
        List<String> list = leetCode_22_218.generateParenthesis(3);
        System.out.println(list);
    }

}
