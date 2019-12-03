#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: 56_merge_intervals.py
    @time: 2019/11/30 17:08
"""


class Solution(object):
    """
        给出一个区间的集合，请合并所有重叠的区间。

        示例 1:
        输入: [[1,3],[2,6],[8,10],[15,18]]
        输出: [[1,6],[8,10],[15,18]]
        解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

        示例 2:
        输入: [[1,4],[4,5]]
        输出: [[1,5]]
        解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

    """

    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        if len(intervals) == 0:
            return []

        intervals = sorted(intervals, key=lambda e: e[0])  # 因为每个区间并不是按照区间首元素递增的，因此这里首先按区间首字母排序
        res = [intervals[0]]

        for interval in intervals[1:]:
            if interval[0] <= res[-1][-1]:  # 如果当前区间首元素<=已有序结果res中最后一个区间的尾元素，则此时需要合并区间
                res[-1][-1] = max(interval[-1], res[-1][-1])
            else:
                res.append(interval)

        return res

