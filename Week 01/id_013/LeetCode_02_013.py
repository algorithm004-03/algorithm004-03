'''
第三课第二题
189. 旋转数组
https://leetcode-cn.com/problems/rotate-array/
'''
class Solution_1:
    """
    解法：遍历移位，很直观的解法，时间复杂度为O(k*n)
    """
    def rotate(self,nums,k):
        for i in range(k):
            last = nums[-1]
            for j in range(len(nums)-1,0,-1):
                nums[j] = nums[j-1]
            nums[0] = last


class Solution_2:
    """
    解法：数组整体后移
    """
    def rotate(self,nums,k):
        k %= len(nums)
        nums[:] = nums[-k:] + nums[:-k]