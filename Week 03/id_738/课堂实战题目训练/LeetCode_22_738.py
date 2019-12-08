class Solution(object):
    def generateParenthesis(self, n):
        """
        括号生成：https://leetcode-cn.com/problems/generate-parentheses/#/description

        :type n: int
        :rtype: List[str]
        """
        # DFS
        # def dfs(l_num, r_num, s, n = n):
        #     if len(s) == n * 2:
        #         self.result.append(s)
        #         return
        #     if l_num < n:
        #         dfs(l_num + 1, r_num, s + '(')
        #     if r_num < l_num and r_num < n:
        #         dfs(l_num, r_num + 1, s + ')')
        # self.result = []
        # dfs(1, 0, '(')
        # return self.result

        # BFS
        queue = [(1, 0, '(')]
        result = []
        while queue:
            l_num, r_num, cur = queue.pop(0)
            if len(cur) == n * 2:
                result.append(cur)
                continue
            if l_num < n:
                queue.append((l_num + 1, r_num, cur + '('))
            if r_num < n and r_num < l_num:
                queue.append((l_num, r_num + 1, cur + ')'))
        return result

        
        
        
        
        
        
        
        
        
        
        
        