class Solution(object):
    def relativeSortArray(self, arr1, arr2):
        """
        数组的相对排序：https://leetcode-cn.com/problems/relative-sort-array/

        :type arr1: List[int]
        :type arr2: List[int]
        :rtype: List[int]
        """
        # 使用计数排序
        tmp = [0 for _ in range(1001)]
        result = []
        # 通过计数法，将arr1中的元素进行计数
        for num in arr1:
            tmp[num] += 1
        # 按照arr2的元素的顺序，依次输出tmp中的元素
        for num in arr2:
            while tmp[num] > 0:
                result.append(num)
                tmp[num] -= 1
        # 对不在arr2中的元素进行输出
        for i in range(1001):
            while tmp[i] > 0:
                result.append(i)
                tmp[i] -= 1
        return result










