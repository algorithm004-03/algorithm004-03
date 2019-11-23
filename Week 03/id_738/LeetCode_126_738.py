class Solution(object):
    def findLadders(self, beginWord, endWord, wordList):
        """
        单词接龙2：https://leetcode-cn.com/problems/word-ladder-ii/description/

        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: List[List[str]]
        """
        # BFS，写法1：
        #从开始到结尾逐层探索
        wordList = set(wordList)
        layer = {}
        #因为一个单词节点到达可能为多个路径，所以这里用二维数组
        #layer只存储当前探索层的单词
        layer[beginWord] = [[beginWord]]
        result = []
        #下面一层一层探索，直到探索到layer的key等于endWord终止，此key对应的value列表为最终结果
        #探索一层后，要将layer更新为下一层的单词
        #直到layer没有单词，终止
        while layer:
            newlayer = collections.defaultdict(list)
            #对layer的每个单词进行下探一层
            for w in layer:
                if w == endWord:
                    #此时找到最短路径，将最短路径的节点列表添加到result列表里面，因为最短路径的节点列表为列表，所以用extend
                    result.extend(k for k in layer[w])
                else:
                    #还没到达终点，那么对这个单词进行逐位替换，变为下一层的节点
                    for i in range(len(w)):
                        for c in 'abcdefghijklmnopqrstuvwxyz':
                            neww = w[:i] + c + w[i + 1:]
                            if neww in wordList:
                                #这句话就是将这一层的单词的路径列表每个都加上下一层的单词，作为下一层单词的可达路径
                                newlayer[neww].extend(k + [neww] for k in layer[w])
                                # newlayer[neww] += [k + [neww] for k in layer[w]]
            #探索过的单词，从wordList中移除，防止重复踩点
            wordList -= set(newlayer.keys())
            layer = newlayer

        return result
##########################################################################################################

        # 单向BFS：写法2
        queue = [beginWord]
        wordList = set(wordList)
        visited = collections.defaultdict(list)
        visited[beginWord] = [[beginWord]]
        while queue:
            curs = []
            while queue:
                n = queue.pop()
                if n == endWord:
                    return visited[n]
                curs.append(n)
            for cur in curs:
                for i in range(len(cur)):
                    for k in "abcdefghijklmnopqrstuvwxyz":
                        if k == cur[i]:
                            continue
                        new  = cur[:i] + k + cur[i + 1:]
                        if new in wordList:
                            visited[new].extend([p + [new] for p in visited[cur]])
                            if new not in queue:
                                queue.append(new)
            wordList -= set(queue)
        return []

##########################################################################################################


        # BFS双向求解
        if endWord not in wordList: 
            return []

        forward = {beginWord}
        backward = {endWord}
        wordList = set(wordList)
        dic = collections.defaultdict(set)

        flag = True
        letters = set('qwertyuioplkjhgfdsazxcvbnm')
        length = len(endWord)

        while forward:
            if len(forward) > len(backward):
                forward, backward, flag = backward, forward, not flag
            cur = set()
            wordList -= forward
            for word in forward:
                for idx in range(length):
                    x,y = word[:idx],word[idx + 1:]
                    for letter in letters:
                        temp = x + letter + y
                        if temp in wordList:
                            cur.add(temp)
                            if flag: dic[temp].add(word)
                            else: dic[word].add(temp)
            if cur & backward:
                res = [[endWord]]
                while res[0][0] != beginWord:
                    res = [[x] + y for y in res for x in dic[y[0]]]
                return res
            forward = cur
        return []
        
        


