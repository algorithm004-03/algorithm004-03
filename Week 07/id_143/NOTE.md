# 算法训练营学习
# 第七周
## 第十六课
### 位运算
1. 位运算符

|含义|运算符|示例|备注|
|:---|:---:|---:|---:|
| 左移|<<|0011 -> 0110|	乘以2|
|右移|>>|0110 -> 0011|	除以2|
|按位或|\||0011 \| 1011| 结果 1011|
|按位与|&|0011 & 1011| 结果 0011|
|取反|~|0011| 结果 1100|
|按位异或|^|0011 ^ 1011| 结果 1000|

2. 异或运算特点:
  - x ^ 0 = x
  - x ^ 1s = ~x // 1s为全1, 全1相当于0取反(~0)
  - x ^ (~x) = 1s
  - x ^ x = 0
  - c = a ^ b => a ^ c = b, b ^ c = a // 交换两个数
  - a ^ b ^ c = a ^ ( b ^ c ) = ( a ^ b ) ^ c // 结合律
3. 指定位置的位运算

|项目|公式|说明|
|:---|:---:|---:|
|将x最右边的n位清零|x & (~0 << n)|0与任何数(0,1)为0;任何数(0,1)与1相与保持不变。|
|获取x的第n个位的值(0或者1)|	(x >> n) & 1|与上同理,仅比较1个位|
|获取x的第n次幂|	x & (1 << (n - 1))|该位为1,其它位全为0|
|仅将第n位, 置为1|	x \| (1 << n)||
|仅将第n为, 置为0|	x & ( ~(1 << n))||
|将x最高位至第n位(含)清零|	x & ((1 << n) - 1)||
|将第n位至第0位(含)清零|	x & (~((1<< (n + 1)) - 1))||

4. 实战常用技巧
  - 奇偶判断
    ```
    x % 2 == 1 -> (x & 1) == 1
    x % 2 == 0 -> (x & 1) == 0
    ````
  - 除以2
    ```
    x / 2 -> x >> 1
    mid = (left + right) / 2 -> mid = (left + right) >> 1
    ```
  - *清零最低位的1*
    ```
    x = x & (x - 1)
    太常用,比较难想到。
    ```
  - *得到最低位的1*
    ```
    x & -x
    ```
  - 与自己取反再与,实现清0
    ```
    x & ~x = 0
    ```
## 第十七课
### 布隆过滤器和LRU缓存
#### 布隆过滤器特性
1. 一个很长的二进制向量和一系列的随机映射函数
2. 可以用于检索一个元素是否在一个集合中
3. 优点：空间效率和查询时间都远远超过一般的算法
4. 缺点：有一定的误识别率和删除困扰
5. 总结：
    > 可百分之百判断元素不存在于集合中，但不可准确判断元素存在集合中，故一般用于前置缓存（模糊判断）,这里解释一下,即在真正进入缓存之前的判断。

6. 案例：
    > 比特币、分布式系统、Redis缓存、垃圾邮件和评论的过滤等
#### LRU(Least Recently Used) Cahce特点
1. 两个要素：缓存大小、替换策略
2. 总结：
    >淘汰最远使用的元素

## 第十八课
### 排序算法
1. 比较类排序
2. 非比较类排序
3. 常用算法复杂度总表

|排序算法|平均时间复杂度|最坏时间复杂度|最好时间复杂度|	空间复杂度|	是否稳定|
|:---|:---|:---|:---|:---|:---|
|冒泡排序|O（n^2)  |O（n^2）|O（n）|O（1）|	是|
|选择排序	|O（n^2） |O（n^2）|O（n^2）|O（1）|	不是|
|插入排序	|O（n^2） |O（n^2）|O（n）|	O（1）|	是|
|希尔排序	|O（n^1.3） |O（n^2）|O（n）|	O（1）|	不是|
|归并排序	|O(nlogn)  |O(nlogn)|O(nlogn)|	O（n）|	是|
|快速排序|O(nlogn)|	O（n^2）|O(nlogn)|	O(nlogn)）|	不是|
|堆排序	|O(nlogn)|O(nlogn)|O(nlogn)|O（1）|	不是|
|计数排序	|O(n+k)	|O(n+k)|O(n+k)|O(n+k)	|是|
|桶排序|	O(n+k)	|O(n^2)|O(n)|O(n+k)	|是|
|基数排序	|O(n∗k)|O(n∗k)|	O(n∗k)|	O(n+k)|	是|

#### 选择排序(O(n^2))
1. 算法描述
    > 每次找最小值，然后放到排序数组的起始位置

2. 选择排序代码示例
    ```
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
#### 冒泡排序(O(n^2))
1. 算法描述
    > 嵌套循环，每次查看相邻的元素，若逆序，则交换。

