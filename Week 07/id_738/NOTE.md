# 第七周学习总结
## 位运算
- 为什么需要位运算
  - 计算机的数字表示方式是二进制方式
- 位运算符
  - XOR - 异或
    - 相同为0，不同为1.也可用"不进位加法"来理解
    - 操作特点
      - x ^ 0 = x
      - x ^ 1s = ~x    //注意1s =~ 0，表示全1
      - x ^ (~x) = 1s
      - x ^ x = 0
      - c = a ^ b => a ^ c = b, b ^ c = a   //交换两数
      - a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c
  - 指定位置的位运算
    - 将x最右边的n为清零：x & (~0 << n)
    - 获取x的第n位值(0或者1)： (x >> n) & 1
    - 获取x的第n位的幂值：x & (1 << (n - 1))
    - 仅将第n位置为1：x | (1 << n)
    - 仅将第n位置为0：x & (~(1 << n))
    - 将x最高位至第n位(含)清零：x & ((1 << n) - 1)
    - 将第n位至第0位(含)清零：x & (~((1 << (n + 1)) - 1))
- 实战位运算要点(面试最多)(布隆过滤器，n皇后问题)
  - 判断奇偶：
    - x % 2 == 1 -> (x & 1) == 1
    - x % 2 == 0 -> (x & 1) == 0
  - x >> 1 -> x / 2
    - 即：x = x / 2 -> x = x >>1
  - X = X & (X - 1)清零最低位的1
  - X & -X => 得到最低位的1
  - X & ~X => 0

## 布隆过滤器
- 高级数据结构
  - 在面试中和工业应用中较为广泛
- 布隆过滤器
  - 一个很长的二进制向量和一系列随机映射函数。
  - 用于检索一个元素是否在一个集合中
  - 优点：
    - 空间效率和查询时间都远远超过一般算法
  - 缺点
    - 有一定的误识别率和删除困难
  - 操作方法：
  - 添加元素：
    - 将要添加的元素给K个哈希函数
    - 得到对应于位数组上的K个位置
    - 将K个位置设置为1
  - 查询元素：
    - 将要查询的元素给K个哈希函数
    - 得到对应于位数组上的K个元素
    - 如果K个位置有一个为0，则肯定不在集合中
    - 如果K个位置全部为1，则可能在集合中
  - 实际应用：
    - 因为布隆过滤器只能判断肯定不在集合中的元素，但是不能判断元素必定在集合中。但是由于布隆过滤器的空间和时间复杂度很低，所以在工业中，布隆过滤器是位于最前线的过滤器，只有通过过滤器判断True，才传递到下一层去查询真正的源数据看是否在。
      - 比特币网络
      - 分布式系统
      - Redis缓存
      - 垃圾邮件、评论等过滤
  - 实现代码

```python
from bitarray import bitarray 
import mmh3 

class BloomFilter: 
    def __init__(self, size, hash_num): 
        self.size = size 
        self.hash_num = hash_num 
        self.bit_array = bitarray(size) 
        self.bit_array.setall(0) 

    def add(self, s): 
        for seed in range(self.hash_num): 
            result = mmh3.hash(s, seed) % self.size 
            self.bit_array[result] = 1 

    def lookup(self, s): 
        for seed in range(self.hash_num): 
            result = mmh3.hash(s, seed) % self.size 
            if self.bit_array[result] == 0: 
                return "Nope" 
        return "Probably" 

# bf = BloomFilter(500000, 7) 
# bf.add("dantezhao") 
# print (bf.lookup("dantezhao")) 
# print (bf.lookup("yyj")) 
```

## LRU Cache
- LRU - least reently used
  - 最近最少使用
  - Hash + 双向链表
  - O(1)查询
  - O(1)修改、更新
 - java中可以用LinkedHashMap

## 初级排序和高级排序
### 比较类排序（最常用）
- 通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)，因此也称为非线性时间比较类排序
- 有一个compare之类的方法来比较两个数的次序
- 不局限于整型类型
- 类别（重点是nlogn的三种排序）
#### 交换排序
- 冒泡排序：O(n^2),初级排序
  - 嵌套循环，每次查看相邻的元素，如果逆序，则交换
- 快速排序：O(nlogn),高级排序
  - 数组取标杆pivot，将小元素放pivot左边，大元素放右侧，然后依次对左边和右边的子数组继续快排；以达到整个序列有序
  - 先调配出左右子数组，然后怼左右子数组进行快速排序
  - 代码

