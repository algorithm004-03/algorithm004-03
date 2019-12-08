class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        单词接龙：https://leetcode-cn.com/problems/word-ladder/description/
        
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        # BFS-1:完全遍历替代每个位置为26个字母
        # wordList = set(wordList)
        # change = "abcdefghijklmnopqrstuvwxyz"
        # queue = [beginWord]
        # step = 0
        # while queue:
        #     step += 1
        #     curs = []
        #     while queue:
        #         n = queue.pop()
        #         if n == endWord:
        #             return step
        #         curs.append(n)
        #     for cur in curs:
        #         for i in range(len(cur)):
        #             for k in change:
        #                 c = cur[:i] + k + cur[i + 1:]
        #                 if c in wordList:
        #                     queue.append(c)
        #                     wordList.remove(c)
        # return 0
##########################################################################################################
        # BFS-2:单词的变换为不用26个字母，而是设置为*，代表这个位置的都可以变换为标准词库里的目标单词
        # 所以要初始化一下这个映射关系的map
        # change = collections.defaultdict(list)
        # L = len(endWord)
        # for word in wordList:
        #     for i in range(L):
        #         c = word[:i] + '*' + word[i + 1:]
        #         change[c].append(word)
        # queue = [beginWord]
        # step = 0
        # # visited做剪枝，访问过的节点，无需再重复访问，因为再重复访问step也是比之前的大
        # visited = set()
        # while queue:
        #     step += 1
        #     curs = []
        #     while queue:
        #         n = queue.pop()
        #         if n == endWord:
        #             return step
        #         curs.append(n)
        #     for cur in curs:
        #         for i in range(L):
        #             c = cur[:i] + '*' + cur[i + 1:]
        #             for new in change[c]:
        #                 if new not in visited:
        #                     visited.add(new)
        #                     queue.append(new)
        #                 change[c] = []
        # return 0  
##########################################################################################################
        # BFS-3:究极解法，双端BFS，写法1
        # 头部广度搜索，尾部广度搜索，头尾交替进行，头尾最近一次到达的节点如果有交集，那么就表示最短路径第一次出现
        
        # bfs每次下探一层
        # def bfs(level, queue, visited, vilid_visited):
        #     level += 1
        #     curs = []
        #     while queue:
        #         n = queue.pop()
        #         if n in vilid_visited:
        #             return level
        #         curs.append(n)
        #     for cur in curs:
        #         for i in range(L):
        #             c = cur[:i] + '*' + cur[i + 1:]
        #             for new in change[c]:
        #                 if new not in visited:
        #                     visited.add(new)
        #                     queue.append(new)
        #             change[c] = []
        
        # change = collections.defaultdict(list)
        # L = len(endWord)
        # for word in wordList:
        #     for i in range(L):
        #         c = word[:i] + '*' + word[i + 1:]
        #         change[c].append(word)
        
        # if endWord not in wordList:
        #     return 0
        # head = [beginWord]
        # end = [endWord]
        # head_level = 0
        # end_level = 0
        # head_visited = set()
        # end_visited = set()
        # while head and end:
        #     l =  bfs(head_level, head, head_visited, end_visited)
        #     if l: return l + end_level
        #     else: head_level += 1
        #     l =  bfs(end_level, end, end_visited, head_visited)
        #     if l: return l + head_level
        #     else: end_level += 1
        # return 0
##########################################################################################################
        # BFS-3:究极解法，双端BFS，写法2
        # 头部广度搜索，尾部广度搜索，头尾交替进行，头尾最近一次到达的节点如果有交集，那么就表示最短路径第一次出现
        # 时间空间复杂度比上面所有解法都低
        def visitWordNode(queue, visited, others_visited):
            level, current_word = queue.pop(0)
            for i in range(self.L):
                intermediate_word = current_word[:i] + "*" + current_word[i + 1:]
                for word in m[intermediate_word]:
                    if word in others_visited:
                        return level + others_visited[word]
                    if word not in visited:
                        visited[word] = level + 1
                        queue.append((level + 1, word))
            return None
        self.L = len(beginWord)
        m = collections.defaultdict(list)
        for word in wordList:
            for k in range(0, self.L):
                key = word[:k] + '*' + word[k + 1:]
                m[key].append(word)
        queue_tail = [(1, endWord)]
        queue_head = [(1, beginWord)]
        visited_head = {beginWord: 1}
        visited_tail = {endWord: 1}
        result = None
        if endWord not in wordList:
            return 0
        while queue_tail and queue_head:
            result = visitWordNode(queue_head, visited_head, visited_tail)
            if result:
                return result
            result = visitWordNode(queue_tail, visited_tail, visited_head)
            if result:
                return result
        return 0
##########################################################################################################
        # DFS 表示超出时间限制
#         def dfs(step, beginWord, endWord, wordList, last_index):
#             if beginWord == endWord:
#                 if self.min_step is None or self.min_step > step:
#                     self.min_step = step
#                     return
#             if not wordList:
#                 return
#             for i in range(len(beginWord)):
#                 if i != last_index:
#                     letter = beginWord[i]
#                     for change_letter in change[i]:
#                         if letter != change_letter:
#                             new = beginWord[:i] + change_letter + beginWord[i + 1:]
#                             if new in wordList:
#                                 wordList.remove(new)
#                                 # print(wordList)
#                                 # print(change)
#                                 dfs(step + 1, new, endWord, wordList, i)
#                                 wordList.add(new)
                    
#         #存储每个位置可以转换为的字母       
#         change = collections.defaultdict(set)
#         for letter in wordList:
#             for j in range(len(letter)):
#                 change[j].add(letter[j])
#         wordList = set(wordList)
#         self.min_step = None
#         dfs(0, beginWord, endWord, wordList, -1)
#         return 0 if not self.min_step else self.min_step + 1
            
        
        
        
