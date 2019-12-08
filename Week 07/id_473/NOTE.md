# 第七周学习总结

#### 位运算


- 位运算符
  - 左移 <<   (0110 << 1100)
  - 右移 >>   (0110 >> 0011)
  - 与 &      (0011 & 1011 = 0011)
  - 或 |      (0011 | 1011 = 1011)
  - 取反 ~    (~0011 = 1100)
  - 异或 ^    (0011 ^ 1011 = 1000)
- 算数移位与逻辑移位
- 位运算的应用


#### 布隆过滤器

优点：空间效率和查询时间都远远超过一般的算法。

缺点：有一定的误识别率和删除困哪。

#### LRUCache
LRU : least recent use(最近最少使用的)
- 两个要素：大小、替换策略
- HashTable + Double LinkedList
- O(1)查询，
  O(1)修改、更新

#### 排序

初级排序实现（JAVA）：

冒泡排序：
```
    public static int[] bubbleSort(int[] array) {
          if (array.length == 0){
            return array;
          }
              
         for (int i = 0; i < array.length; i++){
             for (int j = 0; j < array.length - 1 - i; j++){
                 if (array[j + 1] < array[j]) {
                     int temp = array[j + 1];
                     array[j + 1] = array[j];
                     array[j] = temp;
                 }
             }         
         }
         return array;
    }
```

选择排序：
```
    public static int[] selectionSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) //找到最小的数
                    minIndex = j; //将最小数的索引保存
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

```

插入排序：
```

    public static int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
```
  