```java
public static void quickSort(int[] array, int begin, int end) {
    if (end <= begin) return;
    int pivot = partition(array, begin, end);
    quickSort(array, begin, pivot - 1);
    quickSort(array, pivot + 1, end);

}

static int partition(int[] a, int begin, int end) {
    // pivot: 标杆位置，counter: counter下标前面的元素都小于pivot
    int pivot = end, counter = begin;
    // 循环数组，将小于pivot的元素挪动到counter的前面
    // 每挪动一个元素后，counter往后移动一个位置
    // 循环结果就是：counter前面的元素都小于pivot，后面的元素(包括counter位置，不包括pivot位置)都大于pivot
    // 所以数组挪动后最后的counter位置就是应该存放pivot值的位置
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
- 插入排序
  - 简单插入排序：O(n^2),初级排序
  - 从前到后逐步构建有序序列；对未排序数据，在已排序序列中从后向前扫描(扫描过程中，在插入位置之后的元素都要往后挪动一个位置)，找到相应位置并插入
- 希尔排序
- 选择排序
  - 简单选择排序：O(n^2),初级排序
  - 每次找最小值，然后放到待排序数组的起始位置(和待排序数组的起始位置的元素进行交换)
- 堆排序：插入O(nlogn)，取最大/小O(1)
  - 数组元素一次建立小顶堆
  - 然后每次取出堆顶的元素
  - 代码：

```java
static void heapify(int[] array, int length, int i) {
    int left = 2 * i + 1, right = 2 * i + 2；
    int largest = i;

    if (left < length && array[left] > array[largest]) {
        largest = left;
    }
    if (right < length && array[right] > array[largest]) {
        largest = right;
    }

    if (largest != i) {
        int temp = array[i]; array[i] = array[largest]; array[largest] = temp;
        // 由于调整了堆的元素位置，所以需要对调整了的位置的子树进行重新建堆
        heapify(array, length, largest);
    }
}

public static void heapSort(int[] array) {
    if (array.length == 0) return;

    int length = array.length;
    // 从最后一个非叶子节点开始,逐步建立堆
    for (int i = length / 2 - 1; i >= 0; i--) 
        heapify(array, length, i);

    // 建立完堆，依次取出堆顶元素，即是最大值放到数组最后。
    // 操作完成后，重新对堆顶的子树进行重新建堆，建堆数组长度逐次减一（排除掉已经排序好的数组尾元素）
    for (int i = length - 1; i >= 0; i--) {
        int temp = array[0]; array[0] = array[i]; array[i] = temp;
        heapify(array, i, 0);
    }
}
```

- 归并排序：O(nlogn)，二路，多路
  - 需要额外的内存空间n
  - 先排序左右子数组，然后合并两个有序子数组
  - 分治
    - 1. 把长度为n的输入序列分成两个长度为n/2的子序列；
    - 2. 对这两个子序列分别采用归并排序
    - 3. 将两个排序好的子序列合并成一个最终的排序序列
    - 代码：

```java
public static void mergeSort(int[] array, int left, int right) {
    if (right <= left) return;
    int mid = (left + right) >> 1; // (left + right) / 2
    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);
}

// 这个方法完成的任何：如何把两个有序的数组合并成一个有序的数组
// 需要借助一个额外空间n
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

## 特殊排序
- 非比较类排序
  - 不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序
  - 局限于整型相关的数据类型，对字符串，对象无能为力
  - 时间复杂度:O(n)
  - 计数排序
    - 元素必须是整数
    - 计数排序要求输入的数据必须是有确定范围的整数。将输入的数据值转化为键存储在额外开辟的数组空间中；然后依次把计数大于1的填充回原数组
  - 桶排序（不做重点要求）
    - 计数排序的升级版，解决计数排序元素过多会爆掉的问题
    - 假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排序）
- 基数排序
  - 只能排整型数据
  - 按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是由优先级顺序的，先按低优先级排序，再按高优先级排序。

## 选择排序，冒泡排序，插入排序的代码
- 冒泡排序

```python
def sort(nums):
    # 每趟冒泡过程决定了数组最后一位的值,所以从后往前扫描
    for i in range(len(nums))[::-1]:
        # 每趟冒泡需要比较相邻两个数之间的大小并交换，直到该趟的末尾i - 1(因为过程涉及到j+1，所以j最大必须为i - 1，否则j+1会越界)
        for j in range(i):
            if nums[j] > nums[j + 1]:
                nums[j], nums[j + 1] = nums[j + 1], nums[j]
```

- 选择排序

```python
# 每次扫描未排序部分，选择其最小值
# 插入到已排序部分的后面一个位置（交换操作）
def sort(nums):
    size = len(nums)
    for i in range(size):
        mini_index = i
        for j in range(i + 1, size):
            if nums[mini_index] > nums[j]:
                mini_index = j
        nums[i], nums[mini_index] = nums[mini_index], nums[i]
```

- 插入排序

```python
# 每次对未排序部分的值，查找在已排序部分的位置并插入
# 插入需要将已排序部分在插入位置后面的值向后挪动一位
# nums=[2,3,1,5,0,10,11,4]
def sort(nums):
    size = len(nums)
    for i in range(1, size):
        # 对j = 0...i-1部分的值进行查找位置插入nums[i]
        # 操作是每次看j和j + 1部分的值，如果后者小于前者，表示前者必须在后者后面
        # 所以交换值
        # 然后继续比较下一对值
        for j in range(0, i)[::-1]:
            if nums[j + 1] < nums[j]:
                nums[j], nums[j + 1] = nums[j + 1], nums[j]
```

