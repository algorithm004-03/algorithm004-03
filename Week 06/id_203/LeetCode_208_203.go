package week06

/**
实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

示例:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");
trie.search("app");     // 返回 true
说明:

你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

type Trie struct {
	val  byte
	sons [26]*Trie
	end int
}

/** Initialize your data structure here. */
func Constructor() Trie {
	var xx Trie
	return xx
}

/** Inserts a word into the trie. */
func (tr *Trie) Insert(word string)  {
	root:=tr
	for i:=0;i<len(word);i++{
		if root.sons[int(word[i])-int('a')]==nil{
			var zz Trie
			zz.val=word[i]
			root.sons[int(word[i])-int('a')]=&zz
		}else{
		}
		root=root.sons[int(word[i])-int('a')]
		if i==len(word)-1{
			(root.end)++
		}
	}
}

/** Returns if the word is in the trie. */
func (tr *Trie) Search(word string) bool {
	root:=tr
	for i:=0;i<len(word);i++{
		if root.sons[int(word[i])-int('a')]==nil{
			return false
		}
		root=root.sons[int(word[i])-int('a')]
		if i==len(word)-1&&root.end<=0{
			return false
		}
	}
	return true
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (tr *Trie) StartsWith(prefix string) bool {
	root:=tr
	for i:=0;i<len(prefix);i++{
		if root.sons[int(prefix[i])-int('a')]==nil{
			return false
		}
		root=root.sons[int(prefix[i])-int('a')]
	}
	return true
}



/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */
