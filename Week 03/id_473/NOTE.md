# 找出半有序数组被批断的位置

思路：与 搜索旋转排序数组 的解法类似，先判断哪一边为有序数，然后向反方向继续进行二分查找。
```
        int left = 0;
        int right = nums.length -1 ;
        int target = 0;
        while (left + 1 < right) {
            int mid = (left + right)>>>1;
            if (nums[left] < nums[mid]) {
                left = mid;
            }else if (nums[right] > mid){
                right = mid;
            }
            target = nums[mid];
        }
        if (nums[left] == target ){
            return left; 
        }else if ( nums[right] == target) {
            return right;
        }
        return -1;
```
---
# 第三周学习总结

- 深度优先搜索DFS：沿着树的深度遍历树的节点，当当前节点无子节点或不满足搜索条件时，回溯到上层节点的其他未搜索过的分支，直到搜索所有节点为止。

- 广度优先搜索BFS：以逐层式搜索遍历树的节点，当遍历至所有节点没有下一层子节点时则停止搜索。

- 贪心算法：
   - 建立模型描述问题
   - 把求解的问题分解成若干个子问题
   - 针对没一个子问题进行求解，得到的子问题的局部最优解
   - 把子问题的局部最优解合成原来问题的一个解

- 二分查找：
   - 需使用顺序存储机构或半序存储结构
   - 将数据一份为二，然后取中间的数据与前段或后段进行比较，当一段满足条件则缩小范围再次一分为二进行比较，直至找到匹配的数据为止。

  

