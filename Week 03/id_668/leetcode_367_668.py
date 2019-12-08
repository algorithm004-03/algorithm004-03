#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: valid_perfect_square.py
    @time: 2019/11/2 13:34
"""


class Solution(object):
    """
        给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
        说明：不要使用任何内置的库函数，如  sqrt。

        示例 1：
        输入：16
        输出：True

        示例 2：
        输入：14
        输出：False

    """

    def is_perfect_square(self, num):
        """
        :type num: int
        :rtype: bool

        分析：
        一个完全平方数一定是一个正整数的二次方，而非完全平方数一定是介于一个值的二次方与这个值加1的二次方之间

        时间复杂度：O(logn)
        空间复杂度：O(1)
        """
        left, right, res = 0, num, False

        while left <= right:
            mid = left + (right - left) / 2
            square = mid * mid
            square_one = (mid + 1) * (mid + 1)

            if square < num < square_one:
                # 非完全平方数
                break
            elif square == num:
                # 完全平方数
                res = True
                break
            elif num < square:
                right = mid
            else:
                left = mid + 1

        return res

    def is_perfect_square2(self, num):
        """
        :type num: int
        :rtype: bool

        时间复杂度：这个不太容易算出来，我测试了几组数据，num -> while循环次数：16->3, 25->3, 529->6, 459684->12, 31741956->13
                  从中可发现，牛顿迭代法的时间复杂度接近O(1)
        空间复杂度：O(1)
        """
        val = num

        while val * val > num:
            # 依然采用从x坐标轴右侧逼近真实值的做法，循环结束的条件是val * val <= num，因此判断val * val 是否等于 num即可
            val = (val + num / val) / 2

        return val * val == num

    def is_perfect_square3(self, num):
        """
        :type num: int
        :rtype: bool

        对num求平方根、取整、求平方，如果最终值与num相同则表示num为完全平方数
        如果num为非完全平方数，则求出的平方根为float数，取整后再求平方的值一定是小于num的值

        时间复杂度：O(1)
        空间复杂度：O(1)
        """
        res = False

        if int(num ** .5) ** 2 == num:
            res = True

        return res

