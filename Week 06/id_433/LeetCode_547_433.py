class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        n = len(M)
        visited = [0]*n
        count = 0

        queue = []
        for i in range(n):
            if visited[i] == 0:
                count += 1
                queue.append(i)

                while queue:
                    curr = queue.pop(0)
                    for j in range(n):
                        if M[curr][j] == 1 and visited[j] == 0:
                            visited[curr] = 1
                            queue.append(j)

        return count