class Solution(object):
    def myPow(self, x, n):
        """
        x的n次方：https://leetcode-cn.com/problems/powx-n/submissions/

        :type x: float
        :type n: int
        :rtype: float
        """
        #分治，每次用开根值的平方计算，复杂度logN
        # if n == 1:
        #     return x
        # if n == -1:
        #     return 1 / x
        if n == 0:
            return 1
        n1 = abs(n) / 2
        z = self.myPow(x, n1)
        if n % 2 == 0:
            z *= z
        else:
            z *= z * x
        if n < 0:
            return 1 / z
        elif n > 0:
            return z
        
        
        
        
        
        
        
        