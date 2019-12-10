class Solution(object):
    def slidingPuzzle(self, board):
        """
        滑动谜题：https://leetcode-cn.com/problems/sliding-puzzle/

        :type board: List[List[int]]
        :rtype: int
        """
        # BFS
        # 技术处理,将二维结构映射成一维数组，并预先构建0在一维数组中的位置可以移动到的位置
        moves = {
            0: [1, 3],
            1: [0, 2, 4],
            2: [1, 5],
            3: [0, 4],
            4: [1, 3, 5],
            5: [2, 4]
        }
        # 将二维矩阵映射成一个字符串
        s = "".join(str(n) for row in board for n in row)
        step = -1
        q = [s]
        visited = set(q)
        while q:
            step += 1
            new_q = []
            for s in q:
                if s == "123450":
                    return step
                l = list(s)
                zero_index = l.index('0')
                for move in moves[zero_index]:
                    new_l = l[:]
                    new_l[zero_index], new_l[move] = new_l[move], new_l[zero_index]
                    new_s = "".join(new_l)
                    if new_s not in visited:
                        new_q.append(new_s)
                        visited.add(new_s)
            q = new_q
        return -1
















        