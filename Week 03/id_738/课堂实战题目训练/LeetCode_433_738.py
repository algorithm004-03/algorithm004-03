class Solution(object):
    def minMutation(self, start, end, bank):
        """
        最小基因变化：https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description

        :type start: str
        :type end: str
        :type bank: List[str]
        :rtype: int
        """
        # BFS 代码写法1
        # change = {
        #     'A': ['C', 'G', 'T'],
        #     'C': ['A', 'G', 'T'],
        #     'G': ['C', 'A', 'T'],
        #     'T': ['C', 'G', 'A']
        # }
        # step = 0
        # queue = [start]
        # while queue:
        #     curs = []
        #     while queue:
        #         cur = queue.pop()
        #         if cur == end: return step
        #         curs.append(cur)
        #     step += 1
        #     for cur in curs:
        #         for i in range(len(cur)):
        #             for c in change[cur[i]]:
        #                 new = cur[:i] + c + cur[i + 1:]
        #                 if new in bank:
        #                     queue.append(new)
        #                     bank.remove(new)
        # return -1

        # BFS 代码写法2
        # change = {'A': 'TCG', 'T': 'ACG', 'C': 'ATG', 'G': 'ATC'}
        # bank = set(bank)
        # q = [(start, 0)]
        # while q:
        #     node, level = q.pop(0)
        #     if node == end:
        #         return level
        #     for i, val in enumerate(node):
        #         c = change[val]
        #         for j in c:
        #             new = node[:i] + j + node[i + 1:]
        #             if new in bank:
        #                 q.append((new, level + 1))
        #                 bank.remove(new)
        # return -1   
    
        # DFS
        change = {'A': 'TCG', 'T': 'ACG', 'C': 'ATG', 'G': 'ATC'}
        def dfs(level, cur, bank = bank, pre_chenge_index = -1):
            if cur == end:
                if self.min_step == -1 or self.min_step > level:
                    self.min_step = level
            # 标准库里面的都已经visited了，那么表示不可达
            if not bank:
                return
            for i in range(len(cur)):
                # 这里是一个剪枝优化，如果上一层处理的位置，在本层是不需要处理的，因为上一层有后续循环会处理，这一层的Level肯定比上一层的大
                if i == pre_chenge_index:
                    continue
                for c in change[cur[i]]:
                    new = cur[:i] + c + cur[i + 1:]
                    if new in bank:
                        # 标准库中已经visited的元素，如果不移除，下次如果重复到达这个状态，还是会重复走一样的路
                        bank.remove(new)
                        dfs(level + 1, new, bank, i)
                        # 恢复现场进入下个循环
                        bank.append(new)
        self.min_step = -1
        dfs(0, start)
        return self.min_step
        
    
    
    
    
    
    
                        
                        
                        
                        