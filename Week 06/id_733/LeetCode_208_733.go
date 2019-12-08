type Trie struct {
	nodes map[rune]*Trie
	isEnd bool
}


/** Initialize your data structure here. */
func Constructor() Trie {
	return Trie{}
}


/** Inserts a word into the trie. */
func (this *Trie) Insert(word string) {
	node := this
	for _, c := range word {
		if node.nodes != nil {
			if subNode, ok := node.nodes[c]; ok {
				node = subNode
				continue
			}
		} else {
			node.nodes = make(map[rune]*Trie)
		}

		newNode := Constructor()
		subNode := &newNode
		node.nodes[c] = subNode
		node = subNode
	}

	node.isEnd = true
}


/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	node, ok := this.getEndNode(word)
	return ok && node.isEnd
}


/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	_, ok := this.getEndNode(prefix)
	return ok
}


func (this *Trie) getEndNode(text string) (*Trie, bool) {
	node := this
	for _, c := range text {
		if subNode, ok := node.nodes[c]; ok {
			node = subNode
		} else {
			return nil, false
		}
	}

	return node, true
}



/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */
