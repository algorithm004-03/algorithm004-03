class LRUCache {

    /**
     * 
     * @param {number}} capacity 
     */
    constructor(capacity) {
        this.cap = capacity;
        this.cache = new Map(); // 有序字典
    }
    /**
     * @param {number} key
     * @return {number}
     */
    get(key) {
        if (!this.cache.has(key)) {
            return -1;
        }
        const val = this.cache.get(key);
        this.put(key, val);
        return val;
    }
    /**
     * @param {number} key
     * @param {number} value
     * @return {void}
     */
    put(key, value) {
        if (this.cache.has(key)) {
            this.cache.delete(key);
        }
        else {
            if (this.cache.size === this.cap) { // 容量已满，删除最后一元素
                const lastKey = this.cache.keys().next().value;
                this.cache.delete(lastKey);
            }
        }
        this.cache.set(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */