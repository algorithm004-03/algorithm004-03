package id_693.practise;

import java.util.Stack;

/**
 * @Desc 20. 有效的括号  https://leetcode-cn.com/problems/valid-parentheses/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/17
 */
public class LeetCode_20_693 {
    //暴力破解 采用数组
    /*
            123 -> {
            125 -> }
             91 -> [
             93 -> ]
             40 -> (
             41 -> ）
    */

    //执行用时 : 1 ms , 在所有 java 提交中击败了 99.80% 的用户
    //内存消耗 : 33.9 MB , 在所有 java 提交中击败了 90.43% 的用户
    public boolean isValid(String s) {
        int len = s.length();
        int f = 1;
        char[] temp = new char[len + 1];
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if ('(' == c || '[' == c || '{' == c) {
                temp[f++] = c;
            } else if (c - temp[f - 1] == 1 || c - temp[f - 1] == 2) {
                f--;
            } else {
                return false;
            }
        }
        return f == 1;
    }

    //利用栈   执行用时 : 2 ms , 在所有 java 提交中击败了 96.81% 的用户
    //内存消耗 : 34.4 MB , 在所有 java 提交中击败了 84.27% 的用户
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('[' == c) {
                stack.push(']');
            } else if ('{' == c) {
                stack.push('}');
            } else if ('(' == c) {
                stack.push(')');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_20_693().isValid("()"));//true
        System.out.println(new LeetCode_20_693().isValid("()[]{}"));//true
        System.out.println(new LeetCode_20_693().isValid("(]"));//false
        System.out.println(new LeetCode_20_693().isValid("([]{}"));//false

        System.out.println(new LeetCode_20_693().isValid2("()"));//true
        System.out.println(new LeetCode_20_693().isValid2("()[]{}"));//true
        System.out.println(new LeetCode_20_693().isValid2("(]"));//false
        System.out.println(new LeetCode_20_693().isValid2("([]{}"));//false
    }
}
