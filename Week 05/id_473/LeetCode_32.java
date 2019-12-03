package LeetCode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 32.最长有效括号
 */
public class LeetCode_32 {
    public static void main(String[] args) {
        String str = "()()(())";
        System.out.println(longestValidParentheses(str));
    }

    //暴力
   /* private static int  longestValidParentheses(String str) {
        int n = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 2; j <= str.length(); j+=2) {
                if (checkValid(str.substring(i, j))){
                    n = Math.max(n, j - i);
                }
            }
        }
        return n;
    }

    private static boolean checkValid(String str) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '('){
                stack.push('(');
            }else  if (!stack.empty() && stack.peek() == '('){
                stack.pop();
            }else {
                return false;
            }
        }
        return stack.empty();
    }*/


    //动态规划
    public static int longestValidParentheses(String str) {
        int maxlen = 0;
        int[] dp = new int[str.length()];
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                if (str.charAt(i - 1) == '('){
                    //前面是左括号，则i大于等于2时，前两位的dp 加上2
                    dp[i] = (i >= 2? dp[i - 2]: 0) +2;
                }else if (i - dp[i - 1] > 0 && str.charAt(i - dp[i - 1] - 1) == '(') {
                    //前面是右括号，且除去前面dp个数的字符串 还有字符，并且是左括号，则用前一位的dp 加上 前面对应左括号的前一位dp 再加上2，就是当前括号的dp
                    dp[i] = dp[i - 1] + ((i - dp[i -1]) >= 2? dp[i - dp[i - 1] -2]: 0) + 2;
                }
                maxlen = Math.max(maxlen, dp[i]);
            }
        }
        return maxlen;
    }
}
