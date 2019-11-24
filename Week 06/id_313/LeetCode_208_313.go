package id_313

type Trie struct {
	val    byte
	childs [26]*Trie
	end    int
}

/** Initialize your data structure here. */
func Constructor() Trie {
	return Trie{}
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string) {
	node := this
	size := len(word)
	for i := 0; i < size; i++ {
		idx := word[i] - 'a'
		if node.childs[idx] == nil {
			node.childs[idx] = &Trie{val: word[i]}
		}
		node = node.childs[idx]
	}
	node.end++
}

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	node := this
	size := len(word)
	for i := 0; i < size; i++ {
		idx := word[i] - 'a'
		if node.childs[idx] == nil {
			return false
		}
		node = node.childs[idx]
	}
	if node.end > 0 {
		return true
	}
	return false
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	node := this
	size := len(prefix)
	for i := 0; i < size; i++ {
		idx := prefix[i] - 'a'
		if node.childs[idx] == nil {
			return false
		}
		node = node.childs[idx]
	}
	return true
}
