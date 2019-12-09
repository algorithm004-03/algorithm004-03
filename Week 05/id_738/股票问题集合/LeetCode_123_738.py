class Solution(object):
    def maxProfit(self, prices):
        """
        股票最佳买卖时机3：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
        
        :type prices: List[int]
        :rtype: int
        """
        # DP
        # 1. 子问题分解: 
        # 如果，定义a[i]为第i天的最大利润，发现问题无法求解，因为这里面涉及到买卖并且限制最大买卖次数问题，故尝试用二维来定义
        # 定义a[i][k]为第i天，买卖k次的最大利润
        # 那么如果第i天不买股票，a[i][k] = a[i - 1][k]
        # 如果第i天买进股票，a[i][k] = max(prices[i] - 第一天买进股票价格, prices[i] - 第二天买进股票价格 + 第一天买卖第k - 1次的最大利润, .... , prices[i] - 第 i - 1 天买进股票价格 + 第 i - 2 天买卖第k - 1次的最大利润)
        # 上述文字用方程表示即：a[i][k] = max(prices[i] - prices[0], prices[i] - prices[1] + a[0][k - 1], ... , prices[i] - prices[i - 1] + a[i - 2][k - 1])
        # 2. 定义状态：a[i][k] {i = [0, len(prices)), k = [0, K=2]}
        # 3. dp方程 a[i][k] = max(a[i - 1][k], prices[i] - prices[0], prices[i] - prices[1] + a[0][k - 1], ... , prices[i] - prices[i - 1] + a[i - 2][k - 1])
        # 初始题解，提交最后一个超大测试用例超时
        # if not prices:
        #     return 0
        # K = 2
        # a = [ [0] * (K + 1) for _ in range(len(prices)) ]
        # for i in range(1, len(prices)):
        #     for k in range(1, K + 1):
        #         mi = prices[0]
        #         for j in range(1, i):
        #             mi = min(mi, (prices[j] - a[j - 1][k - 1]))
        #         a[i][k] = max(a[i - 1][k],  prices[i] - mi)
        # return a[-1][-1]
###############################################################################
        # 优化题解：减去重复计算
        # 上面解法其实存在重复计算：最内层循环 for j in range(i) 每次i增大1，都会重复计算j->i-2次循环体内容
        # 所以可以直接优化，从 for j in range(1) 就开始保留前面已经计算的循环体内容结果，这样 for j in range(2)就可以利用for j in range(1)求解出来的min值再继续和a[2][k - 1]比较即可
        # 所以可以去掉最外层循环 for i in range(1, len(prices))，将最内层循环改成 for i in range(1, len(prices))，同时对于每个交易次数k，最初始的mi一定是prices[0]
        # 如果画出二维方格，我们可以看到，每次更新都是按列递增更新的。
        # if not prices:
        #     return 0
        # K = 2
        # a = [ [0] * (K + 1) for _ in range(len(prices)) ]
        # for k in range(1, K + 1):
        #     mi = prices[0]
        #     for i in range(1, len(prices)):
        #         mi = min(mi, (prices[i] - a[i - 1][k - 1]))
        #         a[i][k] = max(a[i - 1][k],  prices[i] - mi)
        # return a[-1][-1]
###############################################################################
        # 继续优化题解：减去所需的数组空间，化解二维为一维数组
        # 由上面可以看到，我们每次更新都是固定K值，然后按二维网格的列更新的
        # 所以，我们无需存储整个网格内容，只需存储一列的内容即可
        # 由于考虑到 行会比列大，我们点到行列，按行更新的话，就只要一个更小的空间，大小为列数即可
        # 我们要实现行列颠倒，就要存储每一行的上一个最小值：mi = [prices[0]] * (K + 1)

        # if not prices:
        #     return 0
        # K = 2
        # mi = [prices[0]] * (K + 1)
        # a = [ [0] * (K + 1) for _ in range(len(prices)) ]
        # for i in range(1, len(prices)):
        #     for k in range(1, K + 1):
        #         mi[k] = min(mi[k], (prices[i] - a[i - 1][k - 1]))
        #         a[i][k] = max(a[i - 1][k],  prices[i] - mi[k])
        # return a[-1][-1]

###############################################################################

        # 上面能解答出正确答案，但是a还是二维数组，不过下面我们马上把它变成一维数组:
        # 可以看出，按行更新，每次只需要依赖前面一行的数即可，那么我们只需要存储上一行的数

        # if not prices:
        #     return 0
        # K = 2
        # mi = [prices[0]] * (K + 1)
        # a = [0] * (K + 1)
        # for i in range(1, len(prices)):
        #     aa = a[:]
        #     for k in range(1, K + 1):
        #         mi[k] = min(mi[k], (prices[i] - aa[k - 1]))
        #         a[k] = max(aa[k],  prices[i] - mi[k])
        # return a[-1]

###############################################################################

        # 这里有个很别扭的语句：aa = a[:]，我们如果要把它去掉，那么就要让上上的优化这句代码：
        # mi[k] = min(mi[k], (prices[i] - a[i - 1][k - 1])) 变成
        # mi[k] = min(mi[k], (prices[i] - a[i][k - 1]))
        # 这样，a每次都依赖于当前行的k-1值(当前行只有在本次循环才会被更新,所以不需要保留前一行的副本)
        # 其实按照题意，第i天的k-1次买卖，其实和第i - 1天的第k - 1次买卖是相同的
        # 故而mi[k] = min(mi[k], (prices[i] - a[i][k - 1]))是成立的，所以代码可以转化为

        if not prices:
            return 0
        K = 2
        mi = [prices[0]] * (K + 1)
        a = [0] * (K + 1)
        for i in range(1, len(prices)):
            for k in range(1, K + 1):
                mi[k] = min(mi[k], (prices[i] - a[k - 1]))
                a[k] = max(a[k],  prices[i] - mi[k])
        return a[-1]






