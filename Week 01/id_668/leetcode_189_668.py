#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: rotate_array.py
    @time: 2019/10/17 20:14
"""


class Solution(object):
    """
        给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

        示例 1:
        输入: [1,2,3,4,5,6,7] 和 k = 3
        输出: [5,6,7,1,2,3,4]
        解释:
        向右旋转 1 步: [7,1,2,3,4,5,6]
        向右旋转 2 步: [6,7,1,2,3,4,5]
        向右旋转 3 步: [5,6,7,1,2,3,4]

        示例 2:
        输入: [-1,-100,3,99] 和 k = 2
        输出: [3,99,-1,-100]
        解释:
        向右旋转 1 步: [99,-1,-100,3]
        向右旋转 2 步: [3,99,-1,-100]


        说明:
        尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
        要求使用空间复杂度为 O(1) 的 原地 算法。

        分析：题目中是要求将数组中的元素向右移动k个位置，首先想到的是需要对k进行数组长度的求模运算，
        若k值很大，则对数组元素移动套圈是没有必要的，比如数组长度为7，这里移动8个位置和移动1个位置
        是等价的。其次从题目中的解释来看，想到将元素移动一步作为一个操作单元，然后做k个步骤的操作，
        这是一个思路，对应了如下的1、2两个实现方法。反转元素的做法是别的地方提示的一点思路。
        题解中环状替换的解法其实自己是首先想到的，但由于实现没成功，所以觉得这种方法可能不会成功，
        后来看题解讲到了这个方法，所以觉得有必要自己再重新分析，重新求解。所以这个环状替换解法后面再补充上，
        这个地方自己有点跟自己较劲。
    """

    def rotate1(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.

        时间复杂度：O(k * n)
        空间复杂度：O(1)
        """
        k %= len(nums)

        while k > 0:
            pre = nums[len(nums) - 1]

            for i in range(len(nums)):
                nums[i], pre = pre, nums[i]

            k -= 1

    def rotate2(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        
        时间复杂度：O(k * n)
        空间复杂度：O(1)
        """
        k %= len(nums)

        while k > 0:
            e = nums.pop()
            nums.insert(0, e)

            k -= 1

    def rotate3(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.

        时间复杂度：O(n)
        空间复杂度：O(1)
        """

        def reverse(a, i, j):
            """
                数组反转操作
                a：数组
                i：起始索引
                j：终止索引
            """
            while i < j:
                a[i], a[j] = a[j], a[i]
                i += 1
                j -= 1

        k %= len(nums)
        reverse(nums, 0, len(nums) - 1)
        reverse(nums, 0, k - 1)
        reverse(nums, k, len(nums) - 1)

