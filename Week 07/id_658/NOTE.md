# 第七周学习总结

## 位运算

- 计算机里的数字表示方式和存储格式就是二进制

### 位运算符

- 左移 <<
- 右移 >>
- 按位或 |
- 按位与 &
- 按位取反 ~
- 按位异或 ^
  - 相同为0 不同为1
  - 不进位加法

### 位运算要点

- 判断奇偶
  - 奇数 x % 2 == 1 位运算：(x & 1) == 1
  - 偶数 x % 2 == 0 位运算：(x & 1) == 0
- x / 2 位运算：x >> 1
- 清零最低位的1 位运算：x = x & (x - 1)
- 得到最低位的1 位运算：x & -x
- x & ~x == 0

## 布隆过滤器 Bloom Filter

- 一个很长的二进制向量和一系列随机映射函数构成
- 可以用于检索一个元素是否在一个集合中
- 优点是空间效率和查询效率都远超过一般的算法
- 缺点是有一定的误识别率和删除困难

```java
package com.github.lovasoa.bloomfilter;

import java.util.BitSet;
import java.util.Random;
import java.util.Iterator;

public class BloomFilter implements Cloneable {
    private BitSet hashes;
    private RandomInRange prng;
    private int k; // Number of hash functions
    private static final double LN2 = 0.6931471805599453; // ln(2)

    /**
        * Create a new bloom filter.
        *
        * @param n Expected number of elements
        * @param m Desired size of the container in bits
        **/
    public BloomFilter(int n, int m) {
        k = (int) Math.round(LN2 * m / n);
        if (k <= 0)
            k = 1;
        this.hashes = new BitSet(m);
        this.prng = new RandomInRange(m, k);
    }

    /**
        * Create a bloom filter of 1Mib.
        *
        * @param n Expected number of elements
        **/
    public BloomFilter(int n) {
        this(n, 1024 * 1024 * 8);
    }

    /**
        * Add an element to the container
        **/
    public void add(Object o) {
        prng.init(o);
        for (RandomInRange r : prng)
            hashes.set(r.value);
    }

    /**
        * Returns true if the element is in the container.
        * Returns false with a probability ≈ 1-e^(-ln(2)² * m/n)
        * if the element is not in the container.
        **/
    public boolean contains(Object o) {
        prng.init(o);
        for (RandomInRange r : prng)
            if (!hashes.get(r.value))
                return false;
        return true;
    }

    /**
        * Removes all of the elements from this filter.
        **/
    public void clear() {
        hashes.clear();
    }

    /**
        * Create a copy of the current filter
        **/
    public BloomFilter clone() throws CloneNotSupportedException {
        return (BloomFilter) super.clone();
    }

    /**
        * Generate a unique hash representing the filter
        **/
    public int hashCode() {
        return hashes.hashCode() ^ k;
    }

    /**
        * Test if the filters have equal bitsets.
        * WARNING: two filters may contain the same elements, but not be equal
        * (if the filters have different size for example).
        */
    public boolean equals(BloomFilter other) {
        return this.hashes.equals(other.hashes) && this.k == other.k;
    }

    /**
        * Merge another bloom filter into the current one.
        * After this operation, the current bloom filter contains all elements in
        * other.
        **/
    public void merge(BloomFilter other) {
        if (other.k != this.k || other.hashes.size() != this.hashes.size()) {
            throw new IllegalArgumentException("Incompatible bloom filters");
        }
        this.hashes.or(other.hashes);
    }

    private class RandomInRange
            implements Iterable<RandomInRange>, Iterator<RandomInRange> {

        private Random prng;
        private int max; // Maximum value returned + 1
        private int count; // Number of random elements to generate
        private int i = 0; // Number of elements generated
        public int value; // The current value

        RandomInRange(int maximum, int k) {
            max = maximum;
            count = k;
            prng = new Random();
        }

        public void init(Object o) {
            prng.setSeed(o.hashCode());
        }

        public Iterator<RandomInRange> iterator() {
            i = 0;
            return this;
        }

        public RandomInRange next() {
            i++;
            value = prng.nextInt() % max;
            if (value < 0)
                value = -value;
            return this;
        }

        public boolean hasNext() {
            return i < count;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
```

## LRU 缓存

- 最近最少使用
- 两个要素：大小、替换策略
- HashTable + Double LinkedList
- 查询 **O(1)** 修改更新 **O(1)**
- Java 中 LinkedHashMap

## 排序算法

### 比较类排序

- 通过比较来决定元素间的相对次序，由于其时间复杂度不能突破 **O(nlogn)**，因此也称为非线性时间比较类排序
- 交换排序
  - 冒泡排序 `Bubble Sort` **O(n^2)**
    - 嵌套循环，每次查看相邻的元素如果逆序，则交换
  - 快速排序 `Quick Sort` **O(nlogn)**
    - 数组取标杆 pivot，将小元素放在 pivot 左边，大元素放在右侧，然后依次对左边和右边的子数组继续快排，以达到整个序列有序
- 插入排序 `Insertion Sort` **O(n^2)**
  - 从前到后逐步构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
  - 简单插入排序
  - 希尔排序
- 选择排序 `Selection Sort` **O(n^2)**
  - 每次找最小值，然后放到待排序数组的起始位置
  - 简单选择排序
  - 堆排序 `Heep Sort` **O(nlogn)**
    - 堆插入 **O(logn)**
    - 取最大/小值 **O(1)**
    - 数组元素依次建立小顶堆，依次取堆顶元素，并删除
- 归并排序 `Merge Sort` **O(nlogn)** `分治`
  - 把长度为 n 的输入序列分成两个长度为 n / 2 的子序列，对两个子序列分别采用归并排序，将两个排序好的子序列合并成一个最终的排序序列
  - 二路归并排序
  - 多路归并排序
- `归并排序`和`快速排序`具有相似性，但步骤顺序相反
  - 归并：先排序左右子数组，然后合并两个有序子数组
  - 快排：先调配出左右子数组，然后对于左右子数组进行排序

### 非比较类排序

- 不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序
- 计数排序 `Counting Sort` **O(n)**
  - 计数排序要求输入的数据必须是有确定范围的整数，将输入的数据值转化为键存储在额外开辟的数组空间中，然后依次把计数大于1的填充回原数组
- 桶排序 `Bucket Sort` **O(n)**
  - 假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序
  - 有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排序
- 基数排序 `Radix Sort` **O(n)**
  - 先按照低位排序，然后收集，再按照高位排序，然后再收集，依此类推，直到最高位。
  - 有时候有些属性是有优先级顺序的，先按照低优先级排序，再按照高优先级排序
