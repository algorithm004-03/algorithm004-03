"""
第二周第一题
https://leetcode-cn.com/problems/trapping-rain-water/solution/
"""
class Solution_1:
    # 动态规划
    def trap(self,height):
        if not height:
            return 0
        n = len(height)
        max_left = [0] * n
        max_right = [0] * n
        max_left[0] = height[0]
        max_right[-1] = height[-1]
        for i in range(1,n):
            max_left[i] = max(height[i],max_left[i-1])
        for i in range(n-2,-1,-1):
            max_right[i] = max(height[i],max_right[i+1])
        res = 0
        for i in range(n):
            res += min(max_left[i],max_right[i])-height[i]
        return res

class Solution_2:
    # 栈来实现
    def trap(self,height):
        if not height:
            return 0
        n = len(height)
        stack = []
        res = 0
        for i in range(n):
            while stack and height[stack[-1]] < height[i]:
                tmp = stack.pop()
                if not stack:
                    break
                res += (min(height[i],height[stack[-1]])-height[tmp]) * (i-stack[-1]-1)
            stack.append(i)
        return res