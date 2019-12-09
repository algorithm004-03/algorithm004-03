#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: longest_valid_parentheses.py
    @time: 2019/11/16 14:17
"""


class Solution(object):
    """
        给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

        示例 1:
        输入: "(()"
        输出: 2
        解释: 最长有效括号子串为 "()"

        示例 2:
        输入: ")()())"
        输出: 4
        解释: 最长有效括号子串为 "()()"
    """

    def longest_valid_parentheses(self, s):
        """
        :type s: str
        :rtype: int

        暴力破解：获取所有的括号组合，然后找出最长有效括号的长度
        """
        lvp = 0

        def len_str_valid(sub):
            """
                求出合格的括号组号的长度
            """
            stack, d = [], {')': '('}

            for e in sub:
                if e in d:
                    if stack:
                        if stack.pop() != d[e]:
                            return 0
                    else:
                        return 0
                else:
                    stack.append(e)

            return len(sub) if stack == [] else 0

        for i in range(len(s)):
            if s[i] == ')':
                continue

            for j in range(i, len(s)):
                if s[j] == '(' or len(s[i:j + 1]) % 2 != 0:
                    continue

                lvp = max(len_str_valid(s[i:j + 1]), lvp)

        return lvp

    def longest_valid_parentheses2(self, s):
        """
        :type s: str
        :rtype: int

        DP步骤：
        1. 重复性（子问题）
        2. dp动态数组定义
        3. dp方程
        """

        dp, max_val = [0 for _ in range(len(s))], 0

        for i in range(1, len(s)):
            if s[i] == ')':
                if s[i - 1] == '(':
                    # ...()这种结构，可以推导出dp[i] = dp[i-2] + 2
                    dp[i] = (dp[i - 2] if i >= 2 else 0) + 2
                elif i - dp[i - 1] > 0 and s[i - dp[i - 1] - 1] == '(':
                    # ...))这种结构，可以推导出dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
                    dp[i] = dp[i - 1] + (dp[i - dp[i - 1] - 2] if i - dp[i - 1] >= 2 else 0) + 2

                max_val = max(max_val, dp[i])

        return max_val

    def longest_valid_parentheses3(self, s):
        """
        :type s: str
        :rtype: int

        遇到洋葱结构的问题，可以优先想到使用栈来解决。
        """

        max_val, stack = 0, [-1]

        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            else:
                stack.pop()

                if not stack:
                    # stack为空，说明操作的是一个有效的括号组合
                    stack.append(i)
                else:
                    max_val = max(max_val, i - stack[-1])

        return max_val

