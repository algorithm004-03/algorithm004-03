#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: number_of_islands.py
    @time: 2019/11/23 17:47
"""


class Solution(object):
    """
        给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，
        并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

        示例 1:
        输入:
        11110
        11010
        11000
        00000
        输出: 1

        示例 2:
        输入:
        11000
        11000
        00100
        00011
        输出: 3

    """

    def num_is_lands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int

        分析：
        dfs的实现思路是以一个陆地为起点，将与之相连的陆地全部遍历，遍历完成，岛屿计数加1
        """
        if not grid:
            return 0

        def dfs(x, y):
            # 显示的terminator
            if x < 0 or y < 0 or x >= m or y >= n or grid[x][y] != '1':
                return

            grid[x][y] = '#'  # 标记当前的(x, y)位置已被处理，标记为#或者是水域都可以，因为已完成计数

            for (dx, dy) in ((-1, 0), (1, 0), (0, -1), (0, 1)):
                dfs(x + dx, y + dy)  # 注意这里的x, y = x + dx, y + dy; dfs(x, y)这样书写的方式不可以

        m, n, cnt = len(grid), len(grid[0]), 0

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    dfs(i, j)  # 将与（i，j）陆地相关联的陆地都完成遍历，并标示完成遍历的陆地已被处理，然后岛屿数加1
                    cnt += 1

        return cnt

    def num_is_lands2(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int

        分析：
        dfs的实现思路是以一个陆地为起点，将与之相连的陆地全部遍历，遍历完成，岛屿计数加1
        """
        if not grid:
            return 0

        def dfs(x, y):
            # 不显示的terminator
            grid[x][y] = '#'

            for (dx, dy) in ((-1, 0), (1, 0), (0, -1), (0, 1)):
                next_x, next_y = x + dx, y + dy

                if 0 <= next_x < m and 0 <= next_y < n and grid[next_x][next_y] == '1':
                    dfs(next_x, next_y)

        m, n, cnt = len(grid), len(grid[0]), 0

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    dfs(i, j)  # 将与（i，j）陆地相关联的陆地都完成遍历，并标示完成遍历的陆地已被处理，然后岛屿数加1
                    cnt += 1

        return cnt

    def num_is_lands3(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int

        bfs思想，没有使用递归，将满足条件的陆地放入队列中，先进先出的处理。当把所有连在一起的陆地处理完成后，则一个岛屿处理完成；
        然后再处理下一个岛屿
        """
        from collections import deque

        if not grid:
            return 0

        m, n, cnt, visited = len(grid), len(grid[0]), 0, set()

        def bfs(x, y):
            queue = deque()
            queue.append((x, y))
            visited.add((x, y))  # 标示当前位置已被处理

            while queue:
                x, y = queue.popleft()

                for (dx, dy) in ((0, 1), (1, 0), (0, -1), (-1, 0)):
                    next_x, next_y = x + dx, y + dy

                    if 0 <= next_x < m and 0 <= next_y < n \
                            and grid[next_x][next_y] == '1' and (next_x, next_y) not in visited:
                        visited.add((next_x, next_y))
                        queue.append((next_x, next_y))

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1' and (i, j) not in visited:
                    bfs(i, j)
                    cnt += 1

        return cnt

    def num_is_lands4(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int

        bfs思想，没有使用递归，将满足条件的陆地放入队列中，先进先出的处理。当把所有连在一起的陆地处理完成后，则一个岛屿处理完成；
        然后再处理下一个岛屿
        """
        from collections import deque

        if not grid:
            return 0

        m, n, cnt = len(grid), len(grid[0]), 0

        def bfs(x, y):
            queue = deque()
            queue.append((x, y))
            grid[x][y] = '#'  # 标示当前位置已被处理，修改的全局grid

            while queue:
                x, y = queue.popleft()

                for (dx, dy) in ((0, 1), (1, 0), (0, -1), (-1, 0)):
                    next_x, next_y = x + dx, y + dy

                    if 0 <= next_x < m and 0 <= next_y < n and grid[next_x][next_y] == '1':
                        grid[next_x][next_y] = '#'
                        queue.append((next_x, next_y))

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    bfs(i, j)
                    cnt += 1

        return cnt

    def num_is_lands5(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int

        国际站上并查集的解法
        """
        if len(grid) == 0:
            return 0
        row, col = len(grid), len(grid[0])
        self.count = sum(grid[i][j] == '1' for i in range(row) for j in range(col))
        parent = [i for i in range(row * col)]

        def find(x):
            if parent[x] != x:
                return find(parent[x])

            return parent[x]

        def union(x, y):
            xroot, yroot = find(x), find(y)

            if xroot == yroot:
                return

            parent[xroot] = yroot

            self.count -= 1

        for i in range(row):
            for j in range(col):
                if grid[i][j] == '0':
                    continue

                index = i * col + j

                if j < col - 1 and grid[i][j + 1] == '1':
                    union(index, index + 1)

                if i < row - 1 and grid[i + 1][j] == '1':
                    union(index, index + col)

        return self.count

