class Solution:
    def trap(self, height):
        # 总面积
        area = 0
        # 栈，储存索引
        stack = []
        # 循环 height
        for i in range(len(height)):
            # 直到当前墙的高度不大于栈顶高度或者栈空
            while stack and height[i] > height[stack[-1]]:
                # 出栈高度
                deep = stack.pop()
                # 如果是 __| 这样的情况，出栈空
                if not stack:
                    break
                area += (min(height[i], height[stack[-1]]) - height[deep]) * (i - stack[-1] - 1)
            # 当前高度小于栈顶高度入栈
            stack.append(i)
        return area


s = Solution()
print(s.trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]))
