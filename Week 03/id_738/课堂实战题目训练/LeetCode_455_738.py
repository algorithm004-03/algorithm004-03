class Solution(object):
    def findContentChildren(self, g, s):
        """
        分发饼干：https://leetcode-cn.com/problems/assign-cookies/description/
        
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """
        # 解法 - 写法1
        # result = 0
        # g.sort()
        # s.sort()
        # for i in g:
        #     while s and i > s[0]:
        #         s.pop(0)
        #     if s:
        #         s.pop(0)
        #         result += 1
        # return result
    
        # 解法 - 写法2
        result = 0
        g.sort()
        s.sort()
        i = 0
        j = 0
        while i < len(g) and j < len(s):
            if g[i] <= s[j]:
                result += 1
                i += 1
                j += 1
            else:
                j += 1
        return result
                
                
                
                
                
                
                
                
                
                
    