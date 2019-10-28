//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
// 注意空字符串可被认为是有效字符串。
//
// 示例 1:
//
// 输入: "()"
//输出: true
//
//
// 示例 2:
//
// 输入: "()[]{}"
//输出: true
//
//
// 示例 3:
//
// 输入: "(]"
//输出: false
//
//
// 示例 4:
//
// 输入: "([)]"
//输出: false
//
//
// 示例 5:
//
// 输入: "{[]}"
//输出: true
// Related Topics 栈 字符串


import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> tmp = new HashMap<>();
        //'('，')'，'{'，'}'，'['，']'
        tmp.put('(',')');
        tmp.put('{','}');
        tmp.put('[',']');

        //放入stack
        for (int i = s.length() - 1; i >= 0; i--) {
            Character current = s.charAt(i);

            if (current == ' '){
                continue;
            }

            //是否与栈顶的成一对,是则弹出
            Character right = tmp.get(current);
            if (stack.size() > 0 && right == stack.peek()) {
                stack.pop();
                continue;
            }

            stack.add(current);
        }
        return stack.empty();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
