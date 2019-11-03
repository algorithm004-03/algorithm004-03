class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        result = 0
        #暴力求解,提交超时
        #时间复杂度O(n^2)
        # for i in range(len(height)):
        #     max_left = max_right = 0 
        #     j = i
        #     while j >= 0:
        #         max_left = max(max_left, height[j])
        #         j -= 1
        #     j = i
        #     while j < len(height):
        #         max_right = max(max_right, height[j])
        #         j += 1
        #     result += (min(max_right, max_left) - height[i])
        # return result
        
        #考虑到每次计算元素最大容纳高度，每次都要扫描左右元素的最大值
        #其实扫描左边元素最大值可以依赖于前面元素得出的结果，只要比较之前元素最左边最大值和当前元素的大小，即可知道最大值，右边同理
        #所以用2个数组，存储已经扫描过的元素的左右两边最大值，数组的第i个元素的值依赖于数组第i-1个元素的值和第i个元素的值之间的最大值
        #时间复杂度O(3n)
        if not height:
            return 0
        max_left = [0] * len(height)
        max_right = [0] * len(height)
        max_left[0] = height[0]
        max_right[-1] = height[-1]
        length = len(height)
        result = 0
        for i in range(length):
            max_left[i] = max(max_left[i - 1], height[i])
        i = length - 2
        while i >= 0:
            max_right[i] = max(max_right[i + 1], height[i])
            i -= 1
        for i in range(length):
            result += min(max_left[i], max_right[i]) - height[i]
        return result
        
        #盛水容器的多少取决于左右两个最近的不相邻柱子，并且两个柱子之间的柱子不能高于这两个柱子
        #这种最近相关性问题可以用栈解决
        #时间复杂度O(n)
        # stack = []
        # result = 0
        # for i in range(len(height)):
        #     while stack and height[stack[-1]] < height[i]:
        #         top = stack.pop()
        #         if not stack:
        #             break
        #         width = i - stack[-1] - 1
        #         min_height = min(height[stack[-1]], height[i]) - height[top]
        #         result += width * min_height
        #     stack.append(i)
        # return result
        
        
        
        
        
        
        
        
            
            
            
        
        