//51. N皇后


//解法1：回溯+Set		执行用时：16ms
//思路：由于皇后的攻击范围是所在的行/列/对角线 ,因此在某一行放置了一个皇后, 该行不可能再放置第二个皇后
//    	因此我们只需要对行数作记录, 判断每一列的位置是否available即可
//		通过3个Set分别存放当前皇后所占据的列,左/右对角线, 下一个皇后在放置之前通过Set判断当前位置是否可以放置
class {
	private Set<Integer> col = new HashSet<>();
	private Set<Integer> diag1 = new HashSet<>();
	private Set<Integer> diag2 = new HashSet<>();

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		dfs(result, new ArrayList<String>(), n, 0);
		return result;
	}

	private void dfs(List<List<String>> result, List<String> list, int n, int row) {
		if (row == n) {
			result.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i)) continue;
			char[] temp = new char[n];
			Arrays.fill(temp, '.');
			temp[i] = 'Q';
			list.add(new String(temp));
			col.add(i);
			diag1.add(row + i);
			diag2.add(row - i);
			//drill down
			dfs(result, list, n, row + 1);
			//reverse
			list.remove(list.size() - 1);
			col.remove(i);
			diag1.remove(row + i);
			diag2.remove(row - i);
		}
	}
}

//解法2：回溯 + boolean[]
public List<List<String>> solveNQueens(int n) {
	List<List<String>> res = new ArrayList<>();
	recur(n, 0, new boolean[n], new boolean[2 * n], new boolean[2 * n], new ArrayList<>(), res);
	return res;
}

private void recur(int n, int row, boolean[] cols, boolean[] diag1, boolean[] diag2, List<String> temp, List<List<String>> res) {
	if (row == n) {
		res.add(new ArrayList<>(temp));
		return;
	}
	for (int i = 0; i < n; i++) {
		int d1 = row + i;
		int d2 = row - i + n - 1;
		if (cols[i] || diag1[d1] || diag2[d2]) continue;
		cols[i] = true; diag1[d1] = true; diag2[d2] = true;
		char[] charArr = new char[n];
		Arrays.fill(charArr, '.');
		charArr[i] = 'Q';
		temp.add(String.valueOf(charArr));
		recur(n, row + 1, cols, diag1, diag2, temp, res);
		cols[i] = false;
		diag1[d1] = false;
		diag2[d2] = false;
		temp.remove(temp.size() - 1);
	}
}

//解法3：Bitmask
public List<List<String>> solveNQueens(int n) {
	List<List<String>> res = new ArrayList<>();
	int size = (1 << n) - 1;
	recur(n, size, 0, 0, 0, new ArrayList<>(), res);
	return res;
}

private void recur(int n, int size, int row, int diag1, int diag2, List<String> temp, List<List<String>> res) {
	if (row == size) {
		res.add(new ArrayList<>(temp));
		return;
	}
	int pos = size & (~(row | diag1 | diag2));
	while (pos != 0) {
		int p = pos & (-pos);
		pos -= p;
		char[] charArr = new char[n];
		Arrays.fill(charArr, '.');
		charArr[n - logTwo(p) - 1] = 'Q';
		temp.add(String.valueOf(charArr));
		recur(n, size, p | row, (p | diag1) << 1, (p | diag2) >> 1, temp, res);
		temp.remove(temp.size() - 1);
	}
}

private int logTwo(int n) {
	return (int)(Math.log(n)/Math.log(2));
}