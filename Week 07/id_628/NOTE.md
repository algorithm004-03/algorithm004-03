# NOTE

  

# 第七周总结

## 【本周知识点】

1、位运算

2、布隆过滤器

3、LRU

4、排序

## 【本周学习总结】

### 位运算

| 功能                  | 示例                                          | 位运算                 |
| --------------------- | --------------------------------------------- | ---------------------- |
| 去掉最后一位          | (101101->10110)                               | x >> 1                 |
| 在最后加一个0         | (101101->1011010)                             | x << 1                 |
| 在最后加一个1         | (101101->1011011)                             | x << 1+1               |
| 把最后一位变成1       | (101100->101101)                              | x                      |
| 把最后一位变成0       | (101101->101100)                              | x                      |
| 最后一位取反          | (101101->101100)                              | x ^ 1                  |
| 把右数第k位变成1      | (101001->101101,k=3)                          | x                      |
| 把右数第k位变成0      | (101101->101001,k=3)                          | x & ~ (1 << (k-1))     |
| 右数第k位取反         | (101001->101101,k=3)                          | x ^ (1 << (k-1))       |
| 取末三位              | (1101101->101)                                | x & 7                  |
| 取末k位               | (1101101->1101,k=5)                           | x & (1 << k-1)         |
| 取右数第k位           | (1101101->1,k=4)                              | x >> (k-1) & 1         |
| 把末k位变成1          | (101001->101111,k=4)                          | x                      |
| 末k位取反             | (101001->100110,k=4)                          | x ^ (1 << k-1)         |
| 把右边连续的1变成0    | (100101111->100100000)                        | x & (x+1)              |
| 把右起第一个0变成1    | (100101111->100111111)                        | x                      |
| 把右边连续的0变成1    | (11011000->11011111)                          | x                      |
| 取右边连续的1         | (100101111->1111)                             | (x ^ (x+1)) >> 1       |
| 去掉右起第一个1的左边 | (100101000->1000)                             | x & (x ^ (x-1))        |
| 取int   max           | 2147483647-> 1111111111111111111111111111111  | (1<<31)-1              |
| 取int  min            | -2147483648->10000000000000000000000000000000 | 1<<31                  |
| 判断奇偶数            | 11-> 1   10-> 0                               | x&1                    |
| 求绝对值              | 11(3)->11(3)    11111101(-3)->11(3)           | (x^(x>>31))-(x>>31)    |
| 求相反数              | 11->11111101  11111101->11                    | ~x+1                   |
| 判断是不是2的幂次方   |                                               | ((x&(x-1))==0)&&(x!=0) |





### 布隆过滤器

> 用于查找元素不存在与过滤器中。常用于缓存的最外层，如果判断在，那么是可能存在的，需要再去实际存储中查找一下是否真正存在。
>
> - 一个很长的二进制向量和一系列随机映射函数。
> - 用于检索一个元素是否在一个集合中
> - 优点：
>   - 空间效率和查询时间都远远超过一般算法
> - 缺点
>   - 有一定的误识别率和删除困难

### LRU

> 最近最少使用，当缓存空间被打满时，剔除最少使用元素。实现方式是哈希表+双向链表。可以用java原生api中LInkedHashMap实现

### 排序

#### 比较类排序

##### 交换排序

###### 【冒泡排序】

>时间复杂度（平均/最坏/最好）：O(n2) /O(n2) /O(n) 
>
>空间复杂度：O(1)
>
>稳定性：稳定

```java
/**
 * 冒泡排序方法
 * @param array
 * @return
 */
public static void BubbleSort(int [] arr){
   int temp;//临时变量
   boolean flag;//是否交换的标志
   for(int i=0; i<arr.length-1; i++){   //表示循环次数，一共arr.length-1次。
       flag = false;
       for(int j=arr.length-1; j>i; j--){
           if(arr[j] < arr[j-1]){
               temp = arr[j];
               arr[j] = arr[j-1];
               arr[j-1] = temp;
               flag = true;
           }
       }
       if(!flag) break;
   }
}
```



###### 【快速排序】

>时间复杂度（平均/最坏/最好）：O(nlogn) /O(n2) /O(nlogn) 
>
>空间复杂度：O(nlogn)
>
>稳定性：不稳定

```java
/**
 * 快速排序方法
 * @param array
 * @param start
 * @param end
 * @return
 */
public static int[] QuickSort(int[] array, int start, int end) {
    if (array.length < 1 || start < 0 || end >= array.length || start > end) return null;
    int smallIndex = partition(array, start, end);
    if (smallIndex > start)
        QuickSort(array, start, smallIndex - 1);
    if (smallIndex < end)
        QuickSort(array, smallIndex + 1, end);
    return array;
}
/**
 * 快速排序算法——partition
 * @param array
 * @param start
 * @param end
 * @return
 */
public static int partition(int[] array, int start, int end) {
    int pivot = (int) (start + Math.random() * (end - start + 1));
    int smallIndex = start - 1;
    swap(array, pivot, end);
    for (int i = start; i <= end; i++)
        if (array[i] <= array[end]) {
            smallIndex++;
            if (i > smallIndex)
                swap(array, i, smallIndex);
        }
    return smallIndex;
}
 
/**
 * 交换数组内两个元素
 * @param array
 * @param i
 * @param j
 */
public static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}
```



##### 插入排序

###### 【简单插入排序】

>时间复杂度（平均/最坏/最好）：O(n2) /O(n2) /O(n) 
>
>空间复杂度：O(1)
>
>稳定性：稳定

```java
/**
 * 简单插入排序方法
 * @param array
 * @param lenth
 * @return
 */
public static void  insert_sort(int array[],int lenth){
   int temp;
   for(int i=0;i<lenth-1;i++){
       for(int j=i+1;j>0;j--){
           if(array[j] < array[j-1]){
               temp = array[j-1];
               array[j-1] = array[j];
               array[j] = temp;
           }else{         //不需要交换
               break;
           }
       }
   }
}
```



