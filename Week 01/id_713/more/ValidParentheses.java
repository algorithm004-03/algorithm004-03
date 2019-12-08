package id_713.more;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 1. 暴力求解, 不断的replace括号, 复杂度 O(n^2)
 * <p>
 * 2. Stack 如果左括号压入栈, 如果是右括号与栈顶元素进行匹配
 * 匹配上栈顶元素弹出栈, 否则不合法, 直到栈为空则认为是有效的
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (int i = 0; i < s.length(); i++) {
            Character tmp = s.charAt(i);
            if (!stack.empty() && map.get(stack.peek()) == tmp) {
                stack.pop();
            } else {
                stack.push(tmp);
            }
        }

        return stack.empty();
    }

}