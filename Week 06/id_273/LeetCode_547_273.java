//547. 朋友圈

//解法1：图的深度优先遍历	执行用时：2ms
//思路：把问题转换成图的深度优先遍历, 
//		假设：学生0和学生1互为朋友, 那么可以想象节点0和节点1联通
//			  学生2自己在一个朋友圈, 那么节点2不与任何节点联通
//		深度优先遍历一次图, 那么就可以发现一个朋友圈 
//		我们只需要深度遍历所有的节点, 就能获取所有的朋友圈数（注意判断之前访问过的节点）
//时间复杂度：O(N^2)
//空间复杂度：O(N)
public int findCircleNum(int[][] M) {
	boolean[] visited = new boolean[M.length];
	int count = 0;
	for (int i = 0; i < M.length; i++) {                
		if (visited[i]) continue;
		dfs(visited, i, M);
		count++;                
	}
	return count;
}

private void dfs(boolean[] visited, int i, int[][] M) {
	for (int j = 0; j < visited.length; j++) {
		if (M[i][j] == 1 && !visited[j]) {
			visited[j] = true;
			dfs(visited, j, M);
		}
	}
}

//解法2：并查集		执行用时：7ms
//思路：首先明确问题本质是寻找二维坐标下联通图的个数, 那么问题可以通过并查集解决
//		创建并查集数组, 初始化该数组, 每个节点都指向自己
//		遍历二维坐标, 如果发现两两节点存在联通的情况, 就在并查集数组中合并两个节点
//		最后并查集长度 - 并查集合并次数 = result
//时间复杂度：O(M.length^2 * 联通图的最大长度)
public int findCircleNum(int[][] M) {
	int[] parent = new int[M.length];
	int count = parent.length;
	for (int i = 0; i < M.length; i++) {
		parent[i] = i;
	}  
	for (int i = 0; i < M.length; i++) {
		for (int j = 0; j < M.length; j++) {
			if (i != j && M[i][j] == 1) union(parent, i, j);
		}
	} 
	for (int i = 0; i < parent.length; i++) {
		if (parent[i] != i) count--;
	}
	return count;
}

private void union(int[] parent, int i, int j) {
	int x = find(i, parent);
	int y = find(j, parent);
	if (x == y) return;
	parent[x] = y;
}

private int find(int index, int[] parent) {
	while (parent[index] != index) {
		index = parent[parent[index]];
		 // index = parent[index];   空间压缩 
	}
	return index;
}