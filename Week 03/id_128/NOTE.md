# NOTE


重新学习了斐波那契数列 （爬楼梯） 问题

top down 递归with memo 最易想到
bottom up 的 brute force 和 递归 
然后引申出 迭代形式的 O（1）空间的 斐波那契通常算法 - 由此又学习了尾递归 （线性递归时可以优化为尾递归）
继续深入 即 矩阵幂运算
f(n)
f(n-1)
|
f(n-1), f(n-2)
f(n-1)
|
1 * f(n-1), 1 * f(n-2)
1* f(n-1)， 0 * f(n-2)
|
1, 1     *    f(n-1)
1, 0          f(n-2)
|
1, 1  ^(n-1)   *  f(2)
1, 0              f(1)
|
1, 1  ^(n-1)   *  f(1)
1, 0              f(0)

即转化为求   1,1  的 n-1次矩阵幂 然后取左上第一项的值
            1,0

其中 求矩阵幂 又用到了 pow(n,x) （leetcode_50）的快速幂算法

快速幂算法 亦可 递归 或 迭代





本周的课程是对上周递归课程在几种细分问题的总结

DFS 一般递归 及通过循环与栈配合 模拟递归
BFS 循环与队列配合的变相递归

对图操作时 注意对访问过的节点的判断


贪心算法  + 回束  = 动态规划

局部最优解 -> 全局最优解 = 贪心， 局部次优解（通过回束） -> 全局最优解 = 动态规划

贪心是思路 - 要证明问题可以通过局部结论得出全局结论
贪心的技巧 - 如 反向贪心， 需要多做题 增长经验  

可以应用 二分搜索 的三要素
1 有序
2 有上下界
3 有索引



question: 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

即寻找 数组中最小值的下标- nums[i] > nums[i+1] 



//先找pivot point 即2遍二分查找
public class Solution
{
    public int SearchPivotPoint(int[] nums)
    {
        if (nums.Length <= 1) return -1;
        return FindPivotIndex(nums);
    }

    private int FindPivotIndex(int[] nums)
    {
        int start = 0;
        int end = nums.Length - 1;
        if (nums[start] < nums[end]) return 0;
        while (start <= end)
        {
            int mid = (start + end) / 2;
            if (nums[mid + 1] <= nums[mid])
            {
                return mid + 1;
            }
            else if (nums[mid] < nums[start])
            {
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        return 0;
    }
}



遗留内容

牛顿迭代法
并查集
更多的贪心习题
