# NOTE

# 位运算
## XOR - 异或
异或：相同为0，不同为1。也可以用"不进位加法"来理解。
异或操作的一些特点：
- x ^ 0 = x
- x ^ 1s = ~x (1s = ~0，也就是全1)
- x ^ (~x) = 1s
- x ^ x = 0
- c = a ^ b ==> a ^ c = b, b ^ c = a // 交换两个数
- a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c 

## 指定位置的位运算
- 将x最右边的n位清零：x&(~0<<n)
- 获取x的第n位值(0或者1)：(x>>n)&1
- 获取x的第n位的幂值：x&(1<<(n-1))
- 仅将第n位置为1：x|(1<<n)
- 仅将第n位置为0：x&(~(1<<n))
- 将x最高位至第n位(含)清零：x&((1<<n)-1)
- 将第n位至第0位(含)清零：x&(~((1<<(n+1))-1))

## 实战位运算要点
- 判断奇偶
  x%2==1 --> (x&1)==1
  x%2==0 --> (x&1)==0
- x>>1 --> x/2
  即x=x/2 --> x=x>>1
  mid=(left+right)/2 --> mid=(left+right)>>1
- X=X&(X-1)清零最低位的1
- X&-X==>得到最低位的1
- X&~X==>0

# bloom filter
bloom filter是一个很长的二进制向量和一系列的随机映射函数。
bloom filter可以用于检索一个元素是否在一个集合中。
- 优点：空间效率和查询时间都远远超过一般的算法
- 缺点：有一定的误识别率和删除困难

## bloom filter的原理及实现
https://www.cnblogs.com/cpselvis/p/6265825.html

## bloom filter：只能精确的判"否"，而不能精确的判"是"
- bloom filter可以精确的判断一个元素没有存在于bloom filter之中
- bloom filter不能精确的判断一个元素存在于bloom filter之中, 真正
要判断元素是否存在，必须另外访问一个完整的存储数据结构（比如DB, redis等）

## 使用布隆过滤器解决缓存击穿、垃圾邮件识别、集合判重
https://blog.csdn.net/tianyaleixiaowu/article/details/74721877

## bloom filter实现
### python
- 代码示例：https://shimo.im/docs/xKwrcwrDxRv3QpKG/read
- 实现示例：https://www.geeksforgeeks.org/bloom-filters-introduction-and-python-implementation/
- 高性能bloom filter实现：https://github.com/jhgg/pybloof

### java
- https://github.com/lovasoa/bloomfilter/blob/master/src/main/java/BloomFilter.java
- https://github.com/Baqend/Orestes-Bloomfilter

# LRU(least recent use) Cache
- 两个要素：大小、替换策略
- Hash Table + Double LinkedList
- O(1)查询
  O(1)修改、更新
  
## 替换算法
https://en.wikipedia.org/wiki/Cache_replacement_policies

# 排序算法
## 分类
- 比较类排序：通过比较来决定元素间的相对次序，由于其时间复杂度不能突破
O(nlogn), 因此也称为非线性时间比较类排序
- 非比较类排序：不通过比较来决定元素间的相对次序，它可以突破基于比较排序
的时间下界，以线性时间运行，因此也称为线性时间非比较类排序













