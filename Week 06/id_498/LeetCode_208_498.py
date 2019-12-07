class Trie:
    """
    插入，搜索，前缀
    """

    def __init__(self):
        """
        在这里初始化数据结构。
        Initialize your data structure here.
        """
        # 根
        self.root = {}
        self.end_of_word = '#'

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        # 实例化
        node = self.root
        # 把每个新字母都对应一个新字典
        for char in word:
            node = node.setdefault(char, {})
        # 最后加入 #
        node[self.end_of_word] = self.end_of_word

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node = self.root
        for char in word:
            # 如果字符在节点里
            if char not in node:
                return False
            # 下一层
            node = node[char]
        # 返回是否到末尾
        return self.end_of_word in node

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        node = self.root
        for char in prefix:
            # 如果字符在节点里
            if char not in node:
                return False
            # 下一层
            node = node[char]
        # 没有末尾符号
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
