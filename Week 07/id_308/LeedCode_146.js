/**
 * 题目： LRU缓存机制
 * 语言： JavaScript
 * 执行结果： 打败了77.02%的用户
 * */



/**
 * @param {number} capacity
 */

class LRUCache{
    constructor(capacity){
        this.capacity = capacity;
        this.cache = new Map();
    }

    /**
     * @param {number} key
     * @return {number}
     */
    get (key){
        const cache = this.cache;
        if(cache.has(key)){
            const temp = cache.get(key);
            cache.delete(key);
            cache.set(key,temp);
            return temp;
        }

        return -1;
    }

    /**
     * @param {number} key
     * @param {number} value
     * @return {void}
     */
    put (key,value){
        let cache = this.cache;
        if(cache.has(key)){
            cache.delete(key);
        }else if(cache.size >= this.capacity){
            cache.delete(cache.keys().next().value)
        }

        cache.set(key,value);
    }
}


