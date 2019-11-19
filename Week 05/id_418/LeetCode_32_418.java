package com.ljg.leetcode.week05.a02;

import java.util.Stack;

/**
 * LongestValidParentheses
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        LongestValidParentheses lvp = new LongestValidParentheses();
        String s1 = "(()";
        String s2 = ")()())";
        String s3 = "";
        String s4 = ")";
        String s5 = "(";
        String s6 = "()(()";
        String s7 = ")(((((()())()()))()(()))(";
        String s8 = "))))((()((";
        String s9 = "(())()(()((";
        String sa = "((()()(()((()";
        String sb = "(()()(()(()))()((()))((()(()())()(()))())))()(()()))())))))))()()()()))(((()())((()()(((())))()(()()(())((()))))))(()(()))(((()())()))(()))((((()(()()()())()()(()))(()()(())()((()()())))(())()())()(";

        System.out.println("maxLen1=" + lvp.longestValidParentheses(s1) + ", " + s1);
        System.out.println("maxLen2=" + lvp.longestValidParentheses(s2) + ", " + s2);
        System.out.println("maxLen3=" + lvp.longestValidParentheses(s3) + ", " + s3);
        System.out.println("maxLen4=" + lvp.longestValidParentheses(s4) + ", " + s4);
        System.out.println("maxLen5=" + lvp.longestValidParentheses(s5) + ", " + s5);
        System.out.println("maxLen6=" + lvp.longestValidParentheses(s6) + ", " + s6);
        System.out.println("maxLen7=" + lvp.longestValidParentheses(s7) + ", " + s7);
        System.out.println("maxLen8=" + lvp.longestValidParentheses(s8) + ", " + s8);
        System.out.println("maxLen9=" + lvp.longestValidParentheses(s9) + ", " + s9);
        System.out.println("maxLena=" + lvp.longestValidParentheses(sa) + ", " + sa);
        System.out.println("maxLenb=" + lvp.longestValidParentheses(sb) + ", " + sb);
    }

    int getMaxLen(Stack<Integer> stack, int end, int maxLen, int tempLen) {
        Stack<Integer> stack2 = (Stack<Integer>) stack.clone();
        while (!stack2.isEmpty()) {
            int index = stack2.pop();
            if (index > end) {
                tempLen--;
            } else {
                tempLen = end - index;
                break;
            }
        }

        if (tempLen > maxLen) {
            maxLen = tempLen;
        }
        return maxLen;
    }

    int getMaxLen2(int lastIndex, int end, int maxLen) {
        if ((end - lastIndex) > maxLen) {
            maxLen = end - lastIndex;
        }
        return maxLen;
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 0;
        int tempLen = 0;

        int end = -1;
        int lastIndex = -1;
        int lastIndex2 = -1;

        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                // if (stack.isEmpty()) {
                //     lastIndex = i - 1;
                // }
                // maxLen = getMaxLen(stack, end, maxLen, tempLen);
                maxLen = getMaxLen2(lastIndex, end, maxLen);
                stack.push(i);
                tempLen++;
            } else {
                if (stack.isEmpty()) {
                    if (tempLen > maxLen) {
                        maxLen = tempLen;
                    }
                    tempLen = 0;
                    lastIndex = i;
                    lastIndex2 = i;
                    
                    continue;
                } else {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        lastIndex = stack.peek();

                        if(lastIndex>69 && i<lastIndex) {
                            System.out.println("i:" + i + ", " + s.charAt(i) + ", lastIndex:" + lastIndex);
                        }
                    } else {
                        lastIndex = lastIndex2;
                    }
                    tempLen++;
                    end = i;
                }
            }
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            if (index > end) {
                tempLen--;
            } else {
                tempLen = end - index;
                break;
            }
        }

        if (tempLen > maxLen) {
            maxLen = tempLen;
        }

        return maxLen;
    }
}