# 【593-Week 07】学习总结+初级排序代码

### 学习总结



#### 总结

#### 位运算

- X = X & (X-1) 清零最低位的 1
- X & -X => 得到最低位的 1
- jdk 代码很有意思的代码

	-     private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    // Packing and unpacking ctl
    private static int runStateOf(int c)     { return c & ~CAPACITY; }
    private static int workerCountOf(int c)  { return c & CAPACITY; }
    private static int ctlOf(int rs, int wc) { return rs | wc; }

#### LRU Cache

- 结构

	- hashMap + 双端链表

#### 排序算法

- 初级

	- 选择

		- 每次找最小值，然后放到待排序数组的起始位置。

	- 插入

		- 从前到后逐步构建有序序列;对于未排序数据，在已排序序列中从后 向前扫描，找到相应位置并插入。

	- 冒泡

		- 嵌套循环，每次查看相邻的元素如果逆序，则交换。

- 高级

	- 快排

		- 数组取标杆 pivot，将小元素放 pivot左边，大元素放右侧，然后依次 对右边和右边的子数组继续快排;以达到整个序列有序。

	- 归并排序

		- 1. 把长度为n的输入序列分成两个长度为n/2的子序列; 
		- 2. 对这两个子序列分别采用归并排序;
		- 3. 将两个排序好的子序列合并成一个最终的排序序列。

#### 排序代码

```java

/**
 * 初级排序
 *
 * @author jaryoung
 */
public class PrimarySort {

    /**
     * 选择排序：
     * 每次找最小值，然后放到待排序数组的起始位置。
     *
     * @param array 待排序 数组
     * @return 已经排好序的 数组
     */
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int mid = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[mid] > array[j]) {
                    mid = j;
                }
            }
            int temp = array[i];
            array[i] = array[mid];
            array[mid] = temp;
        }
        return array;
    }

    /**
     * 插入排序：
     * 从前到后逐步构建有序序列;对于未排序数据，在已排序序列中从后 向前扫描，找到相应位置并插入。
     *
     * @param array 待排序 数组
     * @return 已经排好序的 数组
     */
    public static int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int pre = i - 1;
            int current = array[i];
            while (pre >= 0 && current < array[pre]) {
                array[pre + 1] = array[pre];
                pre--;
            }
            array[pre + 1] = current;
        }
        return array;
    }

    /**
     * 冒泡排序：
     * 嵌套循环，每次查看相邻的元素如果逆序，则交换。
     *
     * @param array 待排序 数组
     * @return 已经排好序的 数组
     */
    public static int[] bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }


}

```



```java

/**
 * 高级一点的排序
 *
 * @author jaryoung
 */
public class AdvancedSort {

    /**
     * 快速排序：
     * 数组取标杆 pivot，将小元素放 pivot左边，大元素放右侧，然后依次 对右边和右边的子数组继续快排;以达到整个序列有序。
     *
     * @param array 待排序 数组
     * @return 已经排好序的 数组
     */
    public static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private static void quickSort(int[] array, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int begin, int end) {
        int count = begin;
        for (int i = begin; i < end; i++) {
            // 小于 end位置的数，都往左边移动
            if (array[i] < array[end]) {
                int temp = array[count];
                array[count] = array[i];
                array[i] = temp;
                // 作用一：不断记录和更新，小于end位置的数的下一个位置（小于end位置的数都在count之前了）
                // 作用二：为最后，跟定义的中间值，交换位置作准备
                count++;
            }
        }
        // end位置的数，跟count交换位置（count 之前的数都是小于end位置的数了）
        int temp = array[end];
        array[end] = array[count];
        array[count] = temp;
        return count;
    }

    /**
     * 1. 把长度为n的输入序列分成两个长度为n/2的子序列;
     * 2. 对这两个子序列分别采用归并排序;
     * 3. 将两个排序好的子序列合并成一个最终的排序序列。
     *
     * @param array 待排序 数组
     * @return 已经排好序的 数组
     */
    public static int[] mergeSort(int[] array) {
        if (array == null || array.length < 1) {
            return new int[0];
        }
        mergeSort(array, 0, array.length - 1);
        return array;
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = array[i] < array[j] ? array[i++] : array[j++];
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }
        System.arraycopy(temp, 0, array, left, temp.length);
    }


}

```

