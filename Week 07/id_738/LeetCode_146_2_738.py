class Node(object):
    def __init__(self, key = None, value = None):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

class LRUCache(object):
    """
    LRU缓存机制：https://leetcode-cn.com/problems/lru-cache/submissions/

    1. 要实现O(1)完成get操作，比如需要用hash直接定位到元素的位置
    2. LRU的get操作，如果元素在Cache中，那么需要将元素提到Cache的头部；如果不在里面则返回-1
    3. LRU的put操作，如果元素在Cache中，那么直接将元素提到Cache头部；如果不在里面，则有下面两种可能：
    3.1. Cache元素没满，则直接将元素插入到Cache的头部
    3.2. Cache元素已满，则将Cache尾部(最不常用的)元素移除，并将元素插入到Cache头部
    上的2和3操作涉及到元素的删除添加，添加元素O(1)用链表，删除元素O(1)则要将链表进化为双端链表
    所以最终的数据结构为： hashmap + 双端链表 实现
    """

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.remain = capacity
        self.cache = {}
        self.head, self.tail = Node(), Node()
        self.head.next = self.tail
        self.tail.prev = self.head
        
    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key not in self.cache:
            return -1
        else:
            node = self.cache[key]
            # 将node提到队列最前面：先删除后添加到头部
            self._remove(node)
            self._append_to_head(node)
            return node.value
        
    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        if key in self.cache: 
            # 将node提到队列最前面：先删除后添加到头部
            self._remove(self.cache[key])
            self._append_to_head(self.cache[key])
            # 这里注意，如果put是一个更新操作的话，那么需要重新赋值
            self.cache[key].value = value
        else:
            node = Node(key, value)
            if self.remain > 0: # 还有容量则直接插入到头部
                self.cache[key] = node
                self.remain -= 1
            else: # 没有容量了，那么将队列末尾的移除(并删除cache中的该元素))，将新元素插入到队列头部
                tail = self._remove_tail()
                del self.cache[tail.key]
                self.cache[key] = node
            self._append_to_head(node)
    
    # 下面的三个操作都是对双端队列的操作
    def _remove(self, node):
        pre = node.prev
        nex = node.next
        pre.next = nex
        nex.prev = pre

    def _append_to_head(self, node):
        nex = self.head.next
        self.head.next = node
        node.prev = self.head
        node.next = nex
        nex.prev = node

    def _remove_tail(self):
        tail = self.tail.prev
        self._remove(tail)
        # pre = tail.prev
        # pre.next = self.tail
        # self.tail.prev = pre
        return tail
