//52. N皇后II

//解法1：DFS + 位运算		执行用时：0ms
//思路：递归寻找每一行中能够放置皇后的位置, 成功放置后将之前放置的皇后攻击范围添加上当前皇后的攻击范围作为状态进行下一次深度优先递归
//		重点在于该方法采用二进制数来记录皇后攻击的范围：
//		1. row："p | row"这个操作记录了当前皇后 + 之前皇后能够攻击到的竖向范围
//		2. diag1："(P | diag1) << 1"这个操作记录了当前皇后与之前皇后的左对角线攻击范围
//		3. diag2："(P | diag2) >> 1"这个操作记录了当前皇后与之前皇后的右对角线攻击范围
int size;
int count;
public int totalNQueens(int n) {
	count = 0;
	size = (1 << n) - 1;
	solve(0, 0, 0);
	return count; 
}

private void solve(int row, int diag1, int diag2) {
	//如果NQueens有解, 说明一定分散在同的列上, 因此若row == size, 说明棋盘上已经放了N个皇后
	if (row == size) {
		count++;
		return;
	}
	int pos = size & (~ (row | diag1 | diag2));
	while (pos != 0) {//说明有位置放上皇后
		int p = pos & (-pos);//取最低位1
		pos -= p;
		solve(p | row, (p | diag1) << 1, (p | diag2) >> 1);
	}
}

//解法2：DFS	执行用时：18ms
//思路：基于N皇后的解法稍加修改
Set<Integer> diag1 = new HashSet<>(), diag2 = new HashSet<>(), col = new HashSet<>();
int count;
public int totalNQueens(int n) {
	recur(n, 0);
	return count;
}

private void recur(int n, int row) {
	if (row == n) {
		count++;
		return;
	}
	for (int i = 0; i < n; i++) {
		if (!diag1.contains(row + i) && !diag2.contains(row - i) & !col.contains(i)) {
			diag1.add(row + i);
			diag2.add(row - i);
			col.add(i);
			recur(n, row + 1);
			col.remove(i);
			diag1.remove(row + i);
			diag2.remove(row - i);
		}
	}
}