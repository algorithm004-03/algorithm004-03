#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: lemonade_change.py
    @time: 2019/10/31 20:03
"""
from collections import defaultdict


class Solution(object):
    """
        在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
        顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
        每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
        注意，一开始你手头没有任何零钱。
        如果你能给每位顾客正确找零，返回 true ，否则返回 false 。

        示例 1：
        输入：[5,5,5,10,20]
        输出：true
        解释：
        前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
        第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
        第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
        由于所有客户都得到了正确的找零，所以我们输出 true。

        示例 2：
        输入：[5,5,10]
        输出：true

        示例 3：
        输入：[10,10]
        输出：false

        示例 4：
        输入：[5,5,10,10,20]
        输出：false
        解释：
        前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
        对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
        对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
        由于不是每位顾客都得到了正确的找零，所以答案是 false。

        提示：
        0 <= bills.length <= 10000
        bills[i] 不是 5 就是 10 或是 20

    """

    def lemonade_change(self, bills):
        """
        :type bills: List[int]
        :rtype: bool

        暴力破解
        """
        d = defaultdict(int)

        # 5, 10, 20
        for bill in bills:
            val = bill - 5

            if val == 0:
                # 5，直接往里添加
                d[bill] += 1
            elif val == 5:
                # 10，+10， -5
                d[bill] += 1
                d[5] -= 1

                if d[5] < 0:
                    return False
            else:
                # 20, 10+5, 5+5+5
                if d[10] > 0:
                    if d[5] < 1:
                        return False

                    d[10] -= 1
                    d[5] -= 1
                else:
                    if d[5] < 3:
                        return False

                    d[5] -= 3

        return True

    def lemonade_change2(self, bills):
        """
        :type bills: List[int]
        :rtype: bool

        改进官方题解答案
        """
        five = ten = 0

        for bill in bills:
            if bill == 10:
                ten += 1
                five -= 1
            elif bill == 20:
                if ten >= 1:
                    # 如果有10，才会使用10，所以在找零中对10的使用不会异常
                    ten -= 1
                    five -= 1
                else:
                    # 如果没有10，则直接去掉3个5找零
                    five -= 3
            else:
                five += 1

            if five < 0:
                return False

        return True

    def lemonade_change3(self, bills):
        """
        :type bills: List[int]
        :rtype: bool

        国际站高票
        """
        c = defaultdict(int)

        for bill in bills:
            if bill == 10:
                c[bill] += 1
                c[5] -= 1
            elif bill == 20:
                # 此处不添加20，因为20无法参与找零
                if c[10] >= 1:
                    c[10] -= 1
                    c[5] -= 1
                else:
                    c[5] -= 3
            else:
                c[bill] += 1

            if c[5] < 0:
                return False

        return True

