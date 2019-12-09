# 第七周学习总结

## 位运算

异或操作的一些特点：

x ^ 0 = x

x ^ 1s = ~x

x ^ (~x) = 1s

x ^ x = 0

c = a ^ b => a ^ c = b, b ^ c = a 

a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c

## 布隆过滤器

- 作用：

	- 判断一个元素是否存在于集合中, 但是只能确定元素一定不在集合, 不能确定元素一定在集合

- 优点：

	- 空间效率和查询时间远远超过一半的算法

- 缺点：

	- 有一定的误识别率和删除困难


## 初级排序算法
  
### 选择排序

```
    private void selectionSort(int a[]) {

    	int n = a.length;
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n-1; i ++) {
            int leftLast = a[i];
            int j = i + 1;
            int tempUnsortedIndex = j;
            for (; j < n; j ++) {
                if (a[j] < a[tempUnsortedIndex]) {
                    tempUnsortedIndex = j;
                }
            }
            a[i] = a[tempUnsortedIndex];
            a[tempUnsortedIndex] = leftLast;
        }
    }
```

### 插入排序

```
    private void insertSort(int[] a) {
    	int n = a.length;
        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; i ++) {
            int tempValue = a[i];
            int j = i - 1;
            for (; j >= 0; j --) {
                if (tempValue < a[j]) {
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = tempValue;
        }
    }
```

### 冒泡排序

```
	private void bubbleSort(int[] valueArray) {

        // 如果数组个数小于等于1，则无需排序
        if (valueArray.length <= 1) {
            return;
        }

        for (int i = 0 ; i < valueArray.length; i ++) {
            boolean flag = false;
            for (int j = 0; j < valueArray.length - i - 1; j ++) {
                if (valueArray[j] > valueArray[j + 1]) {
                    int temp = valueArray[j];
                    valueArray[j] = valueArray[j + 1];
                    valueArray[j + 1] = temp;

                    flag = true;
                }
            }

            // 当某个冒泡没有交换的时候，说明已经达到完全有序
            if ( !flag) {
                break;
            }

        }
    }
```