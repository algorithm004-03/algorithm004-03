from typing import List


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        """
        首先使用的回溯方法，就是不断的添加，列表长度到k就停止，添加列表是由于可变要拷贝一下
        n > k，n > 0， k > 0
        """
        if n < k or n <= 0 or k <= 0:
            return [[]]
        res = []

        def backtrack(b_start, b_list):
            # 出口
            # 如果列表 == 设定值
            if len(b_list) == k:
                # 列表要浅拷贝一下，要不然就改变了
                res.append(b_list[:])
                return
            # 逻辑
            # 把 1-4 造出来
            # k - len(h_list) 空余几个格子
            # k - len(h_list) - 1 剩余的数比可取的数量多1
            for i in range(b_start, n + 1 - (k - len(b_list) - 1)):
                # 没到设点值就加
                b_list.append(i)
                backtrack(i + 1, b_list)
                # 清除数据
                b_list.pop()

        backtrack(1, [])
        return res


s = Solution()
print(s.combine(4, 2))
