class Solution(object):
    def search(self, nums, target):
        """
        搜索旋转排序数组：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
        
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        # 直接二分查找
        # 解题关键:如何判断target在数组的左半部分还是右半部分
        # 一步一步分解，按不同情况移动left和right。思路完全清晰，但是代码if else比较多（不影响执行效率）
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid
            # 判断左右部分哪一部分是升序的
            if nums[0] < nums[mid]: # 左半部分是升序的
                if nums[0] <= target < nums[mid]: # target落在左半部分
                    right = mid - 1
                else:
                    left = mid + 1
            elif nums[0] > nums[mid]: # 右半部分是升序的
                if nums[mid] < target <= nums[-1]: # target落在右边部分
                    left = mid + 1
                else:
                    right = mid - 1
            else: # nums[0] == nums[mid]表示left为0，right为1
                if nums[left] == target:
                    return left
                elif nums[right] == target:
                    return right
                else:
                    return -1
        return -1
        
        # 二分查找写法2：这是别人题解的写法，思想和上面的一致，不过个人觉得思路难理解，步骤不清晰。
        # left, right = 0, len(nums) - 1
        # while left < right:
        #     if nums[0] <= nums[mid] and (target > nums[mid] or target < nums[0]):
        #         left = mid + 1
        #     elif target < nums[0] and target > nums[mid]:
        #         left = mid + 1
        #     else:
        #         right = mid
        # return left if left == right and nums[left] == target else -1
        

                
                
                
                
                
                
                
                
                
                
                
                
                
