class Solution(object):
    def countBits(self, num):
        """
        比特位计数：https://leetcode-cn.com/problems/counting-bits/description/

        :type num: int
        :rtype: List[int]
        """
        # 解法1：比较难推算出来
        # 本题如果要实现O(n)复杂度，必然需要通过前面的数推算后面的数
        # 所以涉及到动态规划
        # 观察规律：设一个数 i 的1的位数为 n.
        # 如果在 i 的二进制最左边的1位置的左边任意一位加多一个1，那么在二进制里面，这个数必然是 i + b {b = 2 ^ k , 且 b > i}
        # 所以得出DP方程： dp[i + b] = dp[i] + 1 {i + b < nums and b = 2 ^ k and b > i}
        # 程序的写法：让b = 2^i {i = 0,1,2....} 对于每个b，通过循环已有的dp数组中的所有数(比如t个))推算出下面t个dp的元素
        # 直到i + b > num为止
        dp = [0] * (num + 1)
        b = 1
        while b <= num:
            i = 0
            while i < b and b + i <= num:
                dp[i + b] = dp[i] + 1
                i += 1
            b <<= 1
        return dp

###############################################################################

        # 解法2：比较容易看出来，也是DP
        # 对于一个数 i , 其二进制向右移动一位后，所得到的数正好为：i // 2(这是很明显的，因为移掉最低位表示除以2)
        # 对于移除的最低位，可能为0，也可能为1，这取决于i为奇数或者为偶数,如果i为奇数，那么i肯定比i//2多一个1，否则等于。
        # 那么通过上面分析可以得出DP方程：
        # dp[i] = dp[i // 2] + i % 2
        dp = [0 for _ in range(num + 1)] 
        for i in range(1, num + 1):
            dp[i] = dp[i >> 1] + (i & 1)
        return dp


###############################################################################

        # 解法3，我们可以将数i的最低位1变换为0，那么中1的个数就是变换后的数的1的个数 + 1
        # 循环过程中，变换后的数必然 < i，已经计算出来了，所以可以递推
        dp = [0 for _ in range(num + 1)] 
        for i in range(1, num + 1):
            dp[i] = dp[i & (i - 1)] + 1
        return dp













