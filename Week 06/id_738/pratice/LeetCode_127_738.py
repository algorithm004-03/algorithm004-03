class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        单词接龙: https://leetcode-cn.com/problems/word-ladder/submissions/

        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        # 双向BFS
        wordList = set(wordList)
        if endWord not in wordList:
            return 0
        head = {beginWord}
        tail = {endWord}
        step = 0
        while head:
            step += 1
            next_head = set()
            for word in head:
                for i in range(len(word)):
                    for c in "abcdefghijklmnopqrstuvwxyz":
                        new_w = word[:i] + c + word[i + 1:]
                        if new_w in tail:
                            return step + 1
                        if new_w in wordList:
                            next_head.add(new_w)
                            wordList.remove(new_w)
            head = next_head
            # 选择少的节点进行扩散，这样效率会更高
            if len(head) > len(tail):
                head, tail = tail, head
        return 0


##############################################################################
        # 单向BFS
        step = 0
        queue = [beginWord]
        m = collections.defaultdict(list)
        # 过滤出wordList每个单词，能到达该单词的原来的词的特点
        for word in wordList:
            for i in range(len(word)):
                m[word[:i] + '*' + word[i + 1:]].append(word)
        # wordList一个单词可能加入到m的多个映射中，对于已经扩散到的单词，最短路径就是第一次扩散到的时候，所以在搜索的时候，要排除已经第一次扩散到的单词，剪枝加快速度
        visited = set()
        while queue:
            step += 1
            l = []
            while queue:
                n = queue.pop()
                if n == endWord:
                    return step
                l.append(n)
            for w in l:
                for i in range(len(w)):
                    _w = w[:i] + '*' + w[i + 1:]
                    for new_w in m[_w]:
                        if new_w not in visited:
                            visited.add(new_w)
                            queue.append(new_w)
                    m[_w] = []
        return 0











