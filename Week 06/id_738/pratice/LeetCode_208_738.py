class Trie(object):
    """
    实现Trie树：https://leetcode-cn.com/problems/implement-trie-prefix-tree/
    """

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.trie = {}
        self.end_of_word = '#'
        

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        node = self.trie
        for c in word:
            node = node.setdefault(c, {})
        node[self.end_of_word] = self.end_of_word
        

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        node = self.trie
        for w in word:
            if w not in node:
                return False
            node = node[w]
        return self.end_of_word in node
        

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        node = self.trie
        for w in prefix:
            if w not in node:
                return False
            node = node[w]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)