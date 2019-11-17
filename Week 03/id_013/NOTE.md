>  笔记内容为整理其他技术博客资料

二分查找法作为一种常见的查找方法，将原本是线性时间提升到了对数时间范围，大大缩短了搜索时间，但它有一个前提，就是必须在有序数据中进行查找。

二分查找很好写，却很难写对，据统计只有10%的程序员可以写出没有bug的的二分查找代码。出错原因主要集中在判定条件和边界值的选择上，很容易就会导致越界或者死循环的情况。

下面对二分查找及其变形进行总结：

## **1. 最基本的二分查找**

```java
public int binarySearch(int[] A, int target, int n){
    int low = 0, high = n, mid;
    while(low <= high){
        mid = low + (high - low) / 2;
        if(A[mid] == target){
            return mid;
        }else if(A[mid] > target){
            high = mid - 1;
        }else{
            low = mid + 1;
        }
    }
    return -1;
}
```

其中，有几个要注意的点：
\1. 循环的判定条件是：`low <= high`
\2. 为了防止数值溢出，`mid = low + (high - low)/2`
\3. 当 `A[mid]`不等于`target`时，`high = mid - 1`或`low = mid + 1`

> leetcode参考：[Search Insert Position](https://link.zhihu.com/?target=https%3A//leetcode.com/problems/search-insert-position/description/)

## **2. 查找目标值区域的左边界/查找与目标值相等的第一个位置/查找第一个不小于目标值数的位置**

> A = [1,3,3,5, **7** ,7,7,7,8,14,14]
> target = 7
> return 4

```java
public int binarySearchLowerBound(int[] A, int target, int n){
    int low = 0, high = n, mid;
    while(low <= high){
        mid = low + (high - low) / 2;
        if(target <= A[mid]){
            high = mid - 1;
        }else{
            low = mid + 1;
        }
    }
    if(low < A.length && A[low] == target)
        return low;
    else
        return -1;
}
```

## **3. 查找目标值区域的右边界/查找与目标值相等的最后一个位置/查找最后一个不大于目标值数的位置**

> A = [1,3,3,5,7,7,7, **7** ,8,14,14]
> target = 7
> return 7

```java
public int binarySearchUpperBound(int[] A, int target, int n){
    int low = 0, high = n, mid;
    while(low <= high){
        mid = low + (high - low) / 2;
        if(target >= A[mid]){
            low = mid + 1;
        }else{
            high = mid - 1;
        }
    }
    if(high >= 0 && A[high] == target)
        return high;
    else
        return -1;
}
```

此题以可变形为`查找第一个大于目标值的数/查找比目标值大但是最接近目标值的数`，我们已经找到了最后一个不大于目标值的数，那么再往后进一位，返回`high + 1`，就是第一个大于目标值的数。

> 剑指offer：[数字在排序数组中出现的次数](https://link.zhihu.com/?target=https%3A//weiweiblog.cn/getnumberofk/)

## **4. 查找最后一个小于目标值的数/查找比目标值小但是最接近目标值的数**

此题以可由第 2 题变形而来，我们已经找到了目标值区域的下（左）边界，那么再往左退一位，即`low - 1`，就是最后一个小于目标值的数。其实`low - 1`也是退出循环后`high`的值，因为此时 `high`刚好等于`low - 1`，它小于`low`，所以 while 循环结束。我们只要判断`high`是否超出边界即可。

> A = [1,3,3, **5** ,7,7,7,7,8,14,14]
> target = 7
> return 3

```java
int low = 0, high = n, mid;
while(low <= high){
    mid = low + (high - low) / 2;
    if(target <= A[mid]){
        high = mid - 1;
    }else{
        low = mid + 1;
    }
}
return high < 0 ? -1 : high;
```

## **5. 查找第一个大于目标值的数/查找比目标值大但是最接近目标值的数**

此题以可由第 3 题变形而来，我们已经找到了目标值区域的上（右）边界，那么再往右进一位，即`high + 1`，就是第一个大于目标值的数。其实`high + 1`也是退出循环后`low`的值，因为此时 `low`刚好等于`high + 1`，它大于`high`，所以 while 循环结束。我们只要判断`low`是否超出边界即可。

> A = [1,3,3,5,7,7,7,7, **8** ,14,14]
> target = 7
> return 8

```java
int low = 0, high = n, mid;
while(low <= high){
    mid = low + (high - low) / 2;
    if(target >= A[mid]){
        low = mid + 1;
    }else{
        high = mid - 1;
    }
}
return low > n ? -1 : low;
```

## **6. 旋转数组返回最小元素**

## **6.1 查找旋转数组的最小元素（假设不存在重复数字）**

> LeetCode: [Find Minimum in Rotated Sorted Array](https://link.zhihu.com/?target=https%3A//leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
> Input: [3,4,5,**1**,2]
> Output: 1

```java
public int findMin(int[] nums) {
    int len = nums.length;
    if(len == 0)
        return -1;
    int left = 0, right = len - 1, mid;

    while(left < right){
        mid = left + (right - left) / 2;
        if(nums[mid] > nums[right])
            left = mid + 1;
        else{
            right = mid;
        }
    }
    return nums[left];
}
```

注意这里和之前的二分查找的几点区别：
\1. 循环判定条件为`left < right`，没有等于号
\2. 循环中，通过比较nums[left]与num[mid]的值来判断mid所在的位置:

- 如果`nums[mid] > nums[right]`，说明前半部分是有序的，最小值在后半部分，令`left = mid + 1`；
- 如果`nums[mid] <= num[right]`，说明最小值在前半部分，令`right = mid`。

最后，left会指向最小值元素所在的位置。

## **6.2 查找旋转数组的最小元素（存在重复项）**

> LeetCode: [Find Minimum in Rotated Sorted Array II](https://link.zhihu.com/?target=https%3A//leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii)
> 剑指offer：[旋转数组的最小数字](https://link.zhihu.com/?target=https%3A//weiweiblog.cn/minnumberinrotatearray/)
> Input: [2,2,2,**0**,1]
> Output: 0

```java
public int findMin(int[] nums) {
    int len = nums.length;
    if(len == 0)
        return -1;
    int left = 0, right = len - 1, mid;
    while(left < right){
        mid = left + (right - left) / 2;
        if(nums[mid] > nums[right])
            left = mid + 1;
        else if(nums[mid] < nums[right])
            right = mid;
        else
            right--;
    }
    return nums[left];
}
```

和之前不存在重复项的差别是：当`nums[mid] == nums[right]`时，我们不能确定最小值在 `mid`的左边还是右边，所以我们就让右边界减一。

## **7. 在旋转排序数组中搜索**

## **7.1 不考虑重复项**

> LeetCode: [Search in Rotated Sorted Array](https://link.zhihu.com/?target=https%3A//leetcode.com/problems/search-in-rotated-sorted-array)

法一：

- 先利用方法 6.1 查找数组中的最小元素，即确定分界点的位置
- 把旋转的数组当成偏移，用`(offset + mid) % len`来求真实的 mid 的位置。
- 然后用二分查找来定位目标值

```java
public int search(int[] nums, int target) {
    int len = nums.length;
    if(len == 0)
        return -1;
    int left = 0, right = len - 1, mid;
    while(left < right){
        mid = left + (right - left) / 2;
        if(nums[mid] > nums[right])
            left = mid + 1;
        else
            right = mid;
    }
    int offset = left;
    left = 0;
    right = len - 1;
    while(left <= right){
        mid = left + (right - left) / 2;
        int realmid = (mid + offset) % len;
        if(nums[realmid] == target)
            return realmid;
        else if(nums[realmid] < target)
            left = mid + 1;
        else
            right = mid - 1;
    }
    return -1;
}
```

法二：其实没有必要找到旋转数组的分界点，对于搜索左侧还是右侧我们是可以根据mid跟high的元素大小来判定出来的，直接根据target的值做二分搜索就可以了。

```java
public int search(int[] nums, int target) {
    int len = nums.length;
    if(len == 0)
        return -1;
    int left = 0, right = len - 1, mid;
    while(left <= right){
        mid = left + (right - left) / 2;
        if(nums[mid] == target)
            return mid;
        else if(nums[left] <= nums[mid]){
            if(target < nums[mid] && target >= nums[left])
                right = mid - 1;
            else
                left = mid + 1;
        }else if(nums[mid] <= nums[right]){
            if(target > nums[mid] && target <= nums[right])
                left = mid + 1;
            else
                right = mid - 1;
        }
    }
    return -1;
}
```

## **7.2 存在重复项**

> LeetCode: [Search in Rotated Sorted Array II](https://link.zhihu.com/?target=https%3A//leetcode.com/problems/search-in-rotated-sorted-array-ii/)

```java
public boolean search(int[] nums, int target) {
    int len = nums.length;
    if(len == 0)
        return false;
    int left = 0, right = len - 1, mid;
    while(left <= right){
        mid = left + (right - left) / 2;
        if(nums[mid] == target)
            return true;
        else if(nums[mid] > nums[right]){
            if(target < nums[mid] && target >= nums[left])
                right = mid;
            else
                left = mid + 1;
        }else if(nums[mid] < nums[right]){
            if(target > nums[mid] && target <= nums[right])
                left = mid + 1;
            else
                right = mid;
        }else{
            right --;
        }   
    }
    return false;
}
```

## **8. 二维数组中的查找**

> 剑指offer：[二维数组中的查找](https://link.zhihu.com/?target=https%3A//weiweiblog.cn/find2array/)

二维数组是有序的，从右上角来看，向左数字递减，向下数字递增。因此可以利用二分查找的思想，从右上角出发：

- 当要查找数字比右上角数字大时，下移；
- 当要查找数字比右上角数字小时，左移；



### 思考题

思路：

还是二分查找，比较中间值与左右两边届值的大小，确定有序部分在哪一块，递归这个过程。