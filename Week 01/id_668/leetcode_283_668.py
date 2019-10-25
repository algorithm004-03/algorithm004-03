#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: move_zero.py
    @time: 2019/10/19 19:28
"""


class Solution(object):
    """
        给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

        示例:

        输入: [0,1,0,3,12]
        输出: [1,3,12,0,0]
        说明:

        必须在原数组上操作，不能拷贝额外的数组。
        尽量减少操作次数

        分析：对数组类型的题目，自己首先考虑的是使用双指针法，题目中又规定不能使用额外的数组，因此
        空间换时间的做法也就无法使用了。
    """

    def move_zeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.

        这是自己实现的交换元素的做法，i指针标示第一个0元素所在的位置，当前元素0做完交换操作后，
        i则继续往下寻找0元素的位置，指针j正常遍历数组，遇到不为0的元素则与i位置进行交换。重复
        操作，直到遍历结束。
        时间复杂度：O(n)
        空间复杂度：O(1)
        """
        i = None

        for j in range(len(nums)):
            if nums[j] == 0:
                if i is None:
                    i = j
            else:
                # 不为0的元素，参与元素交换
                if i is not None:
                    nums[i], nums[j], i = nums[j], nums[i], i + 1

                    while i <= j:
                        if nums[i] == 0:
                            # 交换完成后，则继续寻找下一个0元素的位置
                            break

                        i += 1

    def move_zeroes2(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.

        这是leetcode上比较好的写法，处理的特别巧妙，因此代码才会如此简洁。觉得唯一不好的地方是
        元素交换不仅会在0与非0之间，也会发生在非0与非0之间，因此这个处理有点冗余。所以下一个方法
        的改进之处是只让元素交换发生在0与非0之间。经过大量测试发现，这个方法的实现效率低于方法1与
        方法3。
        时间复杂度：O(n)
        空间复杂度：O(1)
        """
        zero = 0

        for i in range(len(nums)):
            if nums[i] != 0:
                nums[i], nums[zero] = nums[zero], nums[i]
                zero += 1

    def move_zeroes3(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.

        对方法2的改进，使得元素交换的操作只发生在0与非0之间
        时间复杂度：O(n)
        空间复杂度：O(1)
        """
        zero = 0

        for i in range(len(nums)):
            if nums[i] != 0:
                if i != zero:
                    # 交换只发生在0与非0之间
                    nums[i], nums[zero] = nums[zero], nums[i]

                zero += 1

