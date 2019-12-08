# NOTE
#### 知识回顾
* 位运算
    * 清零最低位的1： X = X & (X-1) 
    * 得到最低位的1： X & -X 
* 布隆过滤器
   * 一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检索 一个元素是否在一个集合中。
  * 优点：空间效率和查询时间都远远超过一般的算法
  * 缺点：有一定的误识别率和删除困难
  * 应用：
       * 比特币网络
       * 分布式系统
       * Redis缓存
       * 垃圾邮件、评论等的过滤
* LRU Cache
    * 两个要素： 大小 、替换策略
    * Hash Table + Double LinkedList
    * O(1) 查询 O(1) 修改、更新
* 排序
   * 比较类排序
   * 非比较类排序
#### 处理输出

* [LRU缓存机制](https://leetcode-cn.com/problems/lru-cache/solution/lru-huan-cun-ji-zhi-by-leetcode/)
* [颠倒二进制位](https://leetcode-cn.com/problems/reverse-bits/)
* [位1的个数](https://leetcode-cn.com/problems/number-of-1-bits/submissions/)
* [2的幂](https://leetcode-cn.com/problems/number-of-1-bits/submissions/)
* [有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/)
#### 遗留问题
 * n皇后问题（位运算实现）
 * 非比较类排序

#### 总结改进
* 重点练习遗留问题题目
  

