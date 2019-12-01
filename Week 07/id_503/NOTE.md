# 位运算
* 位运算符

	|含义							|运算符	|示例				|
	|--								|--		|--					|
	|右移							|>>		|0011 >> 1 = 0001	|
	|左移							|<<		|0011 << 1 = 0110	|
	|按位或							|\|		|0011 \| 1011 = 1011|
	|按位与							|&		|0011 & 1011 = 0011	|
	|按位取反						|~		|~0011 = 1100		|
	|按位异或（相同位 0，不同位 1）	|^		|0011^1011 = 1000	|

* 异或操作 XOR（^）
  * 相同为0，不同为1；可用【不进位加法】理解
  * 操作的一些特点
    * x^0 = x
    * x^1s = ~x // 1s表示全 1
    * x^(~x) = 1s
    * x^x = 0
    * c=a^b => a^c = b; b^c = a //交换两个数
    * a^b^c = a^(b^c) = (a^b)^c //结合性
* 指定位置的位运算
  * 将最右边的 n 位清零：x & (~0 << n)
  * 获取 x 的第 n 位值（0 或者 1）：（x >> n）& 1
  * 获取 x 的第 n 位的幂值：x & (1 << (n-1)
  * 仅将第 n 位设置为 1：x | (1 << n)
  * 仅将第 n 位设置为 0：x & (~(1 << n))
  * 将 x 最高位至第 n 位（含）清零：x & ((1 << n) - 1)
  * 将 n 位至第 0 位（含）清零：x & (~((1 << (n+1)) - 1))

LRU Cache（最近最少使用缓存）
* 代码模板
  ```js
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
  ```