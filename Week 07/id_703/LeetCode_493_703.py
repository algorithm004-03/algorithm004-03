#
# @lc app=leetcode.cn id=493 lang=python3
#
# [493] 翻转对
#

# @lc code=start
class Solution:
    def reversePairs(self, nums: List[int]) -> int:
        def helper(nums,l,r):
            if r == l:
                return 0
            m = l + 1 + (r-l)//2
            L = helper(nums,l,m-1) 
            R = helper(nums,m,r) 
    
            i = l
            j = m
            ans = L + R
            nums[l:m] = sorted(nums[l:m])
            nums[m:r+1] = sorted(nums[m:r+1])
            while i < m and j <= r:
                if nums[i] > 2*nums[j]:  
                    ans += m - i
                    j += 1
                else:
                    i += 1
            return ans
        if not nums:
            return 0
        else:
            return helper(nums,0,len(nums)-1)


# @lc code=end

