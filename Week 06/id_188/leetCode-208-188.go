//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树

//leetcode submit region begin(Prohibit modification and deletion)
type Trie struct {
	value    string
	children map[string]*Trie
	isWord   bool
}

/** Initialize your data structure here. */
func Constructor() Trie {
	return Trie{value: "", children: make(map[string]*Trie), isWord: false}
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string) {
	root := this
	for _, w := range word {
		n := root.match(string(w))
		if n == nil {
			newNode := &Trie{value: string(w), children: make(map[string]*Trie)}
			root.children[string(w)] = newNode
			root = root.children[string(w)]
		} else {
			root = n
		}
	}
	root.isWord = true
}

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	if n := this.match(word); n != nil && n.isWord {
		return true
	} else {
		return false
	}
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	if n := this.match(prefix); n != nil {
		return true
	} else {
		return false
	}
}

func (this *Trie) match(word string) *Trie {
	root := this
	for _, w := range word {
		//node := &Trie{value:string(w), children:make(map[string]*Trie)}
		if _, ok := root.children[string(w)]; ok {
			root = root.children[string(w)]
		} else {
			return nil
		}
	}
	return root
}

/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
