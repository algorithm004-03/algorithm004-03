import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_22_368 {

    /*给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
    https://leetcode-cn.com/problems/generate-parentheses/*/

    public static void main(String[] args) {
        LeetCode_22_368 test = new LeetCode_22_368();
        List<String> strings = test.generateParenthesis(3);
        strings.stream().forEach(s -> System.out.println(s));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res  = new ArrayList<>();
        generate(0, 2 * n, "", res);
        generate02(0, 0, n, "", res);
        return res;
    }

    private void generate(int level, int max, String s, List<String> res) {
        // terminator
        if (level >= max) {
            if (filter(s)) {
                res.add(s);
            }
            return;
        }

        // process current logic & drill down
        generate(level + 1, max, s + "(", res);
        generate(level + 1, max, s + ")", res);

        // reverse states
    }

    private void generate02(int left, int right, int max, String s, List<String> res) {
        // terminator
        if (left == max && right == max) {
            res.add(s);
            return;
        }

        // process current logic & drill down
        if (left < max) {
            generate02(left + 1, right, max, s + "(", res);
        }
        if (right < left) {
            generate02(left, right + 1, max, s + ")", res);
        }
        // reverse states
    }

    private boolean filter(String s) {
        LinkedList stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if ('(' == c) {
                stack.addFirst(c);
            }
            if (')' == c) {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.removeFirst();
            }
        }
        return stack.isEmpty();
    }

}
