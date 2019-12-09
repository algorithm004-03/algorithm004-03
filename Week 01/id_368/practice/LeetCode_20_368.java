package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: liuyanhui@daojia-inc.com
 * @date: 2019/10/22
 */
public class LeetCode_20_368 {

    /*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    有效字符串需满足：
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。
    链接：https://leetcode-cn.com/problems/valid-parentheses*/

    public static void main(String[] args) {
        String s = "({[]}){}()";
        System.out.println(isValid02(s));
    }

    private static final Map<Character, Character> map = new HashMap<>();
    static {
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }

    public static boolean isValid(String s) {
        if (s == "") {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !map.get(stack.peek()).equals(c)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid02(String s) {
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            if (s.contains("()")) {
                s = s.replace("()", "");
            }
            if (s.contains("[]")) {
                s = s.replace("[]", "");
            }
            if (s.contains("{}")) {
                s = s.replace("{}", "");
            }
        }
        return s.isEmpty();
    }

}