2. 冒泡排序代码示例
    ```
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

#### 插入排序(O(n^2))
1. 算法描述
    > 从前往后逐步构建有序序列；对于未排序数据，在已排序序列中从后往前扫描，找到相应位置并插入。

2. 插入排序代码示例
    ```
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

#### 希尔排序（Shell Sort）平均(O(n^1.3))最坏(O(n^2))最好(O(n))
> 1959年Shell发明，第一个突破O(n2)的排序算法，是简单插入排序的改进版。它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
1. 算法描述
    先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
    - 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
    - 按增量序列个数k，对序列进行k 趟排序；
    - 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。

2. 希尔排序代码示例
    ```
    function shellSort(arr) {
        var len = arr.length;
        for (var gap = Math.floor(len / 2); gap > 0; gap = Math.floor(gap / 2)) {
            // 注意：这里和动图演示的不一样，动图是分组执行，实际操作是多个分组交替执行
            for (var i = gap; i < len; i++) {
                var j = i;
                var current = arr[i];
                while (j - gap >= 0 && current < arr[j - gap]) {
                     arr[j] = arr[j - gap];
                     j = j - gap;
                }
                arr[j] = current;
            }
        }
        return arr;
    }
    ```
3. 算法分析
    > 希尔排序的核心在于间隔序列的设定。既可以提前设定好间隔序列，也可以动态的定义间隔序列。动态定义间隔序列的算法是《算法（第4版）》的合著者Robert Sedgewick提出的。


#### 归并排序（Merge Sort）(O(nlogn))
> 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
1. 算法描述
    - 把长度为n的输入序列分成两个长度为n/2的子序列；
    - 对这两个子序列分别采用归并排序；
    - 将两个排序好的子序列合并成一个最终的排序序列。

2. 归并排序代码示例
    ```
    public static void mergeSort(int[] nums,int begin,int end){
        //终止条件
        if(begin <= end)return;
        //下钻
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
        // 也可以用 System.arraycopy(a, start1, b, start2, length);
        // System.arraycopy(tmp, 0, arr, left, tmp.length);
    }
    ```
