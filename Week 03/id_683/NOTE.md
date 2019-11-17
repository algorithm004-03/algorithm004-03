# 第三周总结

## 深度优先与广度优先搜索

在遍历树和图时要保证

- 每个节点都要访问到
- 每个节点最好仅访问一次
- 对节点的访问顺序没有要求

此时就可以用到深度优先搜索和广度优先搜索

比如二叉树的中序遍历就是深度优先搜索，先沿着一个分治一直走到尽头再回溯进行另一个分之的遍历。而广度优先搜索顾名思义，就是像水波纹一样，先将所有分支访问到，再对访问到的分支一次进行同样的操作。


## 贪婪算法

贪婪算法的用武之地比较少，要求的条件比较苛刻，其应用最大的问题往往是证明贪婪可以得到最优解。在运用贪婪算法时重要的是找好贪婪的方式，是从头开始还是从末尾往回进行，甚至从中间某个切入点进行贪婪。

## 二分法

二分查找应用的前提：

- 目标存在单调性
- 存在上下界
- 能够通过索引访问



## 使用二分查找，找到半有序数组中间无序的地方

这个问题，本质上就是查找数组中最小值的下标，第一个问题使在二分的过程中讨论向左规约还是向右规约：

- 当mid左边是单调递增时(nums[0] < nums[mid])，向右规约
- 当mid左边不具有单调性时(nums[0] > nums[mid])，向坐规约

每次循环通过判断mid和左右相邻值的大小来判断是否找到最小值

代码如下所示：

    public static int widget(int[] nums) {
        if (nums == null) return -1;
        int left = 0;
        int right = nums.length - 1;
        if (left == right) return nums[left];
        if (nums[right] > nums[0]) return 0;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return mid;
            }
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }
            if (nums[0] < nums[mid]) {
                left = mid + 1;
            } else if (nums[0] > nums[mid]) {
                right = mid - 1;
            }
        }
        return -1;
    }



