# 第三周学习总结

## 思维

熟记DFS，BFS，二分查找的代码模板，然后根据具体情况慢慢调整。

## 二分查找的三个条件

1. 目标函数单调性（单调递增或者单调递减）
2. 存在上下便捷
3. 能够通过索引访问

## 贪心算法

贪心算法是一种在每一步选择中都才去当前最好或最优的选择，从而希望导致结果是全局最好或最优的算法。（贪心算法不一定全局最优，只在可以被证明的情况下可达到全局最优）

## 课后思考题

使用二分查找，寻找一个半有序数组[4, 5, 6, 7, 0, 1, 2]中间无序的地方

```
    public int searchRotateIndex(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
```


  

