class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        搜索二维矩阵：https://leetcode-cn.com/problems/search-a-2d-matrix/
        
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        # 二分查找：直接二分查找
        if not matrix or not matrix[0]:
            return False
        
        height = len(matrix)
        width = len(matrix[0])
        left, right = 0, height * width - 1
        while left <= right:
            mid = (left + right) // 2
            val = matrix[mid // width][mid % width]
            if val == target:
                return True
            elif val < target:
                left = mid + 1
            else:
                right = mid - 1
        return False
            
        
        # 二分查找1：先找出在哪一行进行二分，再二分
#         def b(nums):
#             left, right = 0, len(nums) - 1
#             while left <= right:
#                 mid = (left + right) >> 1
#                 if nums[mid] == target:
#                     return True
#                 if nums[mid] < target:
#                     left = mid + 1
#                 if nums[mid] > target:
#                     right = mid - 1
#             return False
        
#         if not matrix or not matrix[0]:
#             return False
        
#         first_list = [matrix[i][0] for i in range(len(matrix))]
#         # 第几行查找
#         s = 0
#         for i in range(len(first_list)):
#             if first_list[i] == target:
#                 return True
#             if i + 1 > len(first_list) - 1 or first_list[i] < target < first_list[i + 1]:
#                 s = i
#                 break
#         return b(matrix[s])
        
        
        
        
        
        
        
        
        
        
        