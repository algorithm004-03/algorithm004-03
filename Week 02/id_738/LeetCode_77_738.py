class Solution(object):
    def combine(self, n, k):
        """
        组合：https://leetcode-cn.com/problems/combinations/submissions/

        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        #初解：这样写感觉浪费了太多空间还有复制数组的操作
#         def recombine(n_list, k, s):
#             if k < 1:
#                 self.result.append(s[: -1].split(','))
#                 return
#             tmp_s = s
#             for index in range(len(n_list)):
#                 s = tmp_s
#                 s += str(n_list[index]) + ','
#                 recombine(n_list[index + 1:], k - 1, s)
                
#         if n < k:
#             return []
#         if n == k:
#             return [[i for i in range(1, n + 1)]]
#         self.result = []
#         n_list = [i for i in range(1, n + 1)]
#         recombine(n_list, k, '')
#         return self.result
    
        #优化初解：
        #1. 将recombine的s参数改成List, 在recombine后，对进行pop操作还原现场，进入下个循环
        #2. recombine的n_list参数原来为list，每次进入recombine都要复制多一份list，改成头个元素值就可以不用复制数组了
        #3. recombine的参数k只是用来作为终结者条件，而k是全局变量且不需要改变其值，可以去掉参数k，并结合2的优化，修改终结者判断条件
        def recombine(first = 1, s = []):
            if len(s) == k:
                #这里要复制出来，否则s的pop操作会清空s
                self.result.append(s[:])
                return
            for i in range(first, n + 1):
                s.append(i)
                recombine(i + 1, s)
                s.pop()
                
        if n < k:
            return []
        if n == k:
            return [[i for i in range(1, n + 1)]]
        self.result = []
        recombine()
        return self.result
        
        
        
        
        
    
    
    