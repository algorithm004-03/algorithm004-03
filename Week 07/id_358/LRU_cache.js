/**
 * @param {number} capacity
 */
 var LRUCache = function(capacity) {
    this.capacity = capacity
    this.hashTable = {}
    this.size = 0;
    this.head = new Node('head');
    this.tail = new Node('tail');
    this.head.prev = null;
    this.head.next = this.tail;
    this.tail.prev = this.head;
    this.tail.next = null;
};

/** 
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function(key) {
    if(this.hashTable[key]) {
        this.moveToHead(key);
        return this.hashTable[key].value;
    }
    return -1;
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function(key, value) {
    if(this.hashTable[key]) {
        this.hashTable[key].value = value;
        this.moveToHead(key)
    } else {
        if(this.capacity === this.size) {
            this.removeLRU()
        }
        this.add(key, value)
    }
    
};

LRUCache.prototype.moveToHead = function(key) {
    debugger
    const node = this.hashTable[key];
    node.prev.next = node.next;
    node.next.prev = node.prev;
    node.prev = this.head;
    node.next = this.head.next;
    this.head.next.prev = node;
    this.head.next = node;
}

/**
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.add = function(key, value) {
    const node = new Node(key, value);
    this.hashTable[key] = node;
    this.size++;
    node.prev = this.head;
    node.next = this.head.next;
    this.moveToHead(key)
}

LRUCache.prototype.removeLRU = function() {
    let node = this.tail.prev;
    node.prev.next = this.tail;
    this.tail.prev = node.prev;
    this.size--;
    delete this.hashTable[node.key]
    node = null;
}

/** 
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

class Node {
    constructor(key,value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}