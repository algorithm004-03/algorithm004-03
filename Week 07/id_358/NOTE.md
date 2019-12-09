# 位运算

主要有：与&，或|，非~，异或^

## 异或的特点

重点需要知道异或的特征：可以看成“不进位加法”

异或有以下特殊情况：

1. x^0 = x
2. x^1s = ~x // 1s表示非零, x异或非零等于取反
3. x^(~x) = 1s //  x 异或本身取反等于非零
4. x^x = 0
5. c = a^b => a^c = b, b ^ c = a; //  用于交换两个数
6. a^b^c = a^(b^c) = (a^b)^c // 结合律

## 指定位置的位运算

1. 将x最右边的n位清零： x & (~0 << n)
2. 获取x的第n位值：（x>>n) & 1
3. 获取x的第n位的幂值： x&(1<<(n-1))

## 实际应用中位运算要的

1. 判断奇偶

   x % 2 == 1 => (x&1) === 1

   x % 2 == 0 => (x&1) === 0

2. x >>1 => x / 2

3. x = x & (x - 1) 清零最低位的1

4. x & -x => 得到最低位的1

5. x & ~x => 0

## 实战题

### 1. 位1 的个数

1. 位运算。利用 x & (x - 1) 不断清零最低位的1

   ```js
   sum = 0;
   while(n > 0) {
       sum ++;
       n = n & (n -1)
   }
   ```

### 2.  给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 

 判断符合条件的二进制数为：有且仅有一个1.

即满足： n > 0 && (n & (n - 1)) === 0 

### 3. 颠倒二进制

1. Int => string => reverse => int
2. 位运算

```
var reverseBits = function(n) {
    let result = 0;
    // result从右往移动空出末位 + n从左往右移动获取末位 + n次 = 倒序
    for(let i = 0;i < 32;i++){
        // 左移空出一位
        result <<= 1
        // n&1获取n的末位，result的末位换成n的末位
        result |= n & 1;
        // 右移1位
        n >>= 1;
    }
    return result >>> 0;
};

```

### 4. n皇后

使用二进制存储列，撇，捺 的皇后，开始时都是11111111.

### 5. 比特位计数

DP + 位运算

DP 方程递推：

 奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1 二进制表示中，偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。

```
result[0] = 0
for (i --> n)
	if i % 2 ==- 0 
		result[i] = result[i - 1] + 1
	else 
		result[i] = result[i/2]
```

# 布隆过滤器

 与hashtable类似。

通过hashtable+ 双向列表实现

## BlooFilter

 一个很长的二进制向量和一系列随机映射函数，可以用于检索一个元素是否在一个集合中。

优点 ： 空间效率和查询时间都远超一般算法；

缺点： 有一定误识别率和删除困难；

## 实现

为每个元素分配一系列的二进制位，值为1.

用于检索： 元素的所有位都是1 ==》可能存在；

​					只要有一位是 0 ==》不存在

## 实际应用

1. 比特币网络中的存储： transaction in node
2. 分布式系统map-reduce
3. redis缓存
4. 垃圾邮件，评论等的过滤系统

## 实战题

### 1. LRU缓存实现

两个要素： 有固定大小，替换策略（LRU）

hashtable + double linked list

时间复杂度：查询O(1)，修改更新O(1)

最近使用的一定在最前，最少使用的淘汰。

实际上有很多算法实现，如今已发展为使用AI代替传统算法。

# 排序

参考链接： https://www.cnblogs.com/onepixel/p/7674659.html 

## 排序分类

### 1. 比较类排序

​	通过比较决定相对顺序 O（nlongn）

### 2. 非比较类排序

#### 1. 初级排序O (n^2)

1. 选择排序

   每次找最小值，然后放到待排序的位置

2. 插入排序

   从前到后逐步建立有序序列，对于未排序的数据，在已排序的序列中从后向前扫描，找到相应的位置插入。

3. 冒泡排序

   嵌套循环，每次查看相邻的元素，如果逆序则交换位置。

#### 2. 高级排序

 1. 快速排序

    取标杆pivot，取小元素放到pivot左侧，较大的放到pivot右侧，对左右数据继续快排。

    ```java
    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }
    
    static int partition(int[] a, int begin, int end) {
        // pivot: 标杆位置，counter: 小于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
                counter++;
            }
        }
        int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
        return counter;
    }
    ```

    

 2. 归并排序

    1. 把长度为n的输入序列分成两个长度为n/2的子序列；
    2. 对子序列分别采用归并排序
    3. 合并子序列（）

    ```java
    public static void mergeSort(int[] array, int left, int right) {
    
        if (right <= left) return;
        int mid = (left + right) >> 1; // (left + right) / 2
    
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    
    }
    
    public static void merge(int[] arr, int left, int mid, int right) {
    
            int[] temp = new int[right - left + 1]; // 中间数组
            int i = left, j = mid + 1, k = 0;
    
            while (i <= mid && j <= right) {
                temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
            }
    
            while (i <= mid)   temp[k++] = arr[i++];
            while (j <= right) temp[k++] = arr[j++];
    
            for (int p = 0; p < temp.length; p++) {
                arr[left + p] = temp[p];
            }
            // 也可以用 System.arraycopy(a, start1, b, start2, length)
        }
    ```

    > 快排 vs 归并 
    >
    > 归并： 先排序左右子数组，然后合并
    >
    > 快速： 先调配处左右子数组，然后对左右子数组进行排序

    

    3. 堆排序

    堆插入O（logN）, 取最大/小 O (1)

    1. 数组元素一次建立小顶堆；
    2. 依次取堆顶，并删除；



#### 特殊排序

1. 计数排序
2. 桶排序
3. 基数排序