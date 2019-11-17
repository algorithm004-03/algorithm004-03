#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: search_2d_matrix.py
    @time: 2019/11/3 08:38
"""


class Solution(object):
    """
        编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
        1. 每行中的整数从左到右按升序排列。
        2. 每行的第一个整数大于前一行的最后一个整数。

        示例 1:
        输入:
        matrix = [
          [1,   3,  5,  7],
          [10, 11, 16, 20],
          [23, 30, 34, 50]
        ]
        target = 3
        输出: true

        示例 2:
        输入:
        matrix = [
          [1,   3,  5,  7],
          [10, 11, 16, 20],
          [23, 30, 34, 50]
        ]
        target = 13
        输出: false
    """

    def search_matrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool

        暴力破解：将二维数组转成一维有序数组，然后使用二分查找判断target是否在其中
        时间复杂度：遍历二维数组O(m*n)，二分查找O(log(m*n))，因此最终的时间复杂度为O(m*n)
        空间复杂度：O(m*n)
        """
        elems = [e for row in matrix for e in row]

        def search():
            left, right = 0, len(elems) - 1

            while left <= right:
                mid = left + (right - left) / 2

                if elems[mid] == target:
                    return True
                elif elems[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1

            return False

        return search()

    def search_matrix2(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool

        分析：
        1. 先用二分查找确定target会出现在哪一行
        2. 在那个行中，再用二分查找判断target是否在其中

        时间复杂度：判断target在哪个行的操作是O(logm)，如果确定具体的行，然后在该行中查找target的操作是O(logn)；因此时间复杂度为
                  O(logm) + O(logn)
        空间复杂度：O(1)
        """
        left, right, res = 0, len(matrix) - 1, False

        while left <= right:
            mid = left + (right - left) / 2

            if not matrix[mid]:
                # 当前行为[]
                break

            if matrix[mid][0] < target < matrix[mid][-1]:
                # 在这一行中查找
                low, high = 0, len(matrix[mid]) - 1

                while low <= high:
                    m = low + (high - low) / 2

                    if matrix[mid][m] == target:
                        res = True
                        break
                    elif matrix[mid][m] < target:
                        low = m + 1
                    else:
                        high = m - 1
                break
            elif target in [matrix[mid][0], matrix[mid][-1]]:
                res = True
                break
            elif target < matrix[mid][0]:
                right = mid - 1
            else:
                left = mid + 1

        return res

    def search_matrix3(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool

        把二维矩阵看成是有序的一维数组，再有序数组进行标准的二分查找。当需要获取一维数组中mid索引的值时，
        由于一维数组索引index对应二维矩阵的 row = index / n, col = index % n；因此能够方便的获取
        二维矩阵中的值与target进行比较

        时间复杂度：O(log(m*n))
        空间复杂度：O(1)
        """
        if not matrix:
            return False

        n = len(matrix[0])  # 获取矩阵列数
        left, right = 0, len(matrix) * n - 1

        while left <= right:
            mid = left + (right - left) / 2
            val = matrix[mid / n][mid % n]

            if val == target:
                return True
            elif val < target:
                left = mid + 1
            else:
                right = mid - 1

        return False

