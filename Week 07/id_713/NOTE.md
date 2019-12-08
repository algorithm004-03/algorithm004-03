# NOTE

  

# 位运算

## 位运算符

| 含义     | 运算符 | 示例                 | 备注             |
| -------- | ------ | -------------------- | ---------------- |
| 左移     | <<     | 0011 -> 0110         | X2               |
| 右移     | >>     | 0110 -> 0011         | /2               |
| 按位或   | \|     | 0011 \| 1011 -> 1011 |                  |
| 按位与   | &      | 0011 & 1011 -> 0011  |                  |
| 取反     | ~      | 0011 -> 1100         |                  |
| 按位异或 | ^      | 0011 ^ 1011 -> 1000  | 相异为1, 相同为0 |

### 异或运算特点

* x ^ 0 = x
* x ^ 1s = ~x // 1s为全1, 全1相当于0取反(~0)
* x ^ (~x) = 1s
* x ^ x = 0
* c = a ^ b  =>  a ^ c = b,  b ^ c = a // 交换两个数
* a ^ b ^ c = a ^ ( b ^ c ) = ( a ^ b ) ^ c  // 结合律

### 指定位置的位运算

| 描述                       | 公式                       |
| -------------------------- | -------------------------- |
| 将x最右边的n位清零         | x & (~0 << n)              |
| 获取x的第n个位的值(0或者1) | (x >> n) & 1               |
| 获取x的第n次幂             | x & (1 << (n - 1))         |
| 仅将第n位, 置为1           | x \| (1 << n)              |
| 仅将第n为, 置为0           | x & ( ~(1 << n))           |
| 将x最高位至第n位(含)清零   | x & ((1 << n) - 1)         |
| 将第n位至第0位(含)清零     | x & (~((1<< (n + 1)) - 1)) |

### 实战运算要点

* 奇偶判断
  * x % 2 == 1   ->   (x & 1) == 1
  * x % 2 == 0   ->   (x & 1) == 0
* 除2
  * x / 2   ->   x >> 1
  * mid = (left + right)  / 2   ->   mid = (left + right)  >> 1
* 清零最低位的1
  * x = x & (x - 1)
* 得到最低位的1
  * x & (x - 1)
* x & ~x = 0





# 排序

## 快排 Quick Sort

* 数组取标杆pivot, 将小元素放在pivot左边, 大元素放右侧, 然后依次对左边和右边的子数组进行快排, 从而达到整个数组有序

### 代码

```java
public static void quickSort(int[] arr, int begin, int end) {
  if (end <= begin) return;

  int pivot = partition(arr, begin, end);
  quickSort(arr, begin, pivot - 1);
	quickSort(arr, pivot + 1, end);
}

private static int partition(int[] arr, int begin, int end) {
  // 标杆位置, 计数器:小于pivot的个数
  int pivot = end, counter = begin;
  for (int i = begin; i < end; i++) {
    if (arr[i] < a[pivot]) {
      int tmp = arr[counter];
      a[counter] = a[i];
      a[i] = tmp;
      counter++;
    }
    int tmp = a[pivot];
    a[pivot] = a[counter];
    a[counter] = tmp;
  }
  return counter;
}
```

## 归并排序 Merge Sort

* 归并排序(Merge Sort) 分治
  * 把长度为n的输入序列, 分成2个长度为 n/2的子序列
  * 对这2个子序列分别采用归并排序
  * 将2个排序好的子序列合并成一个最终的排序序列

### 代码

```java
public static void mergeSort(int[] arr, int left, int right) {
  if (right <= left) return;
  
  int mid = (left + right) >> 1; // (right - left) >> 1 + left;
  
  mergeSort(arr, left, mid);
  mergeSort(arr, mid + 1, right);
  merge(arr, left, mid, right);
}

private static void merge(int[] arr, int left, int mid, int right) {
  int[] tmp = new int[right - left - 1]; // 中间数组
  int i = left, j = mid + 1, k = 0;
  
  while (i <= mid && j <= right) {
    tmp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
  }

  while (i <= mid) tmp[k++] = arr[i++];
  while (j <= right) tmp[k++] = arr[j++];

  for (int p = 0; p < tmp.length; p++) {
    arr[left + p] = tmp[p];
  }
  
  // 也可以用 System.arraycopy(a, start1, b, start2, length);
  // System.arraycopy(tmp, 0, arr, left, tmp.length);
}
```



## 归并&快排总结

* 归并: 先排序左右子数组, 然后合并2个有序数组
* 快排: 先调配出左右子数组, 然后对于左右子数组进行排序



## 堆排序 Heap Sort

* 插入 O(longN), 取最大/最小值 O(1)
* 数组元素依次建立小顶堆
* 依次取堆顶元素, 并删除





