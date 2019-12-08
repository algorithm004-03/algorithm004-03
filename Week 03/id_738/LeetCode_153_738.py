class Solution(object):
    def findMin(self, nums):
        """
        寻找旋转排序数组中的最小值：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
        
        :type nums: List[int]
        :rtype: int
        """
        # 二分法写法2
        # 先排除掉特殊数组，否则下面循环会越界错误
        if len(nums) ==  1 or nums[0] < nums[-1]:
            return nums[0]
            
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = (right + left) >> 1
            if nums[mid] < nums[mid - 1]:
                return nums[mid]
            if nums[mid] > nums[mid + 1]:
                return nums[mid + 1]
            if nums[0] > nums[mid]: # 左边乱序
                right = mid - 1
            elif nums[0] < nums[mid]: # 右边乱序
                left = mid + 1
                
        
###################################################

        # 二分法，写法1，判断mid左右两边哪一边是有序的，那么最小值肯定落在无序的一边
        # left, right = 0, len(nums) - 1
        # while left <= right:
        #     # 如果是left 和 right相邻的情况，那么不是left就是right
        #     if right - left == 1:
        #         return min(nums[left], nums[right])
        #     mid = (left + right) >> 1
        #     # 左边(含mid)无序，值在左边
        #     if nums[left] > nums[mid]:
        #         right = mid
        #     # 右边(含mid)无序，值在右边
        #     elif nums[right] < nums[mid]:
        #         left = mid
        #     # Mid,left,right重合
        #     elif left == right:
        #         return nums[mid]
        #     # 最后剩下nums[left] < nums[mid] < nums[right]的情况，明显就是一个没有被旋转的数组，直接返回left
        #     else:
        #         return nums[left]
            
###################################################
       
        # 直接解答。。平均时间复杂度最大O(n/2),
        # if not nums:
        #     return None
        # if nums[0] <= nums[-1]:
        #     return nums[0]
        # result = nums[0]
        # for n in nums:
        #     if result < n:
        #         continue
        #     result = n
        # return result
        