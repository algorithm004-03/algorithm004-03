from collections import defaultdict
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList or not endWord or not beginWord or not wordList:
            return 0

        L = len(beginWord)

        # 生成更改一次字母后的所有word字母组合
        all_combo_dict = defaultdict(list)
        # 遍历词表中的每个word
        for word in wordList:
            for i in range(L):
                all_combo_dict[word[:i] + "*" + word[i+1:]].append(word)

        # 创建广度优先搜索的队列
        queue = [(beginWord, 1)]
        # 处理过的单词加入到集合中，确保不会处理相同的单词
        visited = {beginWord: True}
        while queue:
            current_word, level = queue.pop(0)      
            for i in range(L):
                # Intermediate words for current word
                # 当前单词的中间单词
                intermediate_word = current_word[:i] + "*" + current_word[i+1:]

                # 所有单词共享同一个中间状态
                # 使用当前单词的中间状态查询出来，对应的所有单词列表，遍历列表
                for word in all_combo_dict[intermediate_word]:
                    # 如果单词是结尾单词，则返回
                    if word == endWord:
                        print(all_combo_dict)
                        return level + 1
                    # 如果没有被访问过则加入到队列中，
                    if word not in visited:
                        visited[word] = True
                        queue.append((word, level + 1))
                # 处理掉的单词清空
                all_combo_dict[intermediate_word] = []
        return 0