3. 算法复杂度分析
    > 归并排序是一种稳定的排序方法。和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是O(nlogn）的时间复杂度。代价是需要额外的内存空间。
#### 快速排序(O(nlogn)) 简称快排
> 数组取标杆pivot, 将小元素放在pivot左边, 大元素放右侧, 然后依次对左边和右边的子数组进行快排, 从而达到整个数组有序。
1. 算法描述
    - 从数列中挑出一个元素，称为 “基准”（pivot）；
    - 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
    - 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
2. 快速排序代码示例
    ```
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
3. 快排与归并排序的比较与总结:
> 1. 归并: 先排序左右子数组, 然后合并2个有序数组
> 2. 快排: 先调配出左右子数组, 然后对于左右子数组进行排序

#### 堆排序 Heap Sort:插入 O(longN), 取最大/最小值 O(1)
> 1. 数组元素依次建立大|小顶堆依次取堆顶元素, 并删除。
> 2. 堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
1. 算法描述
    - 将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
    - 将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
    - 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
2. 堆排序代码示例
    ```
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

#### 计数排序（Counting Sort）
> 计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
1. 算法描述
    - 找出待排序的数组中最大和最小的元素；
    - 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
    - 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
    - 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
2. 计数排序代码示例(js)
    ```
    function countingSort(arr, maxValue) {
        var bucket = new Array(maxValue + 1),
            sortedIndex = 0;
            arrLen = arr.length,
            bucketLen = maxValue + 1;

        for (var i = 0; i < arrLen; i++) {
            if (!bucket[arr[i]]) {
                bucket[arr[i]] = 0;
            }
            bucket[arr[i]]++;
        }

        for (var j = 0; j < bucketLen; j++) {
            while(bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }

        return arr;
    }
    ```
3. 算法复杂度分析
    >计数排序是一个稳定的排序算法。当输入的元素是 n 个 0到 k 之间的整数时，时间复杂度是O(n+k)，空间复杂度也是O(n+k)，其排序速度快于任何比较排序算法。当k不是很大并且序列比较集中时，计数排序是一个很有效的排序算法。

#### 桶排序（Bucket Sort）
> 桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）。
1. 算法描述
    - 设置一个定量的数组当作空桶；
    - 遍历输入数据，并且把数据一个一个放到对应的桶里去；
    - 对每个不是空的桶进行排序；
    - 从不是空的桶里把排好序的数据拼接起来。
2. 桶排序代码示例(js)
    ```
    function bucketSort(arr, bucketSize) {
        if (arr.length === 0) {
          return arr;
        }

        var i;
        var minValue = arr[0];
        var maxValue = arr[0];
        for (i = 1; i < arr.length; i++) {
          if (arr[i] < minValue) {
              minValue = arr[i];                // 输入数据的最小值
          } else if (arr[i] > maxValue) {
              maxValue = arr[i];                // 输入数据的最大值
          }
        }

        // 桶的初始化
        var DEFAULT_BUCKET_SIZE = 5;            // 设置桶的默认数量为5
        bucketSize = bucketSize || DEFAULT_BUCKET_SIZE;
        var bucketCount = Math.floor((maxValue - minValue) / bucketSize) + 1;
        var buckets = new Array(bucketCount);
        for (i = 0; i < buckets.length; i++) {
            buckets[i] = [];
        }

        // 利用映射函数将数据分配到各个桶中
        for (i = 0; i < arr.length; i++) {
            buckets[Math.floor((arr[i] - minValue) / bucketSize)].push(arr[i]);
        }

        arr.length = 0;
        for (i = 0; i < buckets.length; i++) {
            insertionSort(buckets[i]);                      // 对每个桶进行排序，这里使用了插入排序
            for (var j = 0; j < buckets[i].length; j++) {
                arr.push(buckets[i][j]);
            }
        }

        return arr;
    }
    ```
3. 算法复杂度分析
    > 桶排序最好情况下使用线性时间O(n)，桶排序的时间复杂度，取决与对各个桶之间数据进行排序的时间复杂度，因为其它部分的时间复杂度都为O(n)。很显然，桶划分的越小，各个桶之间的数据越少，排序所用的时间也会越少。但相应的空间消耗就会增大。

#### 基数排序（Radix Sort）
> 基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。
1. 算法描述
    - 取得数组中的最大数，并取得位数；
    - arr为原始数组，从最低位开始取每个位组成radix数组；
    - 对radix进行计数排序（利用计数排序适用于小范围数的特点）；
2. 基数排序代码示例(js)
    ```
    var counter = [];
    function radixSort(arr, maxDigit) {
        var mod = 10;
        var dev = 1;
        for (var i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            for(var j = 0; j < arr.length; j++) {
                var bucket = parseInt((arr[j] % mod) / dev);
                if(counter[bucket]==null) {
                    counter[bucket] = [];
                }
                counter[bucket].push(arr[j]);
            }
            var pos = 0;
            for(var j = 0; j < counter.length; j++) {
                var value = null;
                if(counter[j]!=null) {
                    while ((value = counter[j].shift()) != null) {
                          arr[pos++] = value;
                    }
              }
            }
        }
        return arr;
    }
    ```
3. 算法复杂度分析
    > 基数排序基于分别排序，分别收集，所以是稳定的。但基数排序的性能比桶排序要略差，每一次关键字的桶分配都需要O(n)的时间复杂度，而且分配之后得到新的关键字序列又需要O(n)的时间复杂度。假如待排数据可以分为d个关键字，则基数排序的时间复杂度将是O(d*2n) ，当然d要远远小于n，因此基本上还是线性级别的。

      基数排序的空间复杂度为O(n+k)，其中k为桶的数量。一般来说n>>k，因此额外空间需要大概n个左右。



## 个人感悟
  - **课程学习计划问题**: 年底,各项任务交付压力过大,一周能抽出的时间太少,排好计划,准备重扫几次。
  - **练习问题**: 五毒神掌,真金不怕火炼。
  - 团队问题: 定期"**叫醒**"服务。团队方面,除了在坚持的,就是没有在坚持的。大家都忙,希望有时间还是回来系统性学习较好!

  

