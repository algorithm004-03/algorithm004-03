//51. N皇后


//解法1：回溯+Set		执行用时：9ms
//思路：由于皇后的攻击范围是所在的行/列/对角线 ,因此在某一行放置了一个皇后, 该行不可能再放置第二个皇后
//    	因此我们只需要对行数作记录, 判断每一列的位置是否available即可
//		通过3个Set分别存放当前皇后所占据的列,左/右对角线, 下一个皇后在放置之前通过Set判断当前位置是否可以放置
Set<Integer> cols = new HashSet<>(), diag1 = new HashSet<>(), diag2 = new HashSet<>();
public List<List<String>> solveNQueens(int n) {
	List<List<String>> res = new ArrayList<>();
	recur(n, 0, new ArrayList<>(), res);
	return res;
}

private void recur(int n, int row, List<String> temp, List<List<String>> res) {
	if (row == n) {
		res.add(new ArrayList<>(temp));
		return;
	}
	for (int i = 0; i < n; i++) {
		if (cols.contains(i) || diag1.contains(row - i) || diag2.contains(row + i)) continue;
		char[] charArr = new char[n];
		Arrays.fill(charArr, '.');
		charArr[i] = 'Q';
		temp.add(String.valueOf(charArr));
		cols.add(i);
		diag1.add(row - i);
		diag2.add(row + i);
		recur(n, row + 1, temp, res);
		temp.remove(temp.size() - 1);
		cols.remove(i);
		diag1.remove(row - i);
		diag2.remove(row + i);
	}
}

//解法2：回溯 + boolean[]	执行用时：3ms
boolean[] cols, diag1, diag2;
public List<List<String>> solveNQueens(int n) {
	cols = new boolean[n];
	diag1 = new boolean[n * 2];
	diag2 = new boolean[n * 2];
	List<List<String>> res = new ArrayList<>();
	recur(n, 0, new ArrayList<>(), res);
	return res;
}

private void recur(int n, int row, List<String> temp, List<List<String>> res) {
	if (row == n) {
		res.add(new ArrayList<>(temp));
		return;
	}
	for (int i = 0; i < n; i++) {
		if (cols[i] || diag1[row + i] || diag2[row - i + n - 1]) continue;
		char[] charArr = new char[n];
		Arrays.fill(charArr, '.');
		charArr[i] = 'Q';
		temp.add(String.valueOf(charArr));
		cols[i] = true;
		diag1[row + i] = true;
		diag2[row - i + n - 1] = true;
		recur(n, row + 1, temp, res);
		temp.remove(temp.size() - 1);
		cols[i] = false;
		diag1[row + i] = false;
		diag2[row - i + n - 1] = false;
	}
}

//解法3：Bitmask		执行用时：2ms
public List<List<String>> solveNQueens(int n) {
	List<List<String>> res = new ArrayList<>();
	int size = (1 << n) - 1;
	recur(n, size, 0, 0, 0, new ArrayList<>(), res);
	return res;
}

private void recur(int n, int size, int cols, int diag1, int diag2, List<String> temp, List<List<String>> res) {
	if (cols == size) {
		res.add(new ArrayList<>(temp));
		return;
	}
	int pos = size & (~ (cols | diag1 | diag2));
	while (pos != 0) {
		int p = pos & (-pos);
		pos -= p;
		char[] charArr = new char[n];
		Arrays.fill(charArr, '.');
		charArr[n - 1 - getPositionOfQueen(p)] = 'Q';
		temp.add(String.valueOf(charArr));
		recur(n, size, p | cols, (p | diag1) << 1, (p | diag2) >> 1, temp, res);
		temp.remove(temp.size() - 1);
	}
}

private int getPositionOfQueen(int n) {
	return (int)(Math.log(n)/Math.log(2));
}