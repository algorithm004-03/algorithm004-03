'''
第三课第一题
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
'''
class Solution_1:
    # 双指针遍历，遇到重复的删除第二个
    def removeDuplicates(self, nums):
        left= 0
        right = 1
        while right < len(nums):
            if nums[left] == nums[right]:
                nums.pop(right)
            else:
                right +=1
                left += 1
        return len(nums)
