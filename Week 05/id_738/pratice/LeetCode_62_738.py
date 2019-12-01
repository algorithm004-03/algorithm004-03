class Solution(object):
    def uniquePaths(self, m, n):
        """
        不同路径：https://leetcode-cn.com/problems/unique-paths/

        :type m: int
        :type n: int
        :rtype: int
        """
        # 正常逻辑：反序写法

        # array = [[1] * n for _ in range(m)]
        # for i in range(m - 1)[::-1]:
        #     for j in range(n - 1)[::-1]:
        #         array[i][j] = array[i][j + 1] + array[i + 1][j]
        # return array[0][0]
        
        # 改写成正序写法
        # a = [[1] * n for _ in range(m)]
        # for i in range(1, m):
        #     for j in range(1, n):
        #         a[i][j] = a[i - 1][j] + a[i][j - 1]
        # return a[m - 1][n - 1]
        
        # 是否可以优化存储空间
        # 正序写法中：考虑到，二维矩阵a每行的值都是从左往右求解
        # 而且求解行的某个值，肯定是上一个求解值和上一行该位置的值之和。
        # 比如：
        # 1 1 1
        # 1 2 3
        # 1 3 6
        # 可以看出，只用一个n的一维数组存储即可，不需要存储全部中间值：
        # a[j] += a[j - 1]
        a = [1] * n
        for i in range(1, m):
            for j in range(1, n):
                a[j] += a[j - 1]
        return a[-1]
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        


