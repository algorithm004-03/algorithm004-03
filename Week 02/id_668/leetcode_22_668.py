#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: generate_parenthesis.py
    @time: 2019/10/25 07:13
"""
from collections import Counter


class Solution(object):
    """
        给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
        例如，给出 n = 3，生成结果为：

        [
          "((()))",
          "(()())",
          "(())()",
          "()(())",
          "()()()"
        ]

        思想：
        1. 想象格子中添加元素
        2. 格子数对应递归层数
    """

    def generate_parenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]

        暴力求解：先获取到所有可能的括号组合，然后再判断括号组合是否合法
        """
        strs = ['(', ')']  # 第一格可放置'(' or ')'

        for i in range(1, n << 1):  # 这里从第二格开始判断
            pths = []

            for s in strs:
                pths.append(s + '(')
                pths.append(s + ')')

            strs = pths

        def valid(parenthesis):
            """
                parenthesis：判断括号是否合法
            """
            if Counter(parenthesis).values() == [n, n]:
                stack = []

                for c in parenthesis:
                    if c == '(':
                        stack.append(c)
                    else:
                        if stack:
                            stack.pop()
                        else:
                            return False

                return stack == []

            return False

        return [s for s in strs if valid(s)]

    def generate_parenthesis2(self, n):
        """
        :type n: int
        :rtype: List[str]

        分析：
        1. 终止条件
        2. 处理当前层
        3. 下探到下一层
        4. 若需要，清理状态值
        """

        def generate(grid, pths):
            # 终止条件，格子数大于n * 2
            if grid > n << 1:
                return pths

            # 处理当前层逻辑
            new_pths = []

            for s in pths:
                new_pths.append(s + '(')
                new_pths.append(s + ')')

            # 下探到下一层
            return generate(grid + 1, new_pths)

        def valid(parenthesis):
            """
                parenthesis：判断括号是否合法
            """
            if Counter(parenthesis).values() == [n, n]:
                stack = []

                for c in parenthesis:
                    if c == '(':
                        stack.append(c)
                    else:
                        if stack:
                            stack.pop()
                        else:
                            return False

                return stack == []

            return False

        return [pth for pth in generate(2, ['(', ')']) if valid(pth)]

    def generate_parenthesis3(self, n):
        """
        :type n: int
        :rtype: List[str]

        递推：n个格子形成的字符串str(n)等于n-1个格子的字符串str(n-1)+'('与str(n-1)+')'
        层的概念：从第1个格子 ~ 第n个格子

        n对括号，相当于2n个格子，递归里讲到的层就是对应这里的格子数，比如第一层指第一个格子，第二层指第二个格子
        在格子数不断增加（递归层数增加）的过程中，依据'('、')'数去判断当前生成的括号是否合法
        """
        ans = []

        def generate(s='', left=0, right=0):
            """
                s：原始字符串
                left：左括号数量
                right：由括号数量
            """

            if len(s) == 2 * n:
                ans.append(s)

                return

            if left < n:
                # 左括号数量<n时，可继续添加'('
                generate(s + '(', left + 1, right)

            if right < left:
                # 右括号的数量需小于左括号，可执行添加')'操作，否则生成的括号组合就不合法
                generate(s + ')', left, right + 1)

        generate()

        return ans

