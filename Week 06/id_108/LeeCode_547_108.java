package study;

public class LeeCode_547_108 {
	public int findCircleNum(int[][] M) {
		if (M == null && M.length == 0)
			return 0;
		int n = M.length;
		boolean[] visited = new boolean[n];
		int count = 0;
		// 如果dfs大于0，说明有未遍历的结点
		// 只需要遍历所有结点
		for (int i = 0; i < n; i++)
			if (dfs(M, i, visited) > 0)
				count++;
		return count;
	}

    private int dfs(int[][] mat, int i, boolean[] visited) {
        if (visited[i])
            return 0;
        visited[i] = true;
        int count = 1;
        for (int j = 0; j < visited.length; j++)
            if (i != j && mat[i][j] == 1)
                count += dfs(mat, j, visited);
        return count;
    }
}
