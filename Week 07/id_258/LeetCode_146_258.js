/*
 * @lc app=leetcode.cn id=146 lang=javascript
 *
 * [146] LRU缓存机制
 */

// @lc code=start
/**
 * @param {number} capacity
 */
var LRUCache = function (capacity) {
    this.m = new Map();
    this.capacity = capacity;
};

/** 
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function (key) {
    if (this.m.has(key)) {
        let value = this.m.get(key);
        this.m.delete(key);
        this.m.set(key, value);
        return value;
    } else {
        return -1;
    }
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function (key, value) {
    if (this.m.has(key)) {
        this.m.delete(key);
        this.m.set(key, value);
    } else if (this.m.size == this.capacity) {
        let first_key = this.m.keys().next().value;
        this.m.delete(first_key);
        this.m.set(key, value);
    } else {
        this.m.set(key, value);
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
// @lc code=end

