# 学习总结
## 位运算
### 位运算符
含义 | 运算符 | 示例
---|---|---
左移 | << | 0011 --> 0100
右移 | >> | 0110 --> 0011
按位或 |\|| 0011\|1011 --> 1011
按位与 | & | 0011&1011 --> 0011
按位取反 | ~ | 0011 --> 1100
按位异或(同性相斥，异性相吸) | ^ | 0011^1011 --> 1000
### 指定位置的位运算
含义 | 操作
---|---
将x最右边的n位清零 | x & (~0 << n)
获取x的第n位的值(0或1) | (x >> n) & 1
获取x的第n位的幂值 | x & (1 << (n-1))
仅将第n位置为1 | x \| (1 << n) 
仅将第n位置为0 | x & (~(1 << n))
将x最高位至第n位（含）清零 | x & ((1 << n) -1)
将第n位至第0位（含）清零 | x & (~((1 << (n+1)) - 1))
### 实战位运算要点（重点）
1. 判断奇偶

含义 | 常规 | 位运算
---|---|---
判断偶数 | x % 2 == 0 | (x & 1) == 0
判断基数 | x % 2 == 1 | (x & 1) == 1

2. 除以2

常规 | 位运算
---|---
x / 2| x >> 1
int mid = (left + right)/2| int mid = (left + right) >> 1

3. 清零最低位的1（即：从第0位开始往前，第1个1置为0）
```
x = x & (x - 1)
```
4. 获取最低位的1（即：从第0位开始往前，获取第1个1）
```
x & (-x)
```
5. 取0
```
x & (~x)
```
### leetCode习题
[N皇后位运算实现模板](https://shimo.im/docs/rHTyt8hcpT6D9Tj8/read)

## 布隆过滤器和LRU缓存
### 布隆过滤器
* 一个很长的二进制向量和一系列的随机映射函数
* 可以用于检索一个元素是否在一个集合中
* **优点**：空间效率和查询时间都远远超过一般的算法
* **缺点**：有一定的误识别率和删除困扰
> 总结：可百分之百判断元素不存在于集合中，但不可准确判断元素存在集合中，故一般用于前置缓存（模糊判断）。
* 案例：比特币、分布式系统、Redis缓存、垃圾邮件和评论的过滤等
### LRU(Least Recently Used) Cahce
* 两个要素：大小、替换策略
> 总结：淘汰最远使用的元素
## 排序算法
### 概述（脑图）
1. 比较类排序
2. 非比较排序
### 重点掌握的排序算法
#### 选择排序(O(n^2))
> 每次找最小值，然后放到排序数组的起始位置
```java
//选择排序
public static void selectionSort(int[] nums){
    for(int i = 0;i< nums.length;i++){
        //最小值
        int m = i;
        int min = Integer.MAX_VALUE;
        for(int j = i;j < nums.length;j++){
            if(nums[j] < min){
                m = j;
                min = nums[j];
            }
        }
        nums[m] = nums[i];
        nums[i] = min;
    }
}
```
#### 插入排序(O(n^2))
> 从前往后逐步构建有序序列；对于未排序数据，在已排序序列中从后往前扫描，找到相应位置并插入。
```java
//插入排序
public static void insertionSort(int[] nums){
    for(int i = 0;i < nums.length;i++){
        int curr = nums[i];
        for(int j = i;j > 0;j--){
            if(curr >= nums[j-1]){
                break;
            }else{
                //后移一位
                nums[j] = nums[j-1];
                i--;
            }
        }
        nums[i] = curr;
    }
}
```
#### 冒泡排序(O(n^2))
> 嵌套循环，每次查看相邻的元素，若逆序，则交换。

```java
//冒泡排序
public static void bubbleSort(int[] nums){
    for(int i = 0;i < nums.length;i++){
        for(int j = 0;j < nums.length-i-1 ;j++){
            //比较相邻元素，若逆序
            if(nums[j] > nums[j+1]){
                //交换
                int tmp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = tmp;
            }
        }
    }
}
```
#### 归并排序(O(nlogn))
[归并排序模板](https://shimo.im/docs/YqgG6vtdKwkXJkWx/read)
```java
//归并
public static void mergeSort(int[] nums,int begin,int end){
    //终止条件
    if(begin <= end)return;
    //下坠
    int mid = (begin + end) >> 1;
    mergeSort(nums,begin,mid);
    mergeSort(nums,mid+1,end);
    //执行当前层逻辑，即合并两个有序数组
    merge(nums,begin,mid,end);
}

private static void merge(int[] nums, int begin, int mid, int end) {
    int[] tmp = new int[end-begin+1];
    int i = begin,j = mid+1,k = 0;
    while (i<=mid && j<=end){
        tmp[k++] = nums[i] <= nums[j]?nums[i++] : nums[j++];
    }
    while (i<=mid){
        tmp[k++] = nums[i++];
    }
    while (j<=end){
        tmp[k++] = nums[j++];
    }
    for(int p = 0;p < tmp.length;p++){
        nums[begin+p] = tmp[p];
    }
}
```
#### 快速排序(O(nlogn))
[快速排序模板](https://shimo.im/docs/98KjvGwwGpTpYGKy/read)
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
