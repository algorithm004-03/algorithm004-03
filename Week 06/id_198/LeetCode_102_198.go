package leetcode

// Trie Implement a trie
type Trie struct {
	val      rune
	isEnd    bool
	children []Trie
}

/** Initialize your data structure here. */
func Constructor() Trie {

	return Trie{}
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string) {

	chars := []rune(word)
	curr := this
	for i := 0; i < len(chars); i++ {

		if curr.children == nil {

			curr.children = make([]Trie, 26)
		}
		idx := int(chars[i]) - 97
		curr.children[idx].val = chars[i]
		curr = &curr.children[idx]
	}
	curr.isEnd = true
}

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {

	chars := []rune(word)
	curr := this
	i := 0
	for ; i < len(chars); i++ {

		idx := int(chars[i]) - 97
		if curr.children == nil || curr.children[idx].val != chars[i] {
			return false
		}
		curr = &curr.children[idx]

	}
	return curr.isEnd
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {

	chars := []rune(prefix)
	curr := this
	i := 0
	for ; i < len(chars); i++ {

		idx := int(chars[i]) - 97
		if curr.children == nil || curr.children[idx].val != chars[i] {
			return false
		}
		curr = &curr.children[idx]

	}
	return true
}
