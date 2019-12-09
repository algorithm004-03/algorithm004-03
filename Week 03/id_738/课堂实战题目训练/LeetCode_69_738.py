class Solution(object):
    def mySqrt(self, x):
        """
        x的平方根:https://leetcode-cn.com/problems/sqrtx/
        
        :type x: int
        :rtype: int
        """
        # 二分查找写法2：
        if x == 0 :
            return 0
        left, right = 0, x
        while left < right:
            mid = left + (right - left) // 2
            t = mid * mid
            if t == x:
                return mid
            elif t > x:
                right = mid - 1
            else:
                left = mid + 1
        
        # 这里的return:当while循环最后一次是 left mid right 都相差一的时候，比如8的平方根最后第二次while的时候是 left = 2， mid = 3,  right = 4，跳出while后就是 left = right = 3，这时候3并不是最后结果。
        # 因为right并不能确定是否是大于x（当然right后面数字平方的肯定大于x），所以应该改成 return (int)(right * right > x ? right - 1 : right); 如果right的平方大于x，则right-1肯定是结果。如果right^2 < x，那么返回right。
        return left if left * left <= x else left - 1
            
        
        # 二分查找写法1：因为x的平方根r:0 < r <= x，我们可以从递增序列0到x中，通过二分查找，定位到r的位置
        # 这里二分查找需要一些技巧，尤其是最后的返回，有一定逻辑，看下面注释
        # if x == 0 or x == 1:
        #     return x
        # L, R = 1, x
        # # 下面while循环
        # # 1. 找到平方根，返回
        # # 2. 没有整数平方根，最终到达L = R或者L > R的时候会退出循环
        # while L < R:
        #     # mid为 L和R的中间值取下界整数
        #     mid = L + (R - L) // 2
        #     mid2 = mid * mid
        #     if mid2 == x: # 此时找到平方根直接返回
        #         return mid
        #     elif mid2 > x: # 中点mid^2 > x表示x的平方根落在L到mid-1的位置
        #         R = mid - 1 
        #     elif mid2 < x: # 中点mid^2 < x表示x的平方根落在mid + 1到L的位置
        #         L = mid + 1
        # # 能够来到这里，表示没有整数平方根，而且 L >= R
        # if L == R: 
        #     # 如果 L == R的情况，表示结果不是L就是L - 1只要取L 和 L-1 中平方最接近x的那个即可
        #     return L if L * L <= x else L - 1
        # elif L > R: 
        #     # 如果L > R的情况，表示循环最后一个mid肯定是下面情况之一
        #     # 1. mid为L，而且L^2 == mid^2 > x，而且L左边的数字的平方肯定<x，也就是说<=L的数字的平方都<x，>L的数字的平方都>x
        #     # 2. mid为R，而且R^2 == mid^2 < x，而且R右边的数字的平方肯定>x，也就是<=R的数字的平方都<x，>R的数字的平方都>x
        #     # 只有上面两种情况之一，才会出现L > R的情况
        #     # 而此时R肯定落在上面1情况的L的左边，或者情况2的R位置
        #     # 所以此时R肯定是最接近x的平方根且小于x的平方根的整数，所以返回R。。
        #     return R







        