###### 【希尔排序】

>时间复杂度（平均/最坏/最好）：O(n1.3) /O(n2) /O(n) 
>
>空间复杂度：O(1)
>
>稳定性：不稳定

```java
/**
 * 希尔排序方法
 * @param array
 * @param lenth
 * @return
 */
public static void shell_sort(int array[],int lenth){

   int temp = 0;
   int incre = lenth;

   while(true){
       incre = incre/2;

       for(int k = 0;k<incre;k++){    //根据增量分为若干子序列

           for(int i=k+incre;i<lenth;i+=incre){

               for(int j=i;j>k;j-=incre){
                   if(array[j]<array[j-incre]){
                       temp = array[j-incre];
                       array[j-incre] = array[j];
                       array[j] = temp;
                   }else{
                       break;
                   }
               }
           }
       }

       if(incre == 1){
           break;
       }
   }
}
```



##### 选择排序

###### 【简单选择排序】

>时间复杂度（平均/最坏/最好）：O(n2) /O(n2) /O(n2) 
>
>空间复杂度：O(1)
>
>稳定性：不稳定

```java
/**
 * 简单选择排序方法
 * @param array
 * @param lenth
 * @return
 */
public static void select_sort(int array[],int lenth){

   for(int i=0;i<lenth-1;i++){
       int minIndex = i;
       for(int j=i+1;j<lenth;j++){
          if(array[j]<array[minIndex]){
              minIndex = j;
          }
       }
       if(minIndex != i){
           int temp = array[i];
           array[i] = array[minIndex];
           array[minIndex] = temp;
       }
   }
}
```

###### 【堆排序】

>时间复杂度（平均/最坏/最好）：O(nlogn) /O(nlogn) /O(nlogn) 
>
>空间复杂度：O(1)
>
>稳定性：不稳定

```java
	//声明全局变量，用于记录数组array的长度；
	public static int len;
    /**
     * 堆排序算法
     *
     * @param array
     * @return
     */
    public static int[] HeapSort(int[] array) {
        len = array.length;
        if (len < 1) return array;
        //1.构建一个最大堆
        buildMaxHeap(array);
        //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
        }
        return array;
    }
    /**
     * 建立最大堆
     *
     * @param array
     */
    public static void buildMaxHeap(int[] array) {
        //从最后一个非叶子节点开始向上构造最大堆
        for (int i = (len/2 - 1); i >= 0; i--) { //感谢 @让我发会呆 网友的提醒，此处应该为 i = (len/2 - 1) 
            adjustHeap(array, i);
        }
    }
    /**
     * 调整使之成为最大堆
     *
     * @param array
     * @param i
     */
    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i * 2 < len && array[i * 2] > array[maxIndex])
            maxIndex = i * 2;
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex])
            maxIndex = i * 2 + 1;
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }
```



##### 归并排序

###### 【二路归并排序】

>时间复杂度（平均/最坏/最好）：O(nlogn) /O(nlogn) /O(nlogn) 
>
>空间复杂度：O(n)
>
>稳定性：稳定

```java
 	/**
     * 归并排序
     *
     * @param array
     * @return
     */
    public static int[] MergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }
    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }
```



###### 【多路归并排序】【外部排序】

>时间复杂度（平均/最坏/最好）：O(nlogn) /O(nlogn) /O(nlogn) 
>
>空间复杂度：O(n)
>
>稳定性：稳定



#### 非比较类排序

###### 【计数排序】

>时间复杂度（平均/最坏/最好）：O(n+k) /O(n+k) /O(n+k) 
>
>空间复杂度：O(n+k)
>
>稳定性：稳定

```java
	/**
     * 计数排序
     *
     * @param array
     * @return
     */
    public static int[] CountingSort(int[] array) {
        if (array.length == 0) return array;
        int bias, min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] + bias]++;
        }
        int index = 0, i = 0;
        while (index < array.length) {
            if (bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            } else
                i++;
        }
        return array;
    }
```



###### 【桶排序】

>时间复杂度（平均/最坏/最好）：O(n+k) /O(n2) /O(n) 
>
>空间复杂度：O(n+k)
>
>稳定性：稳定

```java
	/**
     * 桶排序
     * 
     * @param array
     * @param bucketSize
     * @return
     */
    public static ArrayList<Integer> BucketSort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2)
            return array;
        int max = array.get(0), min = array.get(0);
        // 找到最大值最小值
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max)
                max = array.get(i);
            if (array.get(i) < min)
                min = array.get(i);
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1) { // 如果带排序数组中有重复数字时  感谢 @见风任然是风 朋友指出错误
                for (int j = 0; j < bucketArr.get(i).size(); j++)
                    resultArr.add(bucketArr.get(i).get(j));
            } else {
                if (bucketCount == 1)
                    bucketSize--;
                ArrayList<Integer> temp = BucketSort(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++)
                    resultArr.add(temp.get(j));
            }
        }
        return resultArr;
    }
```



###### 【基数排序】

>时间复杂度（平均/最坏/最好）：O(n*k) /O(n*k) /O(n*k) 
>
>空间复杂度：O(n+k)
>
>稳定性：稳定

```java
	/**
     * 基数排序
     * @param array
     * @return
     */
    public static int[] RadixSort(int[] array) {
        if (array == null || array.length < 2)
            return array;
        // 1.先算出最大数的位数；
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++)
            bucketList.add(new ArrayList<Integer>());
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++)
                    array[index++] = bucketList.get(j).get(k);
                bucketList.get(j).clear();
            }
        }
        return array;
    }

```

