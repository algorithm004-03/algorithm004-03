#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: sqrt.py
    @time: 2019/11/2 08:25
"""


class Solution(object):
    """
        实现 int sqrt(int x) 函数。
        计算并返回 x 的平方根，其中 x 是非负整数。
        由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

        示例 1:
        输入: 4
        输出: 2

        示例 2:
        输入: 8
        输出: 2
        说明: 8 的平方根是 2.82842...,
             由于返回类型是整数，小数部分将被舍去。

    """

    def mysqrt(self, x):
        """
        :type x: int
        :rtype: int

        遍历法，这里用的是xrange，xrange是个生成器，因此节省空间但效率不如range快；其次需要遍历的元素从0到sqrt(x)
        时间复杂度：O(sqrt(x))
        空间复杂度：O(1)
        """
        val = 0

        for i in xrange(x + 1):  # 这里不可用range函数，否则2147395599这个数会产生MemoryError
            if i * i <= x < (i + 1) * (i + 1):
                val = i
                break

        return val

    def mysqrt2(self, x):
        """
        :type x: int
        :rtype: int

        二分查找法
        时间复杂度：O(logx)，x的值大小，也即O(logn)
        空间复杂度：O(1)
        """
        l, r, mid = 0, x, 0

        while l <= r:
            mid = l + (r - l) / 2  # 这里不能用位运算，会超时
            square, square_one = mid * mid, (mid + 1) * (mid + 1)

            # 下面的逻辑判断，可通过画坐标法准确判断
            if square <= x < square_one:  # 关键是这一步的判断，因为只保留整数部分，所以x < (mid + 1) * (mid + 1)的取值都是mid
                break
            elif x < square:
                r = mid
            else:
                # 表示 x >= (mid + 1) * (mid + 1)
                l = mid + 1

        return mid

    def mysqrt3(self, x):
        """
        :type x: int
        :rtype: int

        牛顿迭代法
        f(x) = x * x - a 当f(x) = 0，即为求平方根

        时间复杂度：接近O(1)
        空间复杂度：O(1)
        """
        val = x  # 求解x的正实根，假设正实根val起始值为x

        while val * val > x:
            '''
                这种处理相当于是从曲线右侧远大于正解x的地方不断去逼近真实值x
                当逼近值刚好等于正解x或刚到正解值左侧，此时这个逼近值就是只需要整数部分的正实根
            '''
            val = (val + x / val) / 2

        return val

