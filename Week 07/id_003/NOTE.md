# NOTE
## 位运算符
* 左移 <<
* 右移 >>
* 按位或 |
* 按位与 &
* 按位取反 ~
* 按位异或 6
  
### 异或操作特性：

x ^ 0 = x

x ^ 1s = ~x // 注意 1s = ~0
x ^ (~x) = 1s

x ^ x = 0

c = a ^ b => a ^ c = b, b ^ c = a // 交换两个数

a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c // associative 
  
### 指定位置的异或

1. 将 x 最右边的 n 位清零：x & (~0 << n)

2. 获取 x 的第 n 位值（0 或者 1）： (x >> n) & 1

3. 获取 x 的第 n 位的幂值：x & (1 << (n -1))

4. 仅将第 n 位置为 1：x | (1 << n)

5. 仅将第 n 位置为 0：x & (~ (1 << n))

6. 将 x 最高位至第 n 位（含）清零：x & ((1 << n) - 1)

7. 将第 n 位至第 0 位（含）清零：x & (~ ((1 << (n + 1)) - 1))

### 常用位运算
* 判断奇偶：

    x % 2 == 1 —> (x & 1) == 1

    x % 2 == 0 —> (x & 1) == 0

*  x >> 1 —> x / 2

    即： x = x / 2; —> x = x >> 1;

    mid = (left + right) / 2; —> mid = (left + right) >> 1;

* X = X & (X-1) 清零最低位的 1

* X & -X => 得到最低位的 1

* X & ~X => 0

## 布隆过滤器
一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检索
一个元素是否在一个集合中。

优点是空间效率和查询时间都远远超过一般的算法，

缺点是有一定的误识别率和删除困难。

## 排序算法
### 归并
```
public static void mergeSort(int[] array, int left, int right) {
    if (right <= left) return;
    int mid = (left + right) >> 1; // (left + right) / 2
    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);
}
```
```
public static void merge(int[] arr, int left, int mid, int right) {
    int[] temp = new int[right - left + 1]; // 中间数组
    int i = left, j = mid + 1, k = 0;
    while (i <= mid && j <= right) {
        temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
    }
    while (i <= mid) temp[k++] = arr[i++];
    while (j <= right) temp[k++] = arr[j++];
    for (int p = 0; p < temp.length; p++) {
        arr[left + p] = temp[p];
    }
    // 也可以⽤ System.arraycopy(a, start1, b, start2, length)
 }
```

* [十大排序算法](https://www.cnblogs.com/onepixel/p/7674659.html)