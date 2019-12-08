package id_313

type LRUCache struct {
	size    int
	HashMap map[int]*Node
	head    *Node
	tail    *Node
}

type Node struct {
	Key   int
	Value int
	pre   *Node
	next  *Node
}

func Constructor(capacity int) LRUCache {
	lru := LRUCache{size: capacity}
	lru.HashMap = make(map[int]*Node, capacity)
	return lru
}

func (this *LRUCache) Get(key int) int {
	if v, ok := this.HashMap[key]; ok {
		this.refreshNode(v)
		return v.Value
	}
	return -1
}

func (this *LRUCache) Put(key int, value int) {
	if v, ok := this.HashMap[key]; !ok {
		if len(this.HashMap) >= this.size {
			old := this.removeNode(this.head)
			delete(this.HashMap, old)
		}
		node := Node{Key: key, Value: value}
		this.addNode(&node)
		this.HashMap[key] = &node
	} else {
		v.Value = value
		this.refreshNode(v)
	}
}

func (this *LRUCache) refreshNode(node *Node) {
	if node == this.tail {
		return
	}
	this.removeNode(node)
	this.addNode(node)
}

func (this *LRUCache) removeNode(node *Node) int {
	if node == this.tail {
		this.tail = this.tail.pre
	} else if node == this.head {
		this.head = this.head.next
	} else {
		node.pre.next = node.next
		node.next.pre = node.pre
	}
	return node.Key
}

func (this *LRUCache) addNode(node *Node) {
	if this.tail != nil {
		this.tail.next = node
		node.pre = this.tail
		node.next = nil
	}
	this.tail = node
	if this.head == nil {
		this.head = node
	}
}
