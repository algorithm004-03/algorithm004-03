type LRUCache struct {
	dict map[int]*cacheNode
	list *cacheList
	cap  int
}


func Constructor(capacity int) LRUCache {
	cache := LRUCache{}
	cache.dict = make(map[int]*cacheNode, capacity)
	cache.list = newCacheList()
	cache.cap = capacity
	return cache
}


func (this *LRUCache) Get(key int) int {
	node, ok := this.dict[key]
	if !ok {
		return -1
	}

	this.list.Remove(node)
	this.list.Insert(node)
	return node.Val
}


func (this *LRUCache) Put(key int, value int) {
	node, ok := this.dict[key]
	if ok {
		this.list.Remove(node)
	} else {
		if len(this.dict) == this.cap {
			least := this.list.RemoveEnd()
			delete(this.dict, least.Key)
		}

		node = &cacheNode{Key: key}
		this.dict[key] = node
	}

	node.Val = value
	this.list.Insert(node)
}

type cacheList struct {
	head *cacheNode
	rear *cacheNode
}

func newCacheList() *cacheList {
	l := &cacheList{}
	l.head = &cacheNode{}
	l.rear = &cacheNode{}
	l.head.Next = l.rear
	l.rear.Prev = l.head
	return l
}

func (l *cacheList) Remove(c *cacheNode) {
	c.Next.Prev = c.Prev
	c.Prev.Next = c.Next
}

func (l *cacheList) Insert(c *cacheNode) {
	c.Next = l.head.Next
	c.Next.Prev = c
	c.Prev = l.head
	l.head.Next = c
}

func (l *cacheList) RemoveEnd() *cacheNode {
	node := l.rear.Prev
	l.Remove(node)
	return node
}

type cacheNode struct {
	Key  int
	Val  int
	Prev *cacheNode
	Next *cacheNode
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */
