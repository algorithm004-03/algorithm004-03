# 总结
## 位运算
* 机器里的数字表示方式和存储格式就是二进制

### 指定位置的位运算
1. 将 x 最右边的 n 位清零: x & (~0 << n)
2. 获取 x 的第 n 位值(0 或者 1): (x >> n) & 1
3. 获取 x 的第 n 位的幂值:x & (1 << (n -1))
4. 仅将第 n 位置为 1:x | (1 << n)
5. 仅将第 n 位置为 0:x & (~ (1 << n))
6. 将 x 最高位至第 n 位(含)清零:x & ((1 << n) - 1)
7. 将第 n 位至第 0 位(含)清零:x & (~ ((1 << (n + 1)) - 1))

### 实战位运算要点
1. 判断奇偶:
   x % 2 == 1 —> (x & 1) == 1 
   x % 2 == 0 —> (x & 1) == 0
2. x >> 1 —> x / 2
   即: x = x / 2; —> x = x >> 1;
      mid = (left + right) / 2; ---> mid = (left + right) >> 1;
3. X = X & (X-1) 清零最低位的 1
4. X & -X => 得到最低位的 1
5. X & ~X => 0

## 排序算法
### 初级排序 - O(n^2)
1. 选择排序(Selection Sort) 
   每次找最小值，然后放到待排序数组的起始位置。
2. 插入排序(Insertion Sort)
   从前到后逐步构建有序序列;对于未排序数据，在已排序序列中从后 向前扫描，找到相应位置并插入。
3. 冒泡排序(Bubble Sort)
   嵌套循环，每次查看相邻的元素如果逆序，则交换。

### 高级排序 - O(nlogn)
1. 快速排序(Quick Sort)
   数组取标杆 pivot，将小元素放 pivot左边，大元素放右侧，然后依次 对右边和右边的子数组继续快排;以达到整个序列有序。
   ```java
   public static void quickSort(int[] array, int begin, int end) { 
     if (end <= begin) return;
      int pivot = partition(array, begin, end);
      quickSort(array, begin, pivot - 1);
      quickSort(array, pivot + 1, end);
   }
   static int partition(int[] a, int begin, int end) { 
    // pivot: 标杆位置，counter: 小于   pivot的元素的个数
    int pivot = end, counter = begin;
    for (int i = begin; i < end; i++) {
      if (a[i] < a[pivot]) {
        int temp = a[counter]; a[counter] = a[i]; a[i] = temp; counter++;
      } 
    }
    int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
    return counter;
   }
  ```

2. 归并排序(Merge Sort)— 分治
  把长度为n的输入序列分成两个长度为n/2的子序列; 
  对这两个子序列分别采用归并排序;
  将两个排序好的子序列合并成一个最终的排序序列。
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

3. 堆排序(Heap Sort) — 堆插入 O(logN)，取最大/小值 O(1)
   数组元素依次建立小顶堆
   依次取堆顶元素，并删除
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
          heapify(array, length, largest);
      }
    }

    public static void heapSort(int[] array) {
      if (array.length == 0) return;

      int length = array.length;
      for (int i = length / 2-1; i >= 0; i-) 
          heapify(array, length, i);

      for (int i = length - 1; i >= 0; i--) {
          int temp = array[0]; array[0] = array[i]; array[i] = temp;
          heapify(array, i, 0);
      }
    }
   ```
   

### 特殊排序
1. 计数排序(Counting Sort)
   计数排序要求输入的数据必须是有确定范围的整数。将输入的数据值转化为键存 储在额外开辟的数组空间中;然后依次把计数大于 1 的填充回原数组
2. 桶排序(Bucket Sort)
   桶排序 (Bucket sort)的工作的原理:假设输入数据服从均匀分布，将数据分到有 限数量的桶里，每个桶再分别排序(有可能再使用别的排序算法或是以递归方式 继续使用桶排序进行排)。
3. 基数排序(Radix Sort)
   基数排序是按照低位先排序，然后收集;再按照高位排序，然后再收集;依次类 推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按 高优先级排序。
   
