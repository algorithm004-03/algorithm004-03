class Solution(object):
    def generateParenthesis(self, n):
        """
        括号生成：https://leetcode-cn.com/problems/generate-parentheses/#/description

        :type n: int
        :rtype: List[str]
        """
        # 动态规划 / 高级搜索
        # 设i为括号的对数
        # 那么 思考:i对括号的有效组合 和i - 1 对括号的所有有效组合有什么关系呢
        # 观察到: i对括号和i - 1对括号有如下关系:
        # '(' + 'p对括号的组合' + ')' + 'q对括号的组合' {p + q = i - 1}
        # 所有可以从i = 0和i = 1对括号组合算起，根据上面"公式"计算出i = 2...n对括号的组合
        result = []
        result.append(['']) # i == 0
        result.append(['()']) # i == 1
        #计算i == 2到n
        for i in range(2, n + 1):
            l = []
            for p in range(i): 
                a = result[p] # p对括号所有组合
                b = result[i - p - 1] # q对括号所有组合
                for p in a:
                    for q in b:
                        l.append('(' + p + ')' + q)
            result.append(l)
        return result[n]

###########################################################3
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
###########################################################3
        # BFS
        # queue = [(1, 0, '(')]
        # result = []
        # while queue:
        #     l_num, r_num, cur = queue.pop(0)
        #     if len(cur) == n * 2:
        #         result.append(cur)
        #         continue
        #     if l_num < n:
        #         queue.append((l_num + 1, r_num, cur + '('))
        #     if r_num < n and r_num < l_num:
        #         queue.append((l_num, r_num + 1, cur + ')'))
        # return result