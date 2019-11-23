//547. 朋友圈

//解法1：图的深度优先遍历	执行用时：3ms
//思路：把问题转换成图的深度优先遍历, 
//		假设：学生0和学生1互为朋友, 那么可以想象节点0和节点1联通
//			  学生2自己在一个朋友圈, 那么节点2不与任何节点联通
//		深度优先遍历一次图, 那么就可以发现一个朋友圈 
//		我们只需要深度遍历所有的节点, 就能获取所有的朋友圈数（注意判断之前访问过的节点）
//时间复杂度：O(N^2)
//空间复杂度：O(N)
public int findCircleNum(int[][] nums) {
	int[] visited = new int[nums.length];
	int count = 0;
	for (int i = 0; i < nums.length; i++) {
		if (visited[i] == 0) {
			recur(nums, visited, i);
			count++;
		}
	}
	return count;
}

private void recur(int[][] nums, int[] visited, int i) {
	for (int j = 0; j < nums.length; j++) {
		if (nums[i][j] == 1 && visited[j] == 0) {
			visited[i] = 1;
			recur(nums, visited, j);
		}
	}
}

//解法2：并查集		执行用时：7ms
//思路：
public int findCircleNum(int[][] M) {
	int[] parent = new int[M.length];
	for (int i = 0; i < parent.length; i++) {
		parent[i] = i;
	}
	int result = M.length;
	//union
	for (int i = 0; i < M.length; i++) {
		for (int j = 0; j < M.length; j++) {
			if (M[i][j] == 1 && i != j) {//两节点联通
				//在并查集中合并两节点
				union(parent, i, j);
			}
		}
	}
	for (int i = 0; i < M.length; i++) {
		if (parent[i] != i) result--;
	}
	return result;
}

private void union(int[] parent, int i, int j) {
	int x = find(parent, i);//寻找节点A的领头节点
	int y = find(parent, j);//寻找节点B的领头节点
	if (x != y) parent[x] = y;//节点A的领头节点对应并查集中的index指向节点B的领头节点
}

private int find(int[] parent, int p) {
	while (parent[p] != p) {
		parent[p] = parent[parent[p]];  
		p = parent[p];
	}
	return p;
